package frc.robot.subsystems.base.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Barel
 * @version 1.0
 * @since 2020-off
 * <p>
 * The class contains various methods that every {@code Shooter} <b>should</b> implement.
 * <p>
 * The purpose of this class is to provide guidelines and restrict what important to us and what not.
 */

public abstract class ShooterBase extends SubsystemBase {

    /**
     * Get the current speed of the shooter in RPM.
     *
     * @return the speed of the shooter in rpm.
     */
    public abstract double getSpeed();

    /**
     * Set the speed of the shooter.
     *
     * @param speed the rotations per second of the shooter.
     */
    public abstract void setSpeed(double speed);

    /**
     * @return whether or not the shooter is fast enough to shoot.
     */
    public abstract boolean isReady();

    /**
     * @return whether or not the shooter is shooting.
     */
    public abstract boolean isShooting();

    /**
     * Approximate the velocity you need to apply in order to shoot as correct as possible.
     *
     * @param distance the distance away from the target.
     * @return the calculated velocity to get to the target in <b>rps</b>.
     */
    public abstract double approximateVelocity(double distance);

    /**
     * Set the power of the shooter.
     *
     * @param power the power you want to apply
     */
    public abstract void setPower(double power);

    /**
     * Stop the shooter, so it won't move.
     */
    public void stop() {
        setPower(0);
    }
}
