package com.svsm.n_agent.persistence.service;

import com.svsm.n_agent.jmxnode.JmxConnection;
import com.svsm.n_agent.persistence.dao.MetricDao;
import com.svsm.n_agent.persistence.entity.*;
import org.hyperic.sigar.SigarException;

import java.util.Date;

public class MetricService implements IMetricService {

    private MetricDao metricDao;

    public MetricService(MetricDao metricDao){
        this.metricDao = metricDao;
    }
    @Override
    public void metricPersist(JmxConnection jc) throws SigarException {

        Date currentTime = new Date();

        Metric metric = new Metric(jc.getHost(), jc.getPort(), currentTime);
        CPU cpu = new CPU(jc.getCPULocalJVMInfo(),jc.getCPUSystemInfo());
        RAM ram = new RAM(jc.getRAMFreeInfo(), jc.getRAMTotalInfo());
        Swap swap = new Swap(jc.getSwapFreeInfo(), jc.getSwapTotalInfo());
        Disk disk = new Disk(jc.getDiskReadBytesInfo(), jc.getDiskWriteBytesInfo());

        metric.setCpu(cpu);
        metric.setRam(ram);
        metric.setSwap(swap);
        metric.setDisk(disk);

        cpu.setMetric(metric);
        ram.setMetric(metric);
        swap.setMetric(metric);
        disk.setMetric(metric);

        metricDao.addMetric(metric);
    }
}
