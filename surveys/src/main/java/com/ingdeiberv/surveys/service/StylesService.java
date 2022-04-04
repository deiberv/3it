package com.ingdeiberv.surveys.service;

import com.ingdeiberv.surveys.entity.Style;

import java.util.List;
import java.util.Optional;

public interface StylesService {
  public Optional<Style> findById(Long id);
  public List<Style> getAll();
}
