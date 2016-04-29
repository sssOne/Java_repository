package com.streetone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.streetone.model.MailContext;
import com.streetone.model.ResultStatus;
import com.streetone.model.User;
import com.streetone.util.SendMail;

public class AuthenticationEmail {

    public ResultStatus sendAuthVerificationMail(User userData) {
        // prepare MailContext first
        MailContext context = createMailContext(userData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(userData.getEmail());

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

    private MailContext createMailContext(User userData) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings, </div>");
        stringbuilderObject.append("<div>Someone tried to log into your account. Please enter this,"
                + userData.getCode() + " authentication code to verify its you who is requesting.</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Auth Verification!!");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(userData.getEmail());

        return mailContext;
    }
}
