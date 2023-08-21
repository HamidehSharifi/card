package com.example.card.customer.presentention;

import com.fardup.msutility.customvalidation.required.Required;
import lombok.Data;
import javax.validation.Constraint;



@Data
public class CustomerModel {
    @Required
    private String email;
    private String userName;


}
