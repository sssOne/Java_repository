package com.streetone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.streetone.model.MailContext;
import com.streetone.model.Register;
import com.streetone.model.ResultStatus;
import com.streetone.model.User;
import com.streetone.util.SendMail;

public class RegistrationEmail {

    public ResultStatus sendRegisterationMail(Register register) {

        // prepare MailContext first
        MailContext context = createMailContext(register);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(register.getEmail());
            user.setFirstName(register.getFirstName());
            user.setLastName(register.getLastName());

            ObjectMapper mapper = new ObjectMapper();
            resultStatus.setData(mapper.writeValueAsString(user));
            return resultStatus;
        } catch (Exception e) {

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(false);
            resultStatus.setData(null);
            return resultStatus;
        }
    }

    private MailContext createMailContext(Register register) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + register.getFirstName() + " " + register.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div> Now you are registered to our site with " + register.getEmail() + ". </div>");
        stringbuilderObject.append("<div>Thanks for registering with us again.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Thank you for Registeration!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(register.getEmail());

        return mailContext;
    }

}
