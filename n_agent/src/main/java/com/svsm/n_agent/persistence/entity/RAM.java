package com.svsm.n_agent.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "RAMmetric")
public class RAM implements java.io.Serializable {


    private long metric_id;
    private Metric metric;
    private long ramFree;
    private long ramTotal;

    public RAM(){}

    public RAM(long ramFree, long ramTotal){
        this.ramFree = ramFree;
        this.ramTotal = ramTotal;
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

    @Column(name = "freeRAM")
    public long getRamFree() {
        return ramFree;
    }

    public void setRamFree(long ramFree) {
        this.ramFree = ramFree;
    }

    @Column(name = "totalRAM")
    public long getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(long ramTotal) {
        this.ramTotal = ramTotal;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Metric getMetric(){return this.metric;}
    public void setMetric(Metric metric){
        this.metric = metric;
    }

}
