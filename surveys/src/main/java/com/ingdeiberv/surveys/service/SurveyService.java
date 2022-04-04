package com.ingdeiberv.surveys.service;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.entity.Survey;
import com.ingdeiberv.surveys.service.exception.CreateSurveyException;

import java.util.List;
import java.util.Optional;

public interface SurveyService {
  public Survey add(Survey survey);
  public List<Survey> findAll();
  public Long getTotalByStyle(Style style);
  public Optional<Survey> checkEmailAndStyle(String email, Style style);
}
