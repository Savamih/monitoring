package com.svsm.n_agent.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "Swapmetric")
public class Swap {


    private long metric_id;
    private Metric metric;

    private long freeSwap;

    private long totalSwap;

    public Swap(){}

    public Swap(long freeSwap, long totalSwap){
        this.freeSwap = freeSwap;
        this.totalSwap = totalSwap;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name = "metric_id")
    public long getMetric_id() {
        return metric_id;
    }

    public void setMetric_id(long metric_id) {
        this.metric_id = metric_id;
    }

    @Column(name = "freeSwap")
    public long getFreeSwap() {
        return freeSwap;
    }

    public void setFreeSwap(long freeSwap) {
        this.freeSwap = freeSwap;
    }
    @Column(name = "totalSwap")
    public long getTotalSwap() {
        return totalSwap;
    }

    public void setTotalSwap(long totalSwap) {
        this.totalSwap = totalSwap;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Metric getMetric(){return this.metric;}
    public void setMetric(Metric metric){
        this.metric = metric;
    }

}
