package com.admatic.tomcatdemo;

public class Greeting {

    private final long id;
    private final String content;
    private final String hostname;

    public Greeting(long id, String content, String hostname) {
        this.id = id;
        this.content = content;
        this.hostname = hostname;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    public String getHostname() {
        return hostname;
    }
}
