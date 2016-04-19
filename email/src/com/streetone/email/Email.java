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

import java.io.File;
import java.io.IOException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

// model classes go here

import com.streetone.model.Register;
import com.streetone.model.User;
import com.streetone.model.InputSubscriptionData;
import com.streetone.model.ResultStatus;

// controller classes go here

import com.streetone.controller.RegistrationEmail;
import com.streetone.controller.SubscriptionEmail;

@Path("/email/")
@Produces(MediaType.APPLICATION_JSON)
public class Email implements IEmail {


    @POST
    @Path("/register/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendRegistrationEmail(Register register) {
        
    // call RegistrationEmail controller class
	RegisterUser rUser = new RegisterUser();
	ResultStatus resultStatus = rUser.registerUser(register);
    if (resultStatus.getErrorCode() == 0) {

        Credentials credentials = new Credentials();

        credentials.setUserId(register.getUserId());
        credentials.setPasscode(register.getPasscode());

        Response response = checkCredentials(credentials);
        return response;
        
    } else {
        
        return Response.ok(resultStatus).build();
    }
    }
    

    @POST
    @Path("/subscribe/")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendSubscriptionEmail(InputSUbscriptionData inputSubscriptionData) {
	// 
	// input will contain the details for sending a subcription email. 
	// .
	// - first name .
	// - last name 
	// - email address.
	// - fields associated with subscription contract
	// 
	// this method should call a controller class SubscriptionEmail
	// 
	// response will be a json object.


    }
       
}
