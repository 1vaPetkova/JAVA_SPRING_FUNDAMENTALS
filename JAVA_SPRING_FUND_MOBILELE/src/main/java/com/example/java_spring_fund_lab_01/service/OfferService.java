package com.example.java_spring_fund_lab_01.service;


import com.example.java_spring_fund_lab_01.model.binding.OfferAddBindModel;
import com.example.java_spring_fund_lab_01.model.service.OfferAddServiceModel;
import com.example.java_spring_fund_lab_01.model.service.OfferUpdateServiceModel;
import com.example.java_spring_fund_lab_01.model.view.OfferDetailsView;
import com.example.java_spring_fund_lab_01.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {
  void initializeOffers();

  List<OfferSummaryView> getAllOffers();

  OfferDetailsView findById(Long id);

  void deleteOffer(Long id);

  void updateOffer(OfferUpdateServiceModel offerModel);

  OfferAddServiceModel addOffer(OfferAddBindModel offerAddBindModel);
}
