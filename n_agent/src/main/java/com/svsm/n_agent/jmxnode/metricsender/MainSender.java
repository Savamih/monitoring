package com.svsm.n_agent.jmxnode.metricsender;

import com.svsm.n_agent.jmxnode.IConnection;
import com.svsm.n_agent.jmxnode.JmxConnection;
import com.svsm.n_agent.jmxnode.metricsender.metricparser.*;
import org.hyperic.sigar.SigarException;

import javax.management.MalformedObjectNameException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainSender {

    public static void main(String[] args) throws InterruptedException, IOException, MalformedObjectNameException, SigarException {

        MetricSender metricSender = new MetricSender("localhost", 8125, 0);

        List<IMetric> metricList = new ArrayList<>(1);

        IConnection jc = new JmxConnection("localhost", "1111");

        CPUInfoMetric cpuInfoMetric = new CPUInfoMetric();
        cpuInfoMetric.setMetricSystemCpu((long) jc.getCPUSystemInfo());
        cpuInfoMetric.setMetricLocalJVMCpu((long) jc.getCPULocalJVMInfo());

        RAMInfoMetric ramInfoMetric = new RAMInfoMetric();
        ramInfoMetric.setMetricFreeRam(jc.getRAMFreeInfo());
        ramInfoMetric.setMetricTotalRam(jc.getRAMTotalInfo());

        SwapInfoMetric swapInfoMetric = new SwapInfoMetric();
        swapInfoMetric.setMetricFreeSwap(jc.getSwapFreeInfo());
        swapInfoMetric.setMetricTotalSwap(jc.getSwapTotalInfo());

        DiskInfoMetric diskInfoMetric = new DiskInfoMetric();
        diskInfoMetric.setMetricStringReadBytes(jc.getDiskReadBytesInfo());
        diskInfoMetric.setMetricStringWriteBytes(jc.getDiskWriteBytesInfo());

        JVMInfoMetric jvmInfoMetric = new JVMInfoMetric();
        jvmInfoMetric.setMetricJVMAvailableProcessors(jc.getJVMAvailableProcessorsInfo());
        jvmInfoMetric.setMetricJVMFreeMemory(jc.getJVMFreeMemoryInfo());
        jvmInfoMetric.setMetricJVMMaxMemory(jc.getJVMMaxMemoryInfo());
        jvmInfoMetric.setMetricJVMTotalMemory(jc.getJVMTotalMemoryInfo());

        metricList.add(cpuInfoMetric);
        metricList.add(ramInfoMetric);
        metricList.add(swapInfoMetric);
        metricList.add(diskInfoMetric);
        metricList.add(jvmInfoMetric);

        while (true) {

            metricList.forEach(metric -> metricSender.collect(metric));

            metricSender.send();
            Thread.sleep(1000);

        }
    }
}