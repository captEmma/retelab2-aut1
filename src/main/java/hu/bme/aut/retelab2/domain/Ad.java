package hu.bme.aut.retelab2.domain;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ad {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private int price;

    @CreationTimestamp
    private LocalDateTime creationDate;

    private String secretCode;

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    @Nullable
    private LocalDateTime expiration;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Nullable
    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(@Nullable LocalDateTime expiration) {
        this.expiration = expiration;
    }
}
