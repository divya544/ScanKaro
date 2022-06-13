package com.scanKaro.controller;

import com.scanKaro.dto.Guest;
import com.scanKaro.repository.GuestRepo;
import com.scanKaro.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GuestController {

    @Autowired
    GuestRepo guestRepo;

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody Guest newGuest) {
        List<Guest> guests = guestRepo.findAll();
        System.out.println("New guest: " + newGuest.toString());
        for (Guest guest : guests) {
            System.out.println("Registered guest: " + newGuest.toString());
            if (guest.equals(newGuest)) {
                System.out.println("Guest Already exists!");
                return Status.GUEST_ALREADY_EXISTS;
            }
        }
        guestRepo.save(newGuest);
        return Status.SUCCESS;
    }
    @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody Guest guest) {
        List<Guest> guests = guestRepo.findAll();
        for (Guest other : guests) {
            if (other.equals(guest)) {
                guest.setLoggedIn(true);
                guestRepo.save(guest);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody Guest guest) {
        List<Guest> guests = guestRepo.findAll();
        for (Guest other : guests) {
            if (other.equals(guest)) {
                guest.setLoggedIn(false);
                guestRepo.save(guest);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        guestRepo.deleteAll();
        return Status.SUCCESS;
    }

}
