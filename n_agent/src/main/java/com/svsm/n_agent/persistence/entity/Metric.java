package com.svsm.n_agent.persistence.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "metric")
public class Metric implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metric_id")
    private long metric_id;
    private String host;
    private String port;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "metric", cascade = CascadeType.ALL)
    private CPU cpu;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "metric", cascade = CascadeType.ALL)
    private RAM ram;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "metric", cascade = CascadeType.ALL)
    private Swap swap;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "metric", cascade = CascadeType.ALL)
    private Disk disk;

    public Metric(){}

    public Metric (String host, String port, Date timestamp){
        this.host = host;
        this.port = port;
        this.timestamp = timestamp;
    }

    public long getMetric_id(){
        return metric_id;
    }

    public void setMetric_id(long metric_id){
        this.metric_id = metric_id;
    }

    @Column(name = "host")
    public String getHost(){
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Column(name = "port")
    public String getPort(){
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Date getTimestamp(){return timestamp;}

    public void setTimestamp(Date timestamp){
        this.timestamp = timestamp;
    }

    public CPU getCpu(){return cpu;}

    public void setCpu(CPU cpu){this.cpu = cpu;}

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Swap getSwap() {
        return swap;
    }

    public void setSwap(Swap swap) {
        this.swap = swap;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

}
