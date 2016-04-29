package com.streetone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.streetone.model.MailContext;
import com.streetone.model.ResultStatus;
import com.streetone.model.User;
import com.streetone.util.SendMail;

public class ForgotPasswordEmail {
    public ResultStatus sendForgotPasswordMail(User userData) {
        // prepare MailContext first
        MailContext context = createForgotPasswordBody(userData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(userData.getEmail());
            user.setFirstName(userData.getFirstName());
            user.setLastName(userData.getLastName());

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

    private MailContext createForgotPasswordBody(User userData) {
        MailContext mailContext = new MailContext();
        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + userData.getFirstName() + " " + userData.getLastName()
                + ", </div>");
        stringbuilderObject.append("<div>Please follow the following instructions to retain your password.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Retain Password instruction!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(userData.getEmail());

        return mailContext;
    }

}
