package com.example.java_spring_fund_lab_01.services;

import com.example.java_spring_fund_lab_01.models.service.OfferAddServiceModel;
import com.example.java_spring_fund_lab_01.models.view.OfferDetailsView;
import com.example.java_spring_fund_lab_01.models.view.OfferSummaryView;
import com.example.java_spring_fund_lab_01.models.view.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {
    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

    OfferDetailsView findById(Long id, String currentUser);

    void deleteOffer(Long id);

    boolean isOwner(String userName, Long id);

    void updateOffer(OfferUpdateServiceModel offerModel);

    OfferAddServiceModel addOffer(OfferAddBindModel offerAddBindModel, String ownerId);
}
