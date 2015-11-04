package com.java8.training.exercises.exercise8;

// Be careful : interface name should be the class suffixed by MBean
// otherwise it won't work
public interface TCPServerMBean {

    String getLabel();

    void setLabel(final String label);

    boolean isRunning();

    void setRunning(final boolean running);

}
