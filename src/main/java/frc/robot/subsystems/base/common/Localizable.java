package frc.robot.subsystems.base.common;

import edu.wpi.first.wpilibj.geometry.Pose2d;

/**
 * Add methods that indicated that the subsystem needs to use localization.
 * <p>
 *
 * @author Barel
 * @version 1.0
 * @since 2020-off
 */
public interface Localizable {

    /**
     * @return the angle of the heading (clockwise).
     */
    double getHeading();

    /**
     * @return the angle of the heading (counter clockwise).
     */
    default double getCCWHeading() {
        return -getHeading();
    }

    /**
     * @return the distance of the left side from the object.
     */
    double getLeftDistance();

    /**
     * @return the distance of the right side from the object.
     */
    double getRightDistance();

    /**
     * reset the pose to the default starting location.
     */
    void resetPose();

    /**
     * @return the angle of the subsystem.
     */
    double getAngle();

    /**
     * @return the position in the world.
     */
    Pose2d getPose();

    /**
     * Change the position of the subsystem.
     *
     * @param desiredPose the desired position to move to.
     */
    void setPose(Pose2d desiredPose);
}
