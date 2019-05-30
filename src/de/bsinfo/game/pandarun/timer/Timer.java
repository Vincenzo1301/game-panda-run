package de.bsinfo.game.pandarun.timer;

public class Timer {

    private long lastTime;
    private long time;

    public Timer(long time) {
        lastTime = System.currentTimeMillis();
        this.time = time;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getLastTime() {
        return lastTime;
    }

    public long getTime() {
        return time;
    }

    public void update(long time) {
        this.time += time;
    }
}
