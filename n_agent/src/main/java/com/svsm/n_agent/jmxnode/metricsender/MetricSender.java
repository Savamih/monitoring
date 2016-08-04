package com.svsm.n_agent.jmxnode.metricsender;



import com.flozano.statsd.metrics.Metrics;
import com.flozano.statsd.metrics.MetricsBuilder;
import com.svsm.n_agent.jmxnode.metricsender.metricparser.IMetric;


import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class MetricSender {
    private Map<String, Long> serverInfo;
    private Metrics metrics;
    private List<IMetric> metricList;

    public MetricSender(String host, int port, int serverId) {
        this.metrics = MetricsBuilder.create()
                .withClient((clientBuilder) -> clientBuilder
                        .withHost(host)
                        .withPort(port))
                .withClock(Clock.systemUTC()).build();
        serverInfo = new HashMap<>(1);
        serverInfo.put("Server", new Long(serverId));
        this.metricList = new ArrayList<>(24);
    }

    public void collect(IMetric metric) {
        metricList.add(metric);
    }

    public void send() {

        try (Metrics batch = metrics.batch()){
            BiConsumer putter = new BiConsumer<String, Long>() {
                @Override
                public void accept(String key, Long value) {
                    batch.gauge(key).value(value);
                }
            };
            serverInfo.forEach(putter);
            metricList.forEach(metric -> metric.toMap().forEach(putter));
            metricList.forEach(metric -> System.out.println(metric.toMap()));

        }
        metricList.clear();

    }
}
