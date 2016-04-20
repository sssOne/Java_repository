package com.streetone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.streetone.model.InputSubscriptionData;
import com.streetone.model.MailContext;
import com.streetone.model.ResultStatus;
import com.streetone.model.User;
import com.streetone.util.SendMail;

public class SubscriptionEmail {

	public ResultStatus sendSubscriptionMail(
			InputSubscriptionData inputSubscriptionData) {

		// prepare MailContext first
		MailContext context = createMailContext(inputSubscriptionData);
		try {
			SendMail.Sendmail(context);

			ResultStatus resultStatus = new ResultStatus();
			resultStatus.setStatus(true);

			User user = new User();
			user.setEmail(inputSubscriptionData.getEmail());
			user.setFirstName(inputSubscriptionData.getFirstName());
			user.setLastName(inputSubscriptionData.getLastName());

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

	private MailContext createMailContext(
			InputSubscriptionData inputSubscriptionData) {
		MailContext mailContext = new MailContext();

		StringBuilder stringbuilderObject = new StringBuilder();
		stringbuilderObject
				.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		stringbuilderObject.append("<html><div>Greetings "
				+ inputSubscriptionData.getFirstName() + " "
				+ inputSubscriptionData.getLastName() + ", </div>");
		stringbuilderObject
				.append("<div>Thanks for subscribing to us. Your sucripition ID is "
						+ inputSubscriptionData.getSubscriptionID() + ".</div>");
		stringbuilderObject.append("Regards, <br>XXXX</html>");
		mailContext.setSubject("Subscription Alert!!");
		mailContext.setBody(stringbuilderObject.toString());
		mailContext.setToAddress(inputSubscriptionData.getEmail());

		return mailContext;
	}
}
