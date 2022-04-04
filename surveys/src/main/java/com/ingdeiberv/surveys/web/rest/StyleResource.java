package com.ingdeiberv.surveys.web.rest;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.service.StylesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class StyleResource {

  private final Logger log = LoggerFactory.getLogger(StyleResource.class);

  private final StylesService stylesService;

  public StyleResource(StylesService stylesService) {
    this.stylesService = stylesService;
  }

  @GetMapping("/styles")
  public ResponseEntity<List<Style>> musicStyles()
  {
    List<Style> styles = this.stylesService.getAll();
    if (styles.isEmpty()){
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(styles);
  }

}
