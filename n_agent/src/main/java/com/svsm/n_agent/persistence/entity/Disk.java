package com.svsm.n_agent.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "Diskmetric")
public class Disk implements java.io.Serializable{


    private long metric_id;
    private Metric metric;
    private long diskRead;
    private  long diskWrite;

    public Disk(){}
    public Disk(long diskRead, long diskWrite){
        this.diskRead = diskRead;
        this.diskWrite = diskWrite;
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

    @Column(name = "diskRead")
    public long getDiskRead() {
        return diskRead;
    }

    public void setDiskRead(long diskRead) {
        this.diskRead = diskRead;
    }

    @Column(name = "diskWrite")
    public long getDiskWrite() {
        return diskWrite;
    }

    public void setDiskWrite(long diskWrite) {
        this.diskWrite = diskWrite;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Metric getMetric(){return this.metric;}
    public void setMetric(Metric metric){
        this.metric = metric;
    }

}
