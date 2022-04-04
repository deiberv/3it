package com.ingdeiberv.surveys.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "surveys")
public class Survey {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  @Column(name = "survey_code")
  private UUID surveyCode;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "style_id")
  private Style style;
  @Column(name = "create_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createAt;

  public Survey() {
  }

  public Survey(Long id, String email, UUID surveyCode, Style style, Date createAt) {
    this.id = id;
    this.email = email;
    this.surveyCode = surveyCode;
    this.style = style;
    this.createAt = createAt;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UUID getSurveyCode() {
    return surveyCode;
  }

  public void setSurveyCode(UUID surveyCode) {
    this.surveyCode = surveyCode;
  }

  public Style getStyle() {
    return style;
  }

  public void setStyle(Style style) {
    this.style = style;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }
}
