package com.ingdeiberv.surveys.service;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.repository.StylesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class StyleServiceIT {
  @Autowired
  StylesRepository stylesRepository;

  @Autowired
  StylesService stylesService;

  @Test
  void assertThatGetStyles(){
    List<Style> styles = stylesService.getAll();
    Assertions.assertThat(styles.size()).isEqualTo(6);
  }

  @Test
  void assertThatGetStyleById(){
    Optional<Style> style= stylesService.findById(5L);
    Assertions.assertThat(style).isPresent();
  }


}
