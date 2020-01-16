package com.mycompany.web.jms.console.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;

public class JmsProvider {

    public static ConnectionFactory getConnectionFactory () {
        /*
            The VM transport allows clients to connect to each other inside
            the VM without the overhead of the network communication. 
            VM 傳輸允許客戶端在內部相互連接
            VM，沒有網絡通信的開銷
        */
        ConnectionFactory connectionFactory =
                  new ActiveMQConnectionFactory("vm://localhost");

        return connectionFactory;
    }
}
