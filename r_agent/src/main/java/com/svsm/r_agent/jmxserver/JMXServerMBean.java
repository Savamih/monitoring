package com.svsm.r_agent.jmxserver;


import org.hyperic.sigar.SigarException;

public interface JMXServerMBean {
    public double getCPUSystem();
    public double getCPULocalJDK();
    public Long getDiskReadBytes() throws SigarException;
    public Long getDiskWriteBytes() throws SigarException;
    public Long getRAMFree();
    public Long getRAMTotal();
    public Long getSwapFree();
    public Long getSwapTotal();

    public int getJVMAvailableProcessors();
    public long getJVMFreeMemory();
    public long getJVMMaxMemory();
    public long getJVMTotalMemory();

}
