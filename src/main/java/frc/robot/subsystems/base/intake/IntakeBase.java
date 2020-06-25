package frc.robot.subsystems.base.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class IntakeBase extends SubsystemBase {

    public abstract boolean isOpen();

    public abstract boolean isClose();

    public abstract void setPosition(boolean open);

    public abstract void togglePosition(); //auto change


    /**
     * Returns the reading from the potentiometer through the talon. Note, this value is an integer,
     * and ranges from 0-1023, similarly to how Arduino devices read voltage.
     *
     * @return Proximity voltage reading in native units.
     */
    public abstract int getSensorValue();

    public abstract void powerWheels(double power);

    public void stopWheels() {
        powerWheels(0);
    }

}
