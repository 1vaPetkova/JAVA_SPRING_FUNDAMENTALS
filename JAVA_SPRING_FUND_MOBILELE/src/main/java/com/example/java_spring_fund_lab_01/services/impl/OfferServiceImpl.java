package com.example.java_spring_fund_lab_01.services.impl;

import com.example.java_spring_fund_lab_01.models.entities.Offer;
import com.example.java_spring_fund_lab_01.models.service.OfferServiceModel;
import com.example.java_spring_fund_lab_01.models.view.OfferSummaryViewModel;
import com.example.java_spring_fund_lab_01.repositories.ModelRepository;
import com.example.java_spring_fund_lab_01.repositories.OfferRepository;
import com.example.java_spring_fund_lab_01.repositories.UserRepository;
import com.example.java_spring_fund_lab_01.security.CurrentUser;
import com.example.java_spring_fund_lab_01.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, CurrentUser currentUser, UserRepository userRepository,
                            ModelRepository modelRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        //TODO
        return null;
    }

    @Override
    public long saveOffer(OfferServiceModel model) {
        Offer offer = asNewEntity(model);
        Offer newEntity = this.offerRepository.save(offer);
        return newEntity.getId();
    }

    @Override
    public void deleteOffer(Long id) {
        this.offerRepository.deleteById(id);
    }

    private Offer asNewEntity(OfferServiceModel model) {
        Offer offer = new Offer();
        this.modelMapper.map(model, offer);
        offer.setId(null);
        offer.setModel(this.modelRepository.findById(model.getModelId()).orElse(null));
        offer.setSeller(this.userRepository.findByUsername(this.currentUser.getName()));
        return offer;
    }
}
