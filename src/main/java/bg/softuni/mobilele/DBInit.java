package bg.softuni.mobilele;

import bg.softuni.mobilele.model.entities.BaseEntity;
import bg.softuni.mobilele.model.entities.BrandEntity;
import bg.softuni.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimeStamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimeStamps(hondaBrand);


        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        initEscort(fordBrand);

        initFiesta(fordBrand);

        initNC750S(hondaBrand);

    }

    private ModelEntity initFiesta(BrandEntity fordBrand) {
        ModelEntity fiesta = new ModelEntity();

        fiesta
                .setName("Fiesta")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://media.evo.co.uk/image/private/s--BabPcxyh--/f_auto,t_content-image-full-desktop@1/v1597937930/evo/2020/08/Mk8%20Ford%20Fiesta%20review%20-6.jpg")
                .setStartYear(1976)
                .setBrand(fordBrand);

        setCurrentTimeStamps(fiesta);

        return modelRepository.save(fiesta);
    }
    private ModelEntity initNC750S(BrandEntity hondaBrand){
        ModelEntity NC750S = new ModelEntity();

        NC750S
                .setName("NC750S")
                .setCategory(ModelCategoryEnum.MOTORCYCLE)
                .setImageUrl("https://www.mitchellsmc.co.uk/wp-content/uploads/2020/07/IMG_0686.jpg")
                .setStartYear(2014)
                .setBrand(hondaBrand);

        setCurrentTimeStamps(NC750S);

        return modelRepository.save(NC750S);
    }

    private ModelEntity initEscort(BrandEntity fordBrand) {
        ModelEntity escort = new ModelEntity();

        escort
                .setName("Escort")
                .setCategory(ModelCategoryEnum.CAR)
                .setImageUrl("https://www.investor.bg/images/photos/0154/0000154971-article3.jpg")
                .setStartYear(1968)
                .setEndYear(2002)
                .setBrand(fordBrand);

        setCurrentTimeStamps(escort);

        return modelRepository.save(escort);
    }

    private static void setCurrentTimeStamps(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now());
        baseEntity.setUpdated(Instant.now());
    }
}