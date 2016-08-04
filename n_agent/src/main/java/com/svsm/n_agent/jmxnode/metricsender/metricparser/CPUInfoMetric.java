package com.svsm.n_agent.jmxnode.metricsender.metricparser;

import java.util.HashMap;
import java.util.Map;

public class CPUInfoMetric implements IMetric {

    private String localJVM = "localJVMCpu";
    private String systemCpu = "systemCpu";

    private Long metricLocalJVMCpu;
    private Long metricSystemCpu;

    public void setMetricLocalJVMCpu(Long metricStringLocalJVMCpu) {
        this.metricLocalJVMCpu = metricStringLocalJVMCpu;
    }
    public void setMetricSystemCpu(Long metricStringSystemCpu) {
        this.metricSystemCpu = metricStringSystemCpu;
    }

    Map<String, Long> map =  new HashMap<String, Long>();

    @Override
    public Map<String, Long> toMap() {

        map.put(localJVM, metricLocalJVMCpu);
        map.put(systemCpu, metricSystemCpu);

        return map;
    }
}
