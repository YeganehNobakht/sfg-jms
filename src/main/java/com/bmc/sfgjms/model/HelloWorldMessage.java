package com.bmc.sfgjms.model;

import lombok.*;
import org.jgroups.util.UUID;

import java.io.Serializable;

/**
 * @author Masoumeh Yeganeh
 * @created 23/05/2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldMessage implements Serializable {

    private static final long serialVersionID = 4202584L;
    private UUID id;
    private String message;
}
