package com.streetone.email;

/*
 * email rest service.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 *  
 * 
 *
 *  
 * 
 *
 *  
 */

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.streetone.controller.RegistrationEmail;
import com.streetone.controller.SubscriptionEmail;
// model classes go here
import com.streetone.model.InputSubscriptionData;
import com.streetone.model.Register;
import com.streetone.model.ResultStatus;

// controller classes go here

@Path("/email/")
@Produces(MediaType.APPLICATION_JSON)
public class Email implements IEmail {

    private static final Logger LOGGER = Logger.getLogger(Email.class);

    @POST
    @Path("/register/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendRegistrationEmail(Register register) {

        ResultStatus resultStatus = new RegistrationEmail().sendRegisterationMail(register);
        LOGGER.info("" + resultStatus);
        System.out.println("" + resultStatus);
        return Response.ok(resultStatus).build();
    }

    @POST
    @Path("/subscribe/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendSubscriptionEmail(InputSubscriptionData inputSubscriptionData) {

        System.out.println("sendSubscriptionEmail");

        ResultStatus resultStatus = new SubscriptionEmail().sendSubscriptionMail(inputSubscriptionData);
        System.out.println("" + resultStatus);
        return Response.ok(resultStatus).build();
    }
}
