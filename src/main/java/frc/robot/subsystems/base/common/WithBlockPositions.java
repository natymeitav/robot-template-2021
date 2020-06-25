package frc.robot.subsystems.base.common;

public interface WithBlockPositions {

    boolean inCorrectRange();

    boolean inDeadZone();

    double getNearestPosition(double targetAngle, double currentPosition, double minPos, double maxPos);

    boolean checkValidity(double position);
}
