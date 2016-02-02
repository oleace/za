package com.boya.commons;

import com.mongodb.*;

import javax.net.SocketFactory;

public class MongoClientOptionWrapper {
    private static MongoClientOptions options;
    private String description;
    private int connectionsPerHost = 10;
    private int threadsAllowedToBlockForConnectionMultiplier = 5;
    private int maxWaitTime = 1000 * 60 * 2;
    private int connectTimeout = 1000 * 10;
    private int socketTimeout = 0;
    private boolean socketKeepAlive = false;
    private boolean autoConnectRetry = false;
    private long maxAutoConnectRetryTime = 0;
    private boolean cursorFinalizerEnabled = true;
    private boolean alwaysUseMBeans = false;
    private ReadPreference readPreference = ReadPreference.primary();
    private DBDecoderFactory dbDecoderFactory = DefaultDBDecoder.FACTORY;
    private DBEncoderFactory dbEncoderFactory = DefaultDBEncoder.FACTORY;
    private WriteConcern writeConcern = WriteConcern.ACKNOWLEDGED;
    private SocketFactory socketFactory = SocketFactory.getDefault();

    public MongoClientOptionWrapper() {
    }

    public MongoClientOptions getOptions() {
        if (null == options) {
            options = new MongoClientOptions.Builder()
                    .connectionsPerHost(getConnectionsPerHost())
                    .autoConnectRetry(true)
                    .threadsAllowedToBlockForConnectionMultiplier(
                            threadsAllowedToBlockForConnectionMultiplier)
                    .maxWaitTime(maxWaitTime)
                    .connectTimeout(connectTimeout)
                    .socketTimeout(socketTimeout)
                    .maxAutoConnectRetryTime(maxAutoConnectRetryTime)
                    .cursorFinalizerEnabled(cursorFinalizerEnabled)
                            // .alwaysUseMBeans(alwaysUseMBeans)
                    .readPreference(readPreference)
                    .dbDecoderFactory(dbDecoderFactory)
                    .dbEncoderFactory(dbEncoderFactory)
                    .writeConcern(writeConcern).socketFactory(socketFactory)
                    .build();
        }
        return options;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getConnectionsPerHost() {
        return connectionsPerHost;
    }

    public void setConnectionsPerHost(int connectionsPerHost) {
        this.connectionsPerHost = connectionsPerHost;
    }

    public int getThreadsAllowedToBlockForConnectionMultiplier() {
        return threadsAllowedToBlockForConnectionMultiplier;
    }

    public void setThreadsAllowedToBlockForConnectionMultiplier(
            int threadsAllowedToBlockForConnectionMultiplier) {
        this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(int maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public boolean isSocketKeepAlive() {
        return socketKeepAlive;
    }

    public void setSocketKeepAlive(boolean socketKeepAlive) {
        this.socketKeepAlive = socketKeepAlive;
    }

    public boolean isAutoConnectRetry() {
        return autoConnectRetry;
    }

    public void setAutoConnectRetry(boolean autoConnectRetry) {
        this.autoConnectRetry = autoConnectRetry;
    }

    public long getMaxAutoConnectRetryTime() {
        return maxAutoConnectRetryTime;
    }

    public void setMaxAutoConnectRetryTime(long maxAutoConnectRetryTime) {
        this.maxAutoConnectRetryTime = maxAutoConnectRetryTime;
    }

    public boolean isCursorFinalizerEnabled() {
        return cursorFinalizerEnabled;
    }

    public void setCursorFinalizerEnabled(boolean cursorFinalizerEnabled) {
        this.cursorFinalizerEnabled = cursorFinalizerEnabled;
    }

    public boolean isAlwaysUseMBeans() {
        return alwaysUseMBeans;
    }

    public void setAlwaysUseMBeans(boolean alwaysUseMBeans) {
        this.alwaysUseMBeans = alwaysUseMBeans;
    }

}
