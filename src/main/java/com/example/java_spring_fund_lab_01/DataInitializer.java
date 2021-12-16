package com.example.java_spring_fund_lab_01;

import com.example.java_spring_fund_lab_01.models.entities.BaseEntity;
import com.example.java_spring_fund_lab_01.models.entities.Brand;
import com.example.java_spring_fund_lab_01.models.entities.Model;
import com.example.java_spring_fund_lab_01.models.entities.enums.Category;
import com.example.java_spring_fund_lab_01.repositories.BrandRepository;
import com.example.java_spring_fund_lab_01.repositories.ModelRepository;
import com.example.java_spring_fund_lab_01.services.BrandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    public DataInitializer(BrandRepository brandRepository, ModelRepository modelRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Brand fordBrand = new Brand();
        fordBrand.setName("Ford");
        setCurrentTimeStamps(fordBrand);

        Brand hondaBrand = new Brand();
        hondaBrand.setName("Honda");
        setCurrentTimeStamps(hondaBrand);
        this.brandRepository.saveAll(List.of(fordBrand, hondaBrand));
        Model fiesta = initFiesta(fordBrand);
        Model escort = initEscort(fordBrand);
        Model nc750S = initNC750S(hondaBrand);
        this.modelRepository.saveAll(List.of(fiesta, escort,nc750S));
    }

    private Model initNC750S(Brand hondaBrand) {
        Model nc750s = new Model();
        nc750s.setName("NC750S")
                .setCategory(Category.MOTORCYCLE)
                .setImageUrl("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.kB4DaQ5H_OyUKMc35aC5WgHaFj%26pid%3DApi&f=1")
                .setBrand(hondaBrand)
                .setStartYear(2014);
        setCurrentTimeStamps(nc750s);
        return nc750s;
    }

    private Model initEscort(Brand fordBrand) {
        Model escort = new Model();
        escort.setName("Escort")
                .setCategory(Category.CAR)
                .setImageUrl("https://www.automobilemag.com/uploads/sites/11/2017/04/1995-Ford-Escort-RS-Cosworth-Just-Listed-Front-Three-Quarters.jpg")
                .setBrand(fordBrand)
                .setStartYear(1985);
        setCurrentTimeStamps(escort);
        return escort;
    }

    private Model initFiesta(Brand brand) {
        Model fiesta = new Model();
        fiesta.setName("Fiesta")
                .setCategory(Category.CAR)
                .setImageUrl("https://mediacloud.carbuyer.co.uk/image/private/s--5U648ps7--/f_auto,t_content-image-full-desktop@1/v1579643421/carbuyer/2019/04/fiesta-st-ford-performance-edition-limited-to-600-units.jpg")
                .setBrand(brand)
                .setStartYear(1968)
                .setEndYear(2002);
        setCurrentTimeStamps(fiesta);
        return fiesta;
    }

    private static void setCurrentTimeStamps(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now());
        baseEntity.setModified(Instant.now());
    }

}
