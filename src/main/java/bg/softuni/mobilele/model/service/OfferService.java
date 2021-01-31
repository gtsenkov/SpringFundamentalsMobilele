package bg.softuni.mobilele.model.service;

import bg.softuni.mobilele.model.view.OfferSummaryViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

}
