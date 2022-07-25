package org.simsek.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.logging.LogFactory;
import org.simsek.camel.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserProcessor implements Processor {
    Logger logger = LoggerFactory.getLogger(UserProcessor.class);
    @Override
    public void process(Exchange exchange) throws Exception {
        User user = (User) exchange.getIn().getBody();
        logger.info("User-Age:" + user.getAge());

        user.setCategory(user.getAge() > 35 ? "MiddleAge": "Young");

        exchange.getIn().setBody(user);
    }
}
