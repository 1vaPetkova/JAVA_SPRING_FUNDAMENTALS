package com.example.java_spring_fund_lab_01.service;

import com.example.java_spring_fund_lab_01.model.view.StatsView;

public interface StatsService {
  void onRequest();
  StatsView getStats();
}
