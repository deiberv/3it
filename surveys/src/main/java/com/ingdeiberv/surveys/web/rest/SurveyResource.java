package com.ingdeiberv.surveys.web.rest;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.entity.Survey;
import com.ingdeiberv.surveys.service.StylesService;
import com.ingdeiberv.surveys.service.SurveyService;
import com.ingdeiberv.surveys.service.exception.CreateSurveyException;
import com.ingdeiberv.surveys.web.rest.vm.ResultVM;
import com.ingdeiberv.surveys.web.rest.vm.SurveyVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/survey")
public class SurveyResource {

  private final Logger log = LoggerFactory.getLogger(SurveyResource.class);

  private final SurveyService surveyService;
  private final StylesService stylesService;

  public SurveyResource(SurveyService surveyService, StylesService stylesService) {
    this.surveyService = surveyService;
    this.stylesService = stylesService;
  }

  @PostMapping("/create")
  public ResponseEntity<Survey> create(@Valid @RequestBody SurveyVM surveyVM, BindingResult result)
  {
    if (result.hasErrors()){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    //Se verifica si el estilo existe
    Optional<Style> style = this.stylesService.findById(surveyVM.getStyle());
    if (style.isEmpty()){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estilo musica incorrecto");
    }

    Survey survey = new Survey();
    survey.setEmail(surveyVM.getEmail());
    survey.setStyle(style.get());
    Survey surveyCreated = this.surveyService.add(survey);
    if (surveyCreated == null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe registro de email y estilo de musica en la encuentas");
    }else{
      return ResponseEntity.status(HttpStatus.CREATED).body(surveyCreated);
    }


  }

  @GetMapping("/results")
  public ResponseEntity results()
  {

    List<ResultVM> resultVMList = this.stylesService.getAll().stream().map(item -> {
      Long total = this.surveyService.getTotalByStyle(item);
      ResultVM resultVM = new ResultVM(item.getId(), item.getName(), total);
      return resultVM;
    }).sorted(new Comparator<ResultVM>() {
      @Override
      public int compare(ResultVM o1, ResultVM o2) {
        if (o1.getTotal() > o2.getTotal()){
          return -1;
        }else if (o2.getTotal() > o1.getTotal()){
          return 1;
        }
        return 0;
      }
    }).collect(Collectors.toList());

    return ResponseEntity.ok(resultVMList);
  }
}
