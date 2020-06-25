package frc.robot.subsystems.base.gripper;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class GripperBase extends SubsystemBase {

    public abstract double getDistance();

    public abstract boolean isObjectInside();

    public abstract double getRightSpeed();

    public abstract void setRightSpeed(double speed);

    public abstract double getLeftSpeed();

    public abstract void setLeftSpeed(double speed);

    public void setSpeed(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }

    public void setSpeed(double speed) {
        setSpeed(speed, speed);
    }
}