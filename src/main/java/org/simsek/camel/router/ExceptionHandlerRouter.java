package org.simsek.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.simsek.camel.processor.ExceptionHandlerProcessor;
import org.simsek.camel.processor.ThrowExpProcessor;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandlerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        onException(Exception.class)
                .handled(true)
                .process(new ExceptionHandlerProcessor())
                .log("${body}");

        from("timer://foo?fixedRate=true&period=30000").routeId("errorhandler")
                .process(new ThrowExpProcessor())
                .log("${body}");
    }
}
