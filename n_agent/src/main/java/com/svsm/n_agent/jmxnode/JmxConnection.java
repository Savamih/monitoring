package com.svsm.n_agent.jmxnode;


import org.hyperic.sigar.SigarException;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

public class JmxConnection implements IConnection {

    private String HOST;
    private String PORT;
    private JMXServiceURL url;
    private JMXConnector jmxConnector;
    private MBeanServerConnection mbeanServerConnection;
    private ObjectName mbeanName;
    private JMXServerMBean mbeanProxy;

    public JmxConnection(String host , String port) throws IOException, MalformedObjectNameException {

        this.HOST = host;
        this.PORT = port;

        url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + HOST + ":" + PORT + "/jmxrmi");

        jmxConnector = JMXConnectorFactory.connect(url);
        mbeanServerConnection = jmxConnector.getMBeanServerConnection();
        mbeanName = new ObjectName("com.savam.jmx:type=SystemConfig");

        mbeanProxy = (JMXServerMBean) MBeanServerInvocationHandler.newProxyInstance(
                        mbeanServerConnection, mbeanName, JMXServerMBean.class, true);
    }

    @Override
    public double getCPUSystemInfo() {
        return mbeanProxy.getCPUSystem();
    }

    @Override
    public double getCPULocalJVMInfo(){
        return mbeanProxy.getCPULocalJDK();
    }

    @Override
    public Long getDiskReadBytesInfo() throws SigarException {
        return mbeanProxy.getDiskReadBytes();
    }

    @Override
    public Long getDiskWriteBytesInfo() throws SigarException {
        return mbeanProxy.getDiskWriteBytes();
    }

    @Override
    public Long getRAMFreeInfo() {
        return mbeanProxy.getRAMFree();
    }

    @Override
    public Long getRAMTotalInfo() {
        return mbeanProxy.getRAMTotal();
    }

    @Override
    public Long getSwapFreeInfo() {
        return mbeanProxy.getSwapFree();
    }

    @Override
    public Long getSwapTotalInfo() {
        return mbeanProxy.getSwapTotal();
    }

    @Override
    public int getJVMAvailableProcessorsInfo() {
        return 0;
    }

    @Override
    public long getJVMFreeMemoryInfo() {
        return 0;
    }

    @Override
    public long getJVMMaxMemoryInfo() {
        return 0;
    }

    @Override
    public long getJVMTotalMemoryInfo() {
        return 0;
    }

    public String getHost(){return this.HOST;}

    public String getPort(){return this.PORT;}

    public void closeConnection() throws IOException {
        jmxConnector.close();
    }
}
