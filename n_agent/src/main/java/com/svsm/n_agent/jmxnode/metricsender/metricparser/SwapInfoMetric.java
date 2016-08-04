package com.svsm.n_agent.jmxnode.metricsender.metricparser;

import java.util.HashMap;
import java.util.Map;

public class SwapInfoMetric implements IMetric {

    private String totalSwap = "totalSwap";
    private String freeSwap = "freeSwap";

    private Long metricTotalSwap;
    private Long metricFreeSwap;

    public void setMetricTotalSwap(Long metricTotalSwap) {
        this.metricTotalSwap = metricTotalSwap;
    }

    public void setMetricFreeSwap(Long metricFreeSwap) {
        this.metricFreeSwap = metricFreeSwap;
    }

    Map<String, Long> map =  new HashMap<String, Long>();

    @Override
    public Map<String, Long> toMap() {

        map.put(totalSwap, metricTotalSwap);
        map.put(freeSwap, metricFreeSwap);

        return map;
    }
}
