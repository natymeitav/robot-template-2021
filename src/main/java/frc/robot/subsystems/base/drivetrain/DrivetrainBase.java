package frc.robot.subsystems.base.drivetrain;

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
public abstract class DrivetrainBase extends SubsystemBase {

    /**
     * Set the power to apply on the drivetrain.
     *
     * @param leftPower  the power to apply on the left side of the drivetrain.
     * @param rightPower the power to apply on the right side of the drivetrain.
     */
    public abstract void setPower(double leftPower, double rightPower);

    /**
     * Set the speed you want the drivetrain to move.
     *
     * @param leftSpeed  the speed on the left side of the drivetrain.
     * @param rightSpeed the speed on the right side of the drivetrain.
     */
    public void setSpeed(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }

    /**
     * @return the left velocity on the left side of the drivetrain, in "m / sec".
     */
    public abstract double getLeftVelocity();

    /**
     * @return the left velocity on the right side of the drivetrain, in "m / sec".
     */
    public abstract double getRightVelocity();

    /**
     * Set the speed to move the left side of the drivetrain.
     *
     * @param speed the speed you want the left side of the drivetrain.
     */
    public abstract void setLeftSpeed(double speed);

    /**
     * Set the speed to move the right side of the drivetrain.
     *
     * @param speed the speed you want the right side of the drivetrain.
     */
    public abstract void setRightSpeed(double speed);

    /**
     * set the brake mode of the drivetrain.
     *
     * @param brake the type of the brake mode (Brake or Coast).
     * @see com.ctre.phoenix.motorcontrol.NeutralMode
     */
    public abstract void setBrake(boolean brake);
}
