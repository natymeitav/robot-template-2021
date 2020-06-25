package frc.robot.subsystems.base.common;

public interface TimerBase {
    void startTimer();

    void stopTimer();

    void resetTimer();

    double getTime();

    boolean isRunning();

    boolean hasTimeElapsed(double time);
}
