package com.svsm.r_agent.jmxserver;


import com.sun.management.OperatingSystemMXBean;
import org.hyperic.sigar.DiskUsage;
import org.hyperic.sigar.SigarException;

import java.lang.management.ManagementFactory;

public class JMXServer implements JMXServerMBean {


    public double getCPUSystem() {

        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return (operatingSystemMXBean.getSystemCpuLoad() * 100);
    }


    public double getCPULocalJDK() {
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return (operatingSystemMXBean.getProcessCpuLoad() * 100);
    }


    public Long getDiskReadBytes() throws SigarException {

        DiskUsage diskUsage = new DiskUsage();
        return diskUsage.getReadBytes();
    }


    public Long getDiskWriteBytes() {

        DiskUsage diskUsage = new DiskUsage();
        return diskUsage.getReadBytes();
    }


    public Long getRAMFree() {

        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return (operatingSystemMXBean.getFreePhysicalMemorySize() / 100000);
    }


    public Long getRAMTotal() {
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return (operatingSystemMXBean.getTotalPhysicalMemorySize() / 1000000);
    }


    public Long getSwapFree() {
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return (operatingSystemMXBean.getFreeSwapSpaceSize() / 100000);
    }


    public Long getSwapTotal() {
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return (operatingSystemMXBean.getTotalSwapSpaceSize() / 1000000);
    }


    public int getJVMAvailableProcessors() {
        return 0;
    }


    public long getJVMFreeMemory() {
        return 0;
    }


    public long getJVMMaxMemory() {
        return 0;
    }


    public long getJVMTotalMemory() {
        return 0;
    }
}
