package com.streetone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.streetone.model.MailContext;
import com.streetone.model.RebalanceData;
import com.streetone.model.ResultStatus;
import com.streetone.model.User;
import com.streetone.util.SendMail;

public class RebalanceEmail {

    public ResultStatus rebalanceMail(RebalanceData rebalanceData) {
        // prepare MailContext first
        MailContext context = createRebalanceBody(rebalanceData);
        try {
            SendMail.Sendmail(context);

            ResultStatus resultStatus = new ResultStatus();
            resultStatus.setStatus(true);

            User user = new User();
            user.setEmail(rebalanceData.getEmail());
            user.setFirstName(rebalanceData.getFirstName());
            user.setLastName(rebalanceData.getLastName());

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

    private MailContext createRebalanceBody(RebalanceData rebalanceData) {
        MailContext mailContext = new MailContext();

        StringBuilder stringbuilderObject = new StringBuilder();
        stringbuilderObject.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        stringbuilderObject.append("<html><div>Greetings " + rebalanceData.getFirstName() + " "
                + rebalanceData.getLastName() + ", </div>");
        stringbuilderObject.append("<div>Your reblance ID is " + rebalanceData.getRebalanceID() + ".</div>");
        stringbuilderObject.append("Regards, <br>XXXX</html>");
        mailContext.setSubject("Account Rebalanced");
        mailContext.setBody(stringbuilderObject.toString());
        mailContext.setToAddress(rebalanceData.getEmail());

        return mailContext;
    }

}
