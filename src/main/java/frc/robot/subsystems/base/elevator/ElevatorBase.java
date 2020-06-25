package frc.robot.subsystems.base.elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class ElevatorBase extends SubsystemBase {

    public abstract double getHeight();

    public abstract void setHeight(double height);

    public abstract double getTicks();

    public abstract double getSpeed();

    public abstract void setSpeed(double speed);

    public abstract boolean atTop();

    public abstract boolean atBottom();
}
