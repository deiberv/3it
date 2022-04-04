package com.ingdeiberv.surveys.service;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.entity.Survey;
import com.ingdeiberv.surveys.repository.SurveyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SurveyServiceIT {
  @Autowired
  SurveyRepository surveyRepository;

  @Autowired
  SurveyService surveyService;


  @Test
  void assertThatGetSurvey(){
    //Se registra la encuenta
    Survey survey = new Survey();
    survey.setEmail("deiberv@gmail.com");
    survey.setStyle(new Style(5L,"Salsa"));
    this.surveyService.add(survey);
    //Se verifica la obtensiòn de las encuentas
    List<Survey> surveyList = surveyService.findAll();
    //Es Iigual a 1 ya que solo es el el registro
    Assertions.assertThat(surveyList.size()).isEqualTo(1);
  }

  @Test
  @Transactional
  void assertThatSurveyAdded()
  {
    Survey survey = new Survey();
    survey.setEmail("deiberv@gmail.com");
    survey.setStyle(new Style(5L,"Salsa"));
    Survey surveyDb = this.surveyService.add(survey);

    Assertions.assertThat(surveyDb.getId()).isNotNull();
  }

  @Test
  void assertThatGetTotalPerStyle()
  {
    Style style = new Style(4L,"Clásica");
    Survey survey = new Survey();
    survey.setEmail("deiberv@gmail.com");
    survey.setStyle(style);
    this.surveyService.add(survey);

    survey.setEmail("deiberv25@gmail.com");
    survey.setStyle(style);
    this.surveyService.add(survey);

    Long total = this.surveyService.getTotalByStyle(style);
    Assertions.assertThat(total).isEqualTo(2);

  }

  @Test
  void assertOneEmailPerStyle(){
    Style style = new Style(1L,"Rock");
    Survey survey = new Survey();
    survey.setEmail("deiberv@gmail.com");
    survey.setStyle(style);
    this.surveyService.add(survey);
    Optional<Survey> check = this.surveyService.checkEmailAndStyle(survey.getEmail(), survey.getStyle());
    Assertions.assertThat(check).isPresent();
  }

}
