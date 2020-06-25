package frc.robot.subsystems.base.wrist;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class WristBase extends SubsystemBase {

    public abstract double getAngle();

    public abstract void setAngle(double angle);

    public abstract double getSpeed();

    public abstract void setSpeed(double speed);

    public abstract void setPower(double power);

    public abstract boolean atPeak();

    public abstract boolean atClosed();

    public abstract int getVelocity();

    public abstract double getMaxAngle();

    public abstract double getMinAngle();

    public abstract double applyForceByAngle(double angle);
}
