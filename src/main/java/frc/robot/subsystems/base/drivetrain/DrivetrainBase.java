package frc.robot.subsystems.base.drivetrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.UnitModel;

public abstract class DrivetrainBase extends SubsystemBase {
    protected UnitModel defaultConversionModel;

    protected DrivetrainBase() {
    }

    public abstract void setPower(double leftPower, double rightPower);

    public abstract double getLeftVelocity();

    public abstract double getRightVelocity();

    public abstract void setBrake(boolean brake);

}
