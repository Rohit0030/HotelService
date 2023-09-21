package com.rohit.hotel.service.impl;

import com.rohit.hotel.entities.Hotel;
import com.rohit.hotel.exception.ResourceNotFoundException;
import com.rohit.hotel.repositories.HotelRepository;
import com.rohit.hotel.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelServices {


    @Autowired
    private HotelRepository hotelRepository;

    
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("😒😒 Hotel with given id not found 🥱!!!!"));
    }
}
