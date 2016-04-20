package com.streetone.email;

import javax.jws.WebService;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.streetone.model.InputSubscriptionData;
import com.streetone.model.Register;

@Path("/")
@WebService(name = "emailService")
public interface IEmail {

	Response sendRegistrationEmail(Register register);

	Response sendSubscriptionEmail(InputSubscriptionData inputSubscriptionData);

}
