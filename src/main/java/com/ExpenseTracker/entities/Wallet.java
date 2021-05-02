package com.ExpenseTracker.entities;

import javax.annotation.PreDestroy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@NotBlank(message = "Invalid Name")
	@Size(min = 2,max=30)
	private String name;
	@Size(min = 2,max= 30)
	private String accountNumber;
	@Size(max = 100)
	private String description;
	@Min(1)
	@Max(3)
	private Integer priority;
	private Double currentBalance;
	@PrePersist
	public void setBalance() {
		this.currentBalance = new Double(0);
	}	
}
