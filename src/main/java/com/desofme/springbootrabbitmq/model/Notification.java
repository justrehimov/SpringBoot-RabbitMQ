package com.desofme.springbootrabbitmq.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification implements Serializable {
    private String id;
    private Date createdAt;
    private Boolean seen;
    private String message;
}
