package com.pablo.mvc.safetravels.models;
import javax.validation.constraints.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="trips")

public class Trip {
    // Unique ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Expense
        @NotBlank // use NotBlank instead of NotNull for strings to avoid val errors
        @Size(min = 1, max = 30, message="Expense name can't be blank")
        private String name ;
    // Vendor
        @NotBlank
        @Size(min = 1, max = 30, message="Vendor must not be blank ")
        private String vendor ;
    // Amount
        @NotNull(message = "Amount can't be blanked")
        @Min(value=0, message="You better spend top dollar")
        private Double amount;
    // Description
        @NotBlank
        @Size(min =1, max = 150, message ="Where are you going")
        private String description;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Trip() {
    }

//     Moving forward, when using a form/form  having the constructor below won't be necessary
//    public Burger(String burgerName, String restName, int rating, String  notes) {
//        this.burgerName = burgerName;
//        this.restName = restName;
//        this.rating = rating;
//        this.notes = notes;
//    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String  description) {
        this.description = description;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

// Specifies a callback method for the corresponding lifecycle event...
// This annotation may be applied to methods of an entity class, a mapped superclass or
// a call back listener class
// this annotation helps so users cannot modify the created at and updated at

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}


