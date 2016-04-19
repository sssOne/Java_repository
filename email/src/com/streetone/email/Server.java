package com.streetone.email;

import java.util.Arrays;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class Server {

    protected Server() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(Email.class);
        sf.setResourceProvider(Email.class, 
            new SingletonResourceProvider(new Email()));
	sf.setProviders(Arrays.< Object >asList(new JacksonJsonProvider()));
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        sf.setAddress("http://172.31.1.150:12000/");

        sf.create();
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Email Server ready...");

        Thread.sleep(240 * 60 * 60 * 1000); // 240 hours 
        //Thread.sleep(5 * 60 * 1000); // 5 mins
        System.out.println("Email Server exiting");
        System.exit(0);
    }
}
