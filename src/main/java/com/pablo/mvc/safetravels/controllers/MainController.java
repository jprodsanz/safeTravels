package com.pablo.mvc.safetravels.controllers;
import com.pablo.mvc.safetravels.models.Trip;
import com.pablo.mvc.safetravels.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private TripService tripServ;
    @GetMapping("/")
    public String index(Model model ) {
        // retrieves all books from DB
            List<Trip> allTrips = tripServ.findAll();
        // Stores [ ] in model
            model.addAttribute("allTrips", allTrips);
        return "index.jsp";
    }
    @GetMapping("/trip/new")
    public String newTrip(@ModelAttribute("newTrip") Trip newTrip) {
        return "newTrip.jsp";
    }
    @PostMapping("/trip/new")
    public String createTrip(@Valid @ModelAttribute("newTrip") Trip newTrip, BindingResult result) {
        if (result.hasErrors()) {
            return "newTrip.jsp";
        }
        tripServ.create(newTrip);
        return "redirect:/";
    }
    @DeleteMapping("/trip/{id}")
    public String deleteTrip(@PathVariable("id")Long id) {
        tripServ.delete(id);
        return "redirect:/";
    }
    @GetMapping("/trip/{id}")
    public String editTrip (@PathVariable("id") Long id, Model model ) {
        model.addAttribute("trip", tripServ.findOneById(id));
        return "editTrip.jsp";
    }
    @PutMapping("/trip/{id}")
    public String updateTrip(@Valid @ModelAttribute
            ("trip") Trip trip, BindingResult result, @PathVariable("id")Long id) {
        if(result.hasErrors()){
            return "editTrip.jsp";
        }
        trip.setId(id);
        tripServ.update(trip);
        return "redirect:/";
    }
}
