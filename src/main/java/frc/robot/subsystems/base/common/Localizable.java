package frc.robot.subsystems.base.common;

import edu.wpi.first.wpilibj.geometry.Pose2d;

public interface Localizable {

    double getHeading();
    double getCCWHeading();

    Pose2d getPose();
    void setPose(Pose2d desiredPose);
}
