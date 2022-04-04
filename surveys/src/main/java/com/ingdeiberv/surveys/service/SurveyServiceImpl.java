package com.ingdeiberv.surveys.service;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.entity.Survey;
import com.ingdeiberv.surveys.repository.SurveyRepository;
import com.ingdeiberv.surveys.service.exception.CreateSurveyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SurveyServiceImpl implements  SurveyService{

  private final Logger log = LoggerFactory.getLogger(SurveyServiceImpl.class);

  private final SurveyRepository surveyRepository;

  public SurveyServiceImpl(SurveyRepository surveyRepository) {
    this.surveyRepository = surveyRepository;
  }

  @Override
  @Transactional
  public Survey add(Survey survey) {

    Optional<Survey> checkSurvey = this.checkEmailAndStyle(survey.getEmail(),survey.getStyle());
    if (checkSurvey.isPresent()){
      return null;
    }

    survey.setSurveyCode(UUID.randomUUID());
    survey.setCreateAt(new Date());
    return this.surveyRepository.save(survey);
  }

  @Override
  public List<Survey> findAll() {
    return this.surveyRepository.findAll();
  }

  @Override
  public Long getTotalByStyle(Style style) {
    return this.surveyRepository.countByStyle(style);
  }

  @Override
  public Optional<Survey> checkEmailAndStyle(String email, Style style) {
    return this.surveyRepository.findByEmailAndStyle(email,style);
  }
}
