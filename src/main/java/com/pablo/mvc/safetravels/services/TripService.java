package com.pablo.mvc.safetravels.services;

import com.pablo.mvc.safetravels.models.Trip;
import com.pablo.mvc.safetravels.respositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    //    private final TripRepository tripRepo;
//    public TripService(TripRepository tripRepo) {
//        this.tripRepo = tripRepo;
//    }
    @Autowired
    private TripRepository tripRepo;
    public List<Trip> findAll() {
        return tripRepo.findAll();
    }
    public Trip create(Trip x) {
        return tripRepo.save(x);
    }

    public Trip findOneById (Long id) {
        Optional<Trip> optionalTrip = tripRepo.findById(id);
        if (optionalTrip.isPresent()){
            return optionalTrip.get();
        }
        else{
            return null;
        }
    }
    public Trip update(Trip x) {
        return tripRepo.save(x);
    }
    public void delete(Long id) {
        tripRepo.deleteById(id);
    }




}
