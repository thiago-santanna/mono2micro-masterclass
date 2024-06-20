package com.tsswebapps.fligth;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Fligth extends PanacheEntity {
    public Long orderId;
    public String fligthFrom;
    public String fligthTo;
}
