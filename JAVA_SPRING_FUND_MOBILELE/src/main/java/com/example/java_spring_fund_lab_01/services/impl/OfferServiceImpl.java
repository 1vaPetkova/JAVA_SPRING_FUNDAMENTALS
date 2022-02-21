package com.example.java_spring_fund_lab_01.services.impl;

import com.example.java_spring_fund_lab_01.models.binding.OfferAddBindingModel;
import com.example.java_spring_fund_lab_01.models.entities.Offer;
import com.example.java_spring_fund_lab_01.models.entities.enums.EngineEnum;
import com.example.java_spring_fund_lab_01.models.entities.enums.TransmissionEnum;
import com.example.java_spring_fund_lab_01.models.service.OfferAddServiceModel;
import com.example.java_spring_fund_lab_01.models.service.OfferUpdateServiceModel;
import com.example.java_spring_fund_lab_01.models.view.OfferDetailsView;
import com.example.java_spring_fund_lab_01.models.view.OfferSummaryView;
import com.example.java_spring_fund_lab_01.repositories.ModelRepository;
import com.example.java_spring_fund_lab_01.repositories.OfferRepository;
import com.example.java_spring_fund_lab_01.repositories.UserRepository;
import com.example.java_spring_fund_lab_01.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
    public void initializeOffers() {
        if (offerRepository.count() == 0) {
            Offer offer1 = new Offer();
            offer1
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setEngine(EngineEnum.GASOLINE)
                    .setTransmission(TransmissionEnum.MANUAL)
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
                    .setEngine(EngineEnum.DIESEL)
                    .setTransmission(TransmissionEnum.AUTOMATIC)
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

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return this.offerRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findById(Long id, String currentUser) {
        OfferDetailsView offerDetailsView = this.offerRepository.
                findById(id).
                map(o -> mapDetailsView(currentUser, o))
                .get();
        return offerDetailsView;
    }


    @Override
    public void deleteOffer(Long id) {
        this.offerRepository.deleteById(id);
    }

    @Override
    public boolean isOwner(String userName, Long id) {
        return false;
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel offerModel) {

    }

    @Override
    public OfferAddServiceModel addOffer(OfferAddBindingModel offerAddBindModel, String ownerId) {
        return null;
    }


    private OfferSummaryView map(Offer offerEntity) {
        OfferSummaryView summaryView = this.modelMapper
                .map(offerEntity, OfferSummaryView.class);

        summaryView.setModel(offerEntity.getModel().getName());
        summaryView.setBrand(offerEntity.getModel().getBrand().getName());

        return summaryView;
    }

    private OfferDetailsView mapDetailsView(String currentUser, Offer offer) {
        OfferDetailsView offerDetailsView = this.modelMapper.map(offer, OfferDetailsView.class);
        offerDetailsView.setCanDelete(isOwner(currentUser, offer.getId()));
        offerDetailsView.setModel(offer.getModel().getName());
        offerDetailsView.setBrand(offer.getModel().getBrand().getName());
        offerDetailsView.setSellerFullName(
                offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());
        return offerDetailsView;
    }
}
