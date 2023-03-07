package com.pablo.mvc.safetravels.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pablo.mvc.safetravels.models.Trip;

import java.util.List;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
    @Override
    public List<Trip> findAll();
}
