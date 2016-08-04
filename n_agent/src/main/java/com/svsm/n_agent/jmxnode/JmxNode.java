package com.svsm.n_agent.jmxnode;


import org.apache.log4j.Logger;
import org.hyperic.sigar.SigarException;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JmxNode {

    private static final Logger log = Logger.getLogger(JmxNode.class);

    public static void main (String[] args) throws IOException, MalformedObjectNameException, ReflectionException, InstanceNotFoundException, InterruptedException, SigarException {

        IConnection jc = new JmxConnection("localhost", "1111");
        //IConnection jc2 = new JmxConnection("localhost", "2222");
        //IConnection jc3 = new JmxConnection("localhost", "3333");

        List<IConnection> ConnectionList = new ArrayList<>(1);

        ConnectionList.add(jc);
        //ConnectionList.add(jc2);
        //ConnectionList.add(jc3);

        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");


        while(true){

            ConnectionList.forEach(connection -> {
                connection.getRAMTotalInfo();
            });

            System.out.println(jc.getCPUSystemInfo());

            Thread.sleep(3000);
        }
    }
}
