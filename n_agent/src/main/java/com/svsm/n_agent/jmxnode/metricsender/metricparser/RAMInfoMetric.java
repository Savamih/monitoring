package com.svsm.n_agent.jmxnode.metricsender.metricparser;

import java.util.HashMap;
import java.util.Map;

public class RAMInfoMetric implements IMetric {

    private String totalRam = "totalRam";
    private String freeRam = "freeRam";

    private Long metricTotalRam;
    private Long metricFreeRam;

    public void setMetricTotalRam(Long metricTotalRam) {
        this.metricTotalRam = metricTotalRam;
    }

    public void setMetricFreeRam(Long metricFreeRam) {
        this.metricFreeRam = metricFreeRam;
    }

    Map<String, Long> map =  new HashMap<String, Long>();

    @Override
    public Map<String, Long> toMap() {

        map.put(totalRam, metricTotalRam);
        map.put(freeRam, metricFreeRam);

        return map;
    }
}
