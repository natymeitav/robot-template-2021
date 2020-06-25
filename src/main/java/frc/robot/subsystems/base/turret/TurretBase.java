package frc.robot.subsystems.base.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class TurretBase extends SubsystemBase {

    public abstract double getAngle();

    public abstract void setAngle(double angle);

    public abstract void setPower(double speed);

    public abstract void stop();

    public abstract double getNearestPosition(double targetAngle, double currentPosition, double minPos, double maxPos);

    public abstract boolean isReady();

    public abstract boolean inCorrectRange();

    public abstract boolean inDeadZone();
}
