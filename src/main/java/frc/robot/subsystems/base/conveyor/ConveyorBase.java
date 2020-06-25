package frc.robot.subsystems.base.conveyor;

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
public abstract class ConveyorBase extends SubsystemBase {

    /**
     * Retrieve the current motor's encoder position.
     *
     * @return the current motor's encoder position.
     */
    public abstract double getPosition();

    /**
     * Return the power which the motor is turning at.
     *
     * @return the power of the motor.
     */
    public abstract double getPower();

    /**
     * set the power for the motor.
     *
     * @param power The power given to the motor from -1 to 1.
     */
    public abstract void setPower(double power);

    /**
     * feed the conveyor in one Power Cell per run.
     */
    public abstract void feed();

    /**
     * stop the conveyor's motors from moving.
     */
    public abstract void stop();


}
