package com.example.java_spring_fund_lab_01.services.impl;

import com.example.java_spring_fund_lab_01.models.entities.Offer;
import com.example.java_spring_fund_lab_01.models.entities.enums.Engine;
import com.example.java_spring_fund_lab_01.models.entities.enums.Transmission;
import com.example.java_spring_fund_lab_01.models.service.OfferAddServiceModel;
import com.example.java_spring_fund_lab_01.models.view.OfferSummaryViewModel;
import com.example.java_spring_fund_lab_01.repositories.ModelRepository;
import com.example.java_spring_fund_lab_01.repositories.OfferRepository;
import com.example.java_spring_fund_lab_01.repositories.UserRepository;
import com.example.java_spring_fund_lab_01.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository,
                            ModelRepository modelRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
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
    public long saveOffer(OfferAddServiceModel model) {
        Offer offer = asNewEntity(model);
        Offer newEntity = this.offerRepository.save(offer);
        return newEntity.getId();
    }

    @Override
    public void deleteOffer(Long id) {
        this.offerRepository.deleteById(id);
    }

    @Override
    public void initializeOffers() {
        if (offerRepository.count() == 0) {
            Offer offer1 = new Offer();
            offer1
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setEngine(Engine.GASOLINE)
                    .setTransmission(Transmission.MANUAL)
                    .setMileage(22500)
                    .setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcXp1KBpDKgYs6VqndkBpX8twjPOZbHV86yg&usqp=CAU")
                    .setPrice(new BigDecimal(14300))
                    .setYear(2019)
                    .setDescription("Used, but well services and in good condition.")
                    .setSeller(userRepository.findByUsername("pesho")
                            .orElse(null));// or currentUser.getUserName()

            Offer offer2 = new Offer();
            offer2
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setEngine(Engine.DIESEL)
                    .setTransmission(Transmission.AUTOMATIC)
                    .setMileage(209000)
                    .setPrice(new BigDecimal(5500))
                    .setImageUrl(
                            "https://www.picclickimg.com/d/l400/pict/283362908243_/FORD-ESCORT-MK5-16L-DOHC-16v-ZETEC.jpg")
                    .setYear(2000)
                    .setDescription("After full maintenance, insurance, new tires...")
                    .setSeller(userRepository.findByUsername("admin")
                            .orElse(null)); // or currentUser.getUserName()
            
            offerRepository.saveAll(List.of(offer1, offer2));
        }
    }

    private Offer asNewEntity(OfferAddServiceModel model) {
        Offer offer = new Offer();
        this.modelMapper.map(model, offer);
        offer.setId(null);
        offer.setModel(this.modelRepository.findById(model.getModelId()).orElse(null));
        offer.setSeller(this.userRepository.findByUsername(this.currentUser.getName()));
        return offer;
    }
}
