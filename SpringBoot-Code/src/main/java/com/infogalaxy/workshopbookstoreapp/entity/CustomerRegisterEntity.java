package com.infogalaxy.workshopbookstoreapp.entity;

import com.infogalaxy.workshopbookstoreapp.dto.CustomerRegisterDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class CustomerRegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Firstname is Required.")
    private String firstName;

    @NotNull(message = "Lastname is Required.")
    private String lastName;

    @NotNull(message = "KYC is Required.")
    @Size(min = 12, message = "KYC No should be of 12 digits.")
    private String kyc;

    //@JsonFormat(pattern = "YYYY-MM-DD")
    @NotNull(message = "Date of Birth is Required.")
    @Past(message = "Date of Birth must be of Past Date")
    //LocalDate format must be YYYY-MM-DD
    private LocalDate dob;

    //@JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate registerDate;
    private LocalDate updateDate;

    @NotNull(message = "Password must be provided.")
    private String password;

    @NotNull(message = "Please Enter the EMail ID")
    @Email(message = "Email ID should be of Proper format.")
    private String emailId;

    @Column(columnDefinition = "boolean default false")
    private Boolean verify;

    private LocalDate purchaseDate;
    private LocalDate expiryDate;

    public CustomerRegisterEntity(CustomerRegisterDTO customerRegisterDTO) {
        this.firstName = customerRegisterDTO.getFirstName();
        this.lastName = customerRegisterDTO.getLastName();
        this.kyc = customerRegisterDTO.getKyc();
        this.dob = customerRegisterDTO.getDob();
        this.registerDate = customerRegisterDTO.getRegisterDate();
        this.updateDate = customerRegisterDTO.getUpdateDate();
        this.password = customerRegisterDTO.getPassword();
        this.emailId = customerRegisterDTO.getEmailId();
        this.verify = customerRegisterDTO.getVerify();
        this.purchaseDate = customerRegisterDTO.getPurchaseDate();
        this.expiryDate = customerRegisterDTO.getExpiryDate();
    }

    public CustomerRegisterEntity(Long id, String firstName, String lastName, String kyc, LocalDate dob, LocalDate registerDate, LocalDate updateDate, String password, String emailId, Boolean verify, LocalDate purchaseDate, LocalDate expiryDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.kyc = kyc;
        this.dob = dob;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.password = password;
        this.emailId = emailId;
        this.verify = verify;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
    }
}
