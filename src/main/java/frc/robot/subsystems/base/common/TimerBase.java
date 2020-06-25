package frc.robot.subsystems.base.common;

/**
 * Add methods that indicated that the subsystem needs to use timer.
 * <p>
 *
 * @author Barel
 * @version 1.0
 * @since 2020-off
 */
public interface TimerBase {

    /**
     * Start the timer.
     */
    void startTimer();

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
