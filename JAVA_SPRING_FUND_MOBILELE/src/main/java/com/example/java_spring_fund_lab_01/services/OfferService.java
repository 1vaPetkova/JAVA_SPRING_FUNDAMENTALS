package com.example.java_spring_fund_lab_01.services;

import com.example.java_spring_fund_lab_01.models.service.OfferServiceModel;
import com.example.java_spring_fund_lab_01.models.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {
    List<OfferSummaryViewModel> getAllOffers();

    long saveOffer(OfferServiceModel model);

    void deleteOffer(Long id);
}
