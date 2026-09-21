package com.microservices.payment_service.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "payment") 
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class Payment implements Serializable{

    @Id    
    @GeneratedValue (strategy = GenerationType.UUID) 
    private String id;

    @Column (nullable = false)
    private String orderId;

    @Column (nullable = false)
    private String userId;

    @Column (nullable = false)
    private String amount;

    private String transactionId;

    @Column (nullable = false)
    @Builder.Default
    private String status = PaymentStatus.PENDING.getPaymentStatus();

    private String failureMsg;
    private LocalDateTime processedAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onPrePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
