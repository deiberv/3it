package com.ingdeiberv.surveys.service;

import com.ingdeiberv.surveys.entity.Style;
import com.ingdeiberv.surveys.repository.StylesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StylesServiceImpl implements StylesService{

  private final Logger log = LoggerFactory.getLogger(StylesServiceImpl.class);

  private final StylesRepository stylesRepository;

  public StylesServiceImpl(StylesRepository stylesRepository) {
    this.stylesRepository = stylesRepository;
  }

  @Override
  public Optional<Style> findById(Long id) {
    return this.stylesRepository.findById(id);
  }

  @Override
  public List<Style> getAll() {
    return this.stylesRepository.findAll(Sort.by("name").ascending());
  }
}
