package com.rohit.hotel.service;

import com.rohit.hotel.entities.Hotel;

import java.util.List;

public interface HotelServices {

    // created
    Hotel create(Hotel hotel);

    // get all

    List<Hotel> getAll();

    //get single hotel

    Hotel get(String id);
}
