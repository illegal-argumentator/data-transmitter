package com.iglin.data_transmitter.domain.smartmoving.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lead {

    String fullName;
    String email;
    String phoneNumber;

}
