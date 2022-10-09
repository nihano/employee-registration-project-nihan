package com.cydeo.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import javax.websocket.server.ServerEndpoint;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {


//    @NotNull      ----> Field shouldn't be null
//    @NotEmpty     ----> Field shouldn't be ""
//    @NotBlank     ----> Field shouldn't be "   "

//    @NotNull -> @NotNull
//    @NotEmpty ->  @NotNull + @NotEmpty
//    @NotBlank ->  @NotNull + @NotEmpty + @NotBlank
    @NotBlank
    @Size(max=12, min = 2)
    private String firstName;

    private String lastName;

    //thymeleaf accepts yyyy-MM-dd, but LocalDate accepts mm-dd-yyyy or yyyy-dd-mm or sth else

//    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

//    @NotBlank
//    @Email
    private String email;

//    @NotBlank
//    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}") //google this kind of conditions for passwords regexp
    private String password;

    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;



}
