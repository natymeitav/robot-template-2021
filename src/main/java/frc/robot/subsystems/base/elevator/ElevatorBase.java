package frc.robot.subsystems.base.elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Barel
 * @version 1.0
 * @since 2020-off
 * <p>
 * The class contains various methods that every {@code Elevator} <b>should</b> implement.
 * <p>
 * The purpose of this class is to provide guidelines and restrict what important to us and what not.
 */
public abstract class ElevatorBase extends SubsystemBase {

    /**
     * @return the current height of the elevator.
     */
    public abstract double getHeight();

    /**
     * Move the elevator to the desired {@code height}
     *
     * @param height the desired height.
     */
    public abstract void setHeight(double height);

    /**
     * @return the current speed of the elevator.
     */
    public abstract double getSpeed();

    /**
     * Move the elevator based on the {@code speed}.
     *
     * @param speed the speed you want to move the elevator.
     */
    public abstract void setSpeed(double speed);

    /**
     * @return whether or not the elevator at the highest possible location.
     */
    public abstract boolean atTop();

    /**
     * @return whether or not the elevator at the bottom possible height.
     */
    public abstract boolean atBottom();
}
