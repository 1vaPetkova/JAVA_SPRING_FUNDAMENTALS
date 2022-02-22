package com.example.java_spring_fund_lab_01.model.view;

public class StatsView {

  private final int authRequests;
  private final int anonRequests;

  public StatsView(int authRequests, int anonRequests) {
    this.authRequests = authRequests;
    this.anonRequests = anonRequests;
  }

  public int getTotalRequests() {
    return anonRequests + authRequests;
  }

  public int getAuthRequests() {
    return authRequests;
  }


  public int getAnonRequests() {
    return anonRequests;
  }

}
