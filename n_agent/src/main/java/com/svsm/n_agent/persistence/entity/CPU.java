package com.svsm.n_agent.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "CPUmetric")
public class CPU implements java.io.Serializable{


    private long metric_id;
    private double jdkCPU;
    private double systemCPU;
    private Metric metric;

    public CPU(){}

    public CPU(double jdkCPU, double systemCPU){
        this.jdkCPU = jdkCPU;
        this.systemCPU = systemCPU;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name = "metric_id")
    public long getMetricId(){
        return metric_id;
    }

    public void setMetricId(long id){
        this.metric_id = id;
    }

    @Column(name = "systemCPU")
    public double getSystemCPU(){return systemCPU;}

    public void setSystemCPU(double systemCPU) {
        this.systemCPU = systemCPU;
    }

    @Column(name = "jdkCPU")
    public double getJdkCPU() { return jdkCPU; }

    public void setJdkCPU(double jdkCPU){
        this.jdkCPU = jdkCPU;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Metric getMetric(){return this.metric;}
    public void setMetric(Metric metric){
        this.metric = metric;
    }

}
