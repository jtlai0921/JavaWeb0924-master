package com.mycompany.web.jms.console.queue;
// https://www.logicbig.com/tutorials/java-ee-tutorial/jms/jms-helloworld.html
/*
JMS Hello World Example
This is a quickstart standalone demonstration of JMS API. We will use Apache ActiveMQ as the provider implementation of JMS and will show point-to-point messaging model in this example.
In this demo, the usage of ActiveMQ API is limited to only one class; JmsProvider, which creates an instance of ActiveMQConnectionFactory (an implementation of javax.jms.ConnectionFactory). The rest of the classes show the use of JMS API only.
這是JMS API的快速入門獨立演示。我們將使用Apache ActiveMQ作為JMS的提供程序實​​現，並在此示例中顯示點對點消息傳遞模型。
在本演示中，ActiveMQ API的使用僅限於一個類； JmsProvider，它創建ActiveMQConnectionFactory的實例（javax.jms.ConnectionFactory的實現）。其餘的類僅顯示JMS API的用法。
*/
public class Main {
    public static void main (String[] args) throws Exception {
        final ExampleMessageSender sender = new ExampleMessageSender();

        final ExampleMessageReceiver receiver = new ExampleMessageReceiver();
        receiver.startListener();

        for (int i = 1; i <= 5; i++) {
            String m = "Hello world! " + i;
            sender.sendMessage(m);
            Thread.sleep(5000);
        }

        sender.destroy();
        receiver.destroy();
    }
}
