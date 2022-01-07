package com.example.java_spring_fund_lab_01.services;

import com.example.java_spring_fund_lab_01.models.service.OfferServiceModel;
import com.example.java_spring_fund_lab_01.models.view.OfferSummaryViewDto;

import java.util.List;

public interface OfferService {
    List<OfferSummaryViewDto> getAllOffers();

    long saveOffer(OfferServiceModel model);
}
