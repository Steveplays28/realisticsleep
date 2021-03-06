package com.github.steveplays28.realisticsleep;

public class SleepMath {
    public static final int DAY_LENGTH = 24000;
    public static final int AWAKE_TIME = 23460;

    public static int calculateNightTimeStepPerTick(double sleepingRatio, double multiplier) {
        return (int) Math.round(sleepingRatio * multiplier);
    }

    public static int calculateTicksTo(int timeOfDay, int targetTimeOfDay) {
        if (timeOfDay > targetTimeOfDay)
            return targetTimeOfDay + DAY_LENGTH - timeOfDay;

        return targetTimeOfDay - timeOfDay;
    }

    public static int calculateTicksUntilAwake(int currentTimeOfDay) {
        return calculateTicksTo(currentTimeOfDay, AWAKE_TIME);
    }

    public static int calculateSecondsUntilAwake(int currentTimeOfDay, double timeStepPerTick, double tps) {
        return (int) Math.round(calculateTicksUntilAwake(currentTimeOfDay) / timeStepPerTick / tps);
    }

    public static double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
