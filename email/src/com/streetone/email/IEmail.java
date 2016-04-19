package com.streetone.email;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import com.streetone.model.Register;
import com.streetone.model.User;
import com.streetone.model.InputSubscriptionData;
@Path("/")
@WebService(name="emailService")
public interface IEmail {

    
    Response sendRegistrationEmail(Register register);
    
    Response sendSubscriptionEmail(InputSubscriptionData inputSubscriptionData);
    
}
