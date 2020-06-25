package frc.robot.subsystems.base.conveyor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class ConveyorBase extends SubsystemBase {

    public abstract double getPosition();

    public abstract double getPower();

    public abstract void setPower(double power);

    public abstract void feed();

    public abstract void stop();


}
