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
    public abstract double getSpeed();

    public abstract void setSpeed(double speed);

    public abstract boolean isShooterReady();

    public abstract boolean isShooting();

    public abstract void setPower(double power);

    public void stop() {
        setPower(0);
    }


}
