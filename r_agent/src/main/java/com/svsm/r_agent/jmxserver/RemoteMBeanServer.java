package com.svsm.r_agent.jmxserver;


import javax.management.*;
import java.lang.management.ManagementFactory;

public class RemoteMBeanServer {

    public static void main (String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.savam.jmx:type=SystemConfig");

        JMXServer jmxServer = new JMXServer();

        mbs.registerMBean(jmxServer, name);

        do {
            Thread.sleep(Long.MAX_VALUE);
        }while(true);
    }
}
