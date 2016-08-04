package com.svsm.n_agent.persistence;


import com.svsm.n_agent.jmxnode.JmxConnection;
import com.svsm.n_agent.persistence.dao.MetricDao;
import com.svsm.n_agent.persistence.service.MetricService;
import org.hyperic.sigar.SigarException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;
import java.io.IOException;


public class DataPersist {

    public static void main(String[] args) throws IOException, MalformedObjectNameException, ReflectionException, InstanceNotFoundException, InterruptedException, SigarException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");
        MetricDao metricDao = (MetricDao) context.getBean("metricDao");

        while (true) {

            JmxConnection jc = new JmxConnection("localhost", "1111");
            JmxConnection jc2 = new JmxConnection("localhost", "2222");

            MetricService metricService = new MetricService(metricDao);
            metricService.metricPersist(jc);
            metricService.metricPersist(jc2);

            Thread.sleep(5000);
        }

    }
}
