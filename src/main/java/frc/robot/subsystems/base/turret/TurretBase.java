package frc.robot.subsystems.base.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Barel
 * @version 1.0
 * @since 2020-off
 * <p>
 * The class contains various methods that every {@code Turret} <b>should</b> implement.
 * <p>
 * The purpose of this class is to provide guidelines and restrict what important to us and what not.
 */
public abstract class TurretBase extends SubsystemBase {

    /**
     * Get the current angle of the turret in <b>degrees</b>.
     *
     * @return the current angle of the turret.
     */
    public abstract double getAngle();

    /**
     * Move the turret to the desired angle.
     *
     * @param angle the desired angle.
     */
    public abstract void setAngle(double angle);

    /**
     * Apply power on the turret.
     *
     * @param speed the amount of forces to apply on the turret.
     */
    public abstract void setPower(double speed);

    /**
     * Stop the turret in the current position (or as close as possible).
     */
    public abstract void stop();
}
