package com.ingdeiberv.surveys.web.rest;

import com.ingdeiberv.surveys.entity.Survey;
import com.ingdeiberv.surveys.repository.SurveyRepository;
import com.ingdeiberv.surveys.web.rest.vm.SurveyVM;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SurveyResoourceIT {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private SurveyRepository surveyRepository;

  @Test
  void createSurvey() throws Exception {

    int databaseSizeBeforeCreate = surveyRepository.findAll().size();

    SurveyVM surveyVM = new SurveyVM();
    surveyVM.setEmail("deiberv@gmail.com");
    surveyVM.setStyle(6L);

    mockMvc.perform(
      post("/api/survey/create").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(surveyVM))
    ).andExpect(status().isCreated());

    List<Survey> list = surveyRepository.findAll();
    int databaseSizeAfterCreate = list.size();
    Assertions.assertThat(databaseSizeAfterCreate).isEqualTo(databaseSizeBeforeCreate + 1);
    Survey lastSurvey = list.get(databaseSizeAfterCreate - 1);
    Assertions.assertThat(lastSurvey.getEmail()).isEqualTo(surveyVM.getEmail());
    Assertions.assertThat(lastSurvey.getStyle().getId()).isEqualTo(surveyVM.getStyle());
  }

  @Test
  void getResults() throws Exception{
    mockMvc.perform(get("/api/survey/results"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

}
