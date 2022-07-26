package org.simsek.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandlerProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        var route = (String) exchange.getProperty(Exchange.FAILURE_ROUTE_ID);
        var exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        var message = exception.getMessage();
        exchange.getIn().setBody("Router:" + route + " Exception:" + message);
    }
}
