package com.mycompany.web.jms.console.topic;

import javax.jms.*;

public class ExampleMessageSender {

    private final MessageProducer producer;
    private final Session session;
    private final Connection con;

    public ExampleMessageSender () throws JMSException {
        ConnectionFactory factory = JmsProvider.getConnectionFactory();
        this.con = factory.createConnection();
        con.start();

        this.session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("example.topic");
        this.producer = session.createProducer(topic);
    }

    public void sendMessage (String message) throws JMSException {
        System.out.printf("Sending message: %s, Thread:%s%n",
                          message,
                          Thread.currentThread().getName());
        TextMessage textMessage = session.createTextMessage(message);
        producer.send(textMessage);
    }

    public void destroy () throws JMSException {
        con.close();
    }
}
