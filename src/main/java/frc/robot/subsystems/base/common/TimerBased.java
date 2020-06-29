package frc.robot.subsystems.base.common;

/**
 * Add methods that indicated that the subsystem needs to use timer.
 * <p>
 *
 * @author Barel
 * @version 1.0
 * @since 2020-off
 */
public interface TimerBased {

    /**
     * Start the timer.
     */
    void startTimer();

    /**
     * delay the next checking by specific amount of milliseconds
     * @param ms the amount of time to delay.
     */
    void delay(double ms);

    /**
     * Stop the timer.
     */
    void stopTimer();

    /**
     * Reset the timer.
     */
    void resetTimer();

    /**
     * @return the time that the timer running.
     */
    double getTime();

    /**
     * @return whether the timer is running.
     */
    boolean isRunning();

    /**
     * @param time the time to check.
     * @return whether the time elapsed.
     */
    boolean hasTimeElapsed(double time);
}
