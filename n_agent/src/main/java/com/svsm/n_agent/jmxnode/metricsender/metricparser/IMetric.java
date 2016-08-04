package com.svsm.n_agent.jmxnode.metricsender.metricparser;

import java.util.Map;

public interface IMetric {
   <S, L> Map<S, L> toMap();
}
