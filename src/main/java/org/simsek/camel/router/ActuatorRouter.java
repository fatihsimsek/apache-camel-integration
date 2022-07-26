package org.simsek.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class ActuatorRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // First, we have to configure our jetty component, which will be the rest
        // in charge of querying the REST endpoints from actuator
        restConfiguration()
                .host("0.0.0.0")
                .port(8080)
                .bindingMode(RestBindingMode.json);

        /*from("timer:queryTimer?repeatCount=1")
                .to("rest:get:/actuator/metrics/system.cpu.usage")
                .unmarshal()
                .json(true)
                .to("log:INFO?multiline=true");*/
    }
}
