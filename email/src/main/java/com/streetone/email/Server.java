package main.java.com.streetone.email;

import java.util.Arrays;

import main.java.com.streetone.controller.impl.EmailControllerImpl;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class);

    protected Server() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(EmailControllerImpl.class);
        sf.setResourceProvider(EmailControllerImpl.class, new SingletonResourceProvider(new EmailControllerImpl()));
        sf.setProviders(Arrays.<Object> asList(new JacksonJsonProvider()));
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        sf.setAddress("http://localhost:9090/");

        sf.create();
    }

    public static void main(String args[]) throws Exception {
        new Server();
        LOGGER.info("Email Server ready...");

        Thread.sleep(240 * 60 * 60 * 1000); // 240 hours
        // Thread.sleep(5 * 60 * 1000); // 5 mins
        LOGGER.info("Email Server exiting");
        System.exit(0);
    }
}
