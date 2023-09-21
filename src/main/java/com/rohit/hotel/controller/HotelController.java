package com.rohit.hotel.controller;

import com.rohit.hotel.entities.Hotel;
import com.rohit.hotel.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController

{

    @Autowired
    private HotelServices hotelServices;
    //create

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelServices.create(hotel));
    }


    //get single

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelServices.get(hotelId));
    }

    //get all

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelServices.getAll());
    }

}
