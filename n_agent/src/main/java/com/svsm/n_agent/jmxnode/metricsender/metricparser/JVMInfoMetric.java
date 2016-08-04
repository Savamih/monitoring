package com.svsm.n_agent.jmxnode.metricsender.metricparser;


import java.util.HashMap;
import java.util.Map;

public class JVMInfoMetric implements IMetric {
    private String JVMAvailableProcessors = "JVMAvailableProcessors";
    private String JVMFreeMemory = "JVMFreeMemory";
    private String JVMMaxMemory = "JVMMaxMemory";
    private String JVMTotalMemory = "JVMTotalMemory";

    private int metricJVMAvailableProcessors;
    private long metricJVMFreeMemory;
    private long metricJVMMaxMemory;
    private long metricJVMTotalMemory;

    public void setMetricJVMAvailableProcessors(int metricJVMAvailableProcessors) {
        this.metricJVMAvailableProcessors = metricJVMAvailableProcessors;
    }

    public void setMetricJVMFreeMemory(long metricJVMFreeMemory) {
        this.metricJVMFreeMemory = metricJVMFreeMemory;
    }

    public void setMetricJVMMaxMemory(long metricJVMMaxMemory) {
        this.metricJVMMaxMemory = metricJVMMaxMemory;
    }

    public void setMetricJVMTotalMemory(long metricJVMTotalMemory) {
        this.metricJVMTotalMemory = metricJVMTotalMemory;
    }

    Map<String, Long> map =  new HashMap<String, Long>();

    @Override
    public Map<String, Long> toMap() {

        map.put(JVMAvailableProcessors,(long) metricJVMAvailableProcessors);
        map.put(JVMFreeMemory, metricJVMFreeMemory);
        map.put(JVMMaxMemory, metricJVMMaxMemory);
        map.put(JVMTotalMemory, metricJVMTotalMemory);

        return map;
    }
}
