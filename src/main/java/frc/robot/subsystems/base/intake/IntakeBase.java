package frc.robot.subsystems.base.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Barel
 * @version 1.0
 * @since 2020-off
 * <p>
 * The class contains various methods that every {@code Intake} <b>should</b> implement.
 * <p>
 * The purpose of this class is to provide guidelines and restrict what important to us and what not.
 */

public abstract class IntakeBase extends SubsystemBase {

    /**
     * @return whether or not the shooter is opened.
     */
    public abstract boolean isOpen();

    /**
     * @return whether or not the shooter is closed.
     */
    public abstract boolean isClose();

    /**
     * Move the intake to the desired position.
     *
     * @param open whether you want to open the intake or not.
     */
    public abstract void setPosition(boolean open);

    /**
     * Move the intake based on the current position of the intake.
     */
    public abstract void togglePosition();

    /**
     * Returns the reading from the potentiometer through the talon. Note, this value is an integer,
     * and ranges from 0-1023, similarly to how Arduino devices read voltage.
     *
     * @return Proximity voltage reading in native units.
     */
    public abstract int getSensorValue();

    /**
     * Move the wheel of the intake.
     *
     * @param power the power you want to apply on the intake.
     */
    public abstract void powerWheels(double power);

    /**
     * Stop the wheels of the intake from moving.
     */
    public void stopWheels() {
        powerWheels(0);
    }

}
