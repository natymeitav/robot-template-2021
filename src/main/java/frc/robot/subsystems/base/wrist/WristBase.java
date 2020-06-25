package frc.robot.subsystems.base.wrist;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Barel
 * @version 1.0
 * @since 2020-off
 * <p>
 * The class contains various methods that every {@code Wrist} <b>should</b> implement.
 * <p>
 * The purpose of this class is to provide guidelines and restrict what important to us and what not.
 */
public abstract class WristBase extends SubsystemBase {

    /**
     * Return the current angle of the wrist.
     * The return value is the angle in <b>degrees</b>,
     * and the value should always be between {@link WristBase#getMinAngle()} and {@link WristBase#getMaxAngle()}.
     *
     * @return the current angle of the wrist.
     * @see frc.robot.utilities.Utils#clamp
     * @see WristBase#getMinAngle()
     * @see WristBase#getMaxAngle()
     */
    public abstract double getAngle();


    /**
     * Move the wrist to the desired angle.
     * The value should always be between {@link WristBase#getMinAngle()} and {@link WristBase#getMaxAngle()}.
     *
     * @param angle the desired angle to move to.
     * @see frc.robot.utilities.Utils#clamp
     * @see WristBase#getMinAngle()
     * @see WristBase#getMaxAngle()
     */
    public abstract void setAngle(double angle);

    /**
     * Get the current speed of the wrist.
     *
     * @return the current speed of the wrist.
     */
    public abstract double getSpeed();

    /**
     * set the speed of the wrist.
     *
     * @param speed the speed per second of the wrist.
     */
    public abstract void setSpeed(double speed);

    /**
     * set the power of the wrist.
     *
     * @param power the power to apply on the wrist.
     */
    public abstract void setPower(double power);

    /**
     * Check whether the wrist at the top possible position.
     *
     * @return whether or not the wrist at the top position.
     */
    public abstract boolean atTop();

    /**
     * Check whether the wrist at the bottom possible position.
     *
     * @return whether or not the wrist at the bottom position.
     */
    public abstract boolean atBottom();

    /**
     * @return the velocity applied in the wrist.
     */
    public abstract int getVelocity();

    /**
     * @return the maximum angle that the wrist can reach to.
     */
    public abstract double getMaxAngle();

    /**
     * @return the minimum angle that the wrist can reach to.
     */
    public abstract double getMinAngle();

    /**
     * Apply force base on the current angle of the wrist,
     * so the wrist won't apply to much or the opposite forces.
     * @param angle the current angle of the wrist.
     * @return The force you need to apply so that the wrist move at same speed.
     */
    public abstract double applyForceByAngle(double angle);
}
