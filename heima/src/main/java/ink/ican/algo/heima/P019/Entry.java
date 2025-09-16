package ink.ican.algo.heima.P019;

import ink.ican.algo.heima.BASE.Priority;

public class Entry implements Priority {

    private String value;
    private int priority;

    public Entry(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "value='" + value + '\'' +
                ", priority=" + priority +
                '}';
    }
}
