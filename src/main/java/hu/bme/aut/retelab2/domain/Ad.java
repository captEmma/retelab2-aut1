package hu.bme.aut.retelab2.domain;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Ad {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private int price;

    @CreationTimestamp
    private Date creationTime;
}
