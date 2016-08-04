package com.svsm.n_agent.persistence.dao;

import com.svsm.n_agent.persistence.entity.Metric;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.rmi.Remote;


@Repository
public class MetricDao {
    @PersistenceContext
    protected EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void addMetric(Metric metric) {
        // Save metric
        this.em.persist(metric);
    }
}
