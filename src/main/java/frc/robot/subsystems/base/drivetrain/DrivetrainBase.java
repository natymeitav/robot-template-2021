package frc.robot.subsystems.base.drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.UnitModel;

public abstract class DrivetrainBase extends SubsystemBase {
    
    public abstract void setPower(double leftPower, double rightPower);

    public void setSpeed(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }

    public abstract double getLeftVelocity();

    public abstract double getRightVelocity();

    public abstract double getLeftSpeed();

    public abstract void setLeftSpeed(double speed);

    public abstract double getRightSpeed();

    public abstract void setRightSpeed(double speed);

    public abstract void setBrake(boolean brake);

}
