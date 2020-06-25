package frc.robot.subsystems.base.climb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class ClimberBase extends SubsystemBase {

    public abstract boolean isStopperEngaged();

    public abstract void engageStopper();

    public abstract void releaseStopper();

    public abstract double getLeftHeight();

    public abstract void setLeftHeight(double height);

    public abstract void setLeftHeight(double height, double kF);

    public abstract double getRightHeight();

    public abstract void setRightHeight(double height);

    public abstract void setRightHeight(double height, double kF);

    public abstract void setLeftPower(double power);

    public abstract void setRightPower(double power);

    public abstract boolean isSafeToClimb();

    public abstract double normalizeSetpoint(double setpoint);

    public abstract double normalizeDelta(double delta);
}
