package com.example.java_spring_fund_lab_01.services;

import com.example.java_spring_fund_lab_01.models.view.OfferViewDto;

import java.util.List;

public interface OfferService {
    List<OfferViewDto> getAllOffers();
}
