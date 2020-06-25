package frc.robot.subsystems.base.common;

import edu.wpi.first.wpilibj.geometry.Pose2d;

public interface Localizable {

    double getHeading();

    double getCCWHeading();

    double getLeftDistance();

    double getRightDistance();

    void resetPose();

    double getAngle();

    Pose2d getPose();

    void setPose(Pose2d desiredPose);
}
