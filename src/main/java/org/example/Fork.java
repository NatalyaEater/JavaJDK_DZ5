package org.example;

public class Fork {
    protected volatile boolean free;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Fork() {
        this.free = true;
    }
}
