package com.ingdeiberv.surveys.web.rest.vm;

public class ResultVM {

  private Long styleId;
  private String name;
  private Long total;

  public ResultVM(Long styleId, String name, Long total) {
    this.styleId = styleId;
    this.name = name;
    this.total = total;
  }

  public Long getStyleId() {
    return styleId;
  }

  public void setStyleId(Long styleId) {
    this.styleId = styleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }
}
