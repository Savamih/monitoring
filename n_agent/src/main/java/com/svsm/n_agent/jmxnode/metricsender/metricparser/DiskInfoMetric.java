package com.svsm.n_agent.jmxnode.metricsender.metricparser;

import java.util.HashMap;
import java.util.Map;

public class DiskInfoMetric implements IMetric {

    private String ReadBytes = "DiskReadBytes/sec";
    private String WriteBytes = "DiskWriteBytes/sec";

    private Long metricStringReadBytes;
    private Long metricStringWriteBytes;

    public void setMetricStringReadBytes(Long metricStringReadBytes) {
        this.metricStringReadBytes = metricStringReadBytes;
    }

    public void setMetricStringWriteBytes(Long metricStringWriteBytes) {
        this.metricStringWriteBytes = metricStringWriteBytes;
    }

    Map<String, Long> map =  new HashMap<String, Long>();

    @Override
    public Map<String, Long> toMap() {

        map.put(ReadBytes, metricStringReadBytes);
        map.put(WriteBytes, metricStringWriteBytes);


        return map;
    }
}
