package org.simsek.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.simsek.camel.model.User;

public class ThrowExpProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
        throw new Exception("ThrowExpProcessor throw exception");
    }
}
