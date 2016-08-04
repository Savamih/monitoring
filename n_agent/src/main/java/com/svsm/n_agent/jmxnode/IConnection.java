package com.svsm.n_agent.jmxnode;


import org.hyperic.sigar.SigarException;

public interface IConnection {
    public double getCPUSystemInfo();
    public double getCPULocalJVMInfo();
    public Long getDiskReadBytesInfo() throws SigarException;
    public Long getDiskWriteBytesInfo()throws SigarException;
    public Long getRAMFreeInfo();
    public Long getRAMTotalInfo();
    public Long getSwapFreeInfo();
    public Long getSwapTotalInfo();

    public int getJVMAvailableProcessorsInfo();
    public long getJVMFreeMemoryInfo();
    public long getJVMMaxMemoryInfo();
    public long getJVMTotalMemoryInfo();
}
