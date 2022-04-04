package com.ingdeiberv.surveys.repository;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
  Long countByStyle(Style style);
  Optional<Survey> findByEmailAndStyle(String email, Style style);
}