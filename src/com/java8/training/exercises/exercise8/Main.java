package com.java8.training.exercises.exercise8;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created on 04/11/2015.
 */
public class Main {

    public static void main(String[] args) throws NotCompliantMBeanException, InstanceAlreadyExistsException,
            MBeanRegistrationException, MalformedObjectNameException, IOException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.java8.training.exercises.exercise8:type=TCPServer");
        TCPServer server = new TCPServer();
        mbs.registerMBean(server, name);
        server.start();
    }
}
