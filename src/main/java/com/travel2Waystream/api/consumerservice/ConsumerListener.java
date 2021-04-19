package com.travel2Waystream.api.consumerservice;

import com.travel2Waystream.api.model.Place;

public interface ConsumerListener {

    public void consume(Place place);
}
