package com.example.java_spring_fund_lab_01.services;


import com.example.java_spring_fund_lab_01.models.view.StatsView;

public interface StatsService {
  void onRequest();
  StatsView getStats();
}
