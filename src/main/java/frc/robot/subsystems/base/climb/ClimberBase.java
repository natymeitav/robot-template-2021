package frc.robot.subsystems.base.climb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Barel
 * @version 1.0
 * @since 2020-off
 * <p>
 * The class contains various methods that every {@code Climber} <b>should</b> implement.
 * <p>
 * The purpose of this class is to provide guidelines and restrict what important to us and what not.
 */
public abstract class ClimberBase extends SubsystemBase {

    /**
     * Return whether the mechanical stopper is engaged.
     *
     * @return the state of the mechanical stopper
     */
    public abstract boolean isStopperEngaged();

    /**
     * Engage the mechanical stopper to lock the climber.
     */
    public abstract void engageStopper();

    /**
     * Release the mechanical stopper of the climber.
     * <p>
     * This would allow it to extend.
     */
    public abstract void releaseStopper();

    /**
     * @return the current height of the left side of the climber in meters.
     */
    public abstract double getLeftHeight();

    /**
     * Move the right side of the climber to a given height.
     *
     * @param height the height setpoint of the right elevator in meters
     */
    public abstract void setLeftHeight(double height);

    /**
     * Move the right side of the climber to a given height.
     *
     * @param height               the height setpoint of the right elevator in meters
     * @param arbitraryFeedForward the power to always apply.
     */
    public abstract void setLeftHeight(double height, double arbitraryFeedForward);

    /**
     * @return the current height of the right side of the climber in meters.
     */
    public abstract double getRightHeight();

    /**
     * Move the right side of the climber to a given height.
     *
     * @param height the height setpoint of the right elevator in meters
     */
    public abstract void setRightHeight(double height);

    /**
     * Move the right side of the climber to a given height.
     *
     * @param height               the height setpoint of the right elevator in meters.
     * @param arbitraryFeedForward the power to always apply.
     */
    public abstract void setRightHeight(double height, double arbitraryFeedForward);

    /**
     * Set the power to apply on the left side of climber.
     *
     * @param power the power to apply.
     */
    public abstract void setLeftPower(double power);

    /**
     * Set the power to apply on the right side of the climber.
     *
     * @param power the power to apply.
     */
    public abstract void setRightPower(double power);

    /**
     * All cases where we want to prevent the drivers from climbing should return true here. whether it's by game time.
     * It won't allow climbing before the endgame.
     *
     * @return whether the robot should not climb.
     */
    public abstract boolean isSafeToClimb();

    /**
     * Return a normalized constrained in a certain range.
     *
     * @param setpoint the setpoint.
     * @return the normalized setpoint.
     */
    public abstract double normalizeSetpoint(double setpoint);

    /**
     * Return a normalized difference in a certain range.
     *
     * @param delta the difference.
     * @return the normalized difference.
     */
    public abstract double normalizeDelta(double delta);
}
