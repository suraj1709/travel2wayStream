package com.travel2Waystream.api.consumerservice;

import com.travel2Waystream.api.model.Place;

public interface ConsumerListener {

    void consume1(Place place);

    void consume2(Place place);
}
