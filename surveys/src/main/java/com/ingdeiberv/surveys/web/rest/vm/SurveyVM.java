package com.ingdeiberv.surveys.web.rest.vm;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class SurveyVM {

  @NotNull
  @Email
  private String email;
  @NotNull
  private Long style;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getStyle() {
    return style;
  }

  public void setStyle(Long style) {
    this.style = style;
  }

  @Override
  public String toString() {
    return "SurveyVM{" +
        "email='" + email + '\'' +
        ", style=" + style +
        '}';
  }
}
