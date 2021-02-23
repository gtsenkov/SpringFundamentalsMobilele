package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.ModelRepository;
import bg.softuni.mobilele.model.OfferRepository;
import bg.softuni.mobilele.model.UserRepository;
import bg.softuni.mobilele.model.entities.OfferEntity;
import bg.softuni.mobilele.model.service.OfferServiceModel;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.service.OfferService;
import bg.softuni.mobilele.model.view.OfferSummaryViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        //todo implement mapping
        throw new UnsupportedOperationException("Comming soon");
    }

    @Override
    public long save(OfferServiceModel model) {
        OfferEntity offerEntity = asNewEntity(model);
        OfferEntity newEntity = offerRepository.save(offerEntity);
        return newEntity.getId();
    }

    @Override
    public void delete(long id) {
        offerRepository.deleteById(id);
    }

    private OfferEntity asNewEntity(OfferServiceModel model) {
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(model, offerEntity);
        offerEntity.setId(null);

        offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
        offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());

        return offerEntity;
    }

}
