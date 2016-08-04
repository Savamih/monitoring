package com.svsm.n_agent.persistence.service;

import com.svsm.n_agent.jmxnode.JmxConnection;
import com.svsm.n_agent.persistence.dao.MetricDao;
import org.hyperic.sigar.SigarException;

public interface IMetricService {
    public void metricPersist(JmxConnection jc) throws SigarException;

}
