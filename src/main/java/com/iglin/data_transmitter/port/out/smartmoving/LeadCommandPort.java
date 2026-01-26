package com.iglin.data_transmitter.port.out.smartmoving;

import com.iglin.data_transmitter.domain.smartmoving.model.Lead;

public interface LeadCommandPort {

    void save(Lead lead);

}
