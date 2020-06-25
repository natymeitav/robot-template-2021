package frc.robot.subsystems.base.common;

/**
 * Add methods that indicated that the subsystem have block areas.
 * <p>
 *
 * @author Barel
 * @version 1.0
 * @since 2020-off
 */
public interface WithBlockPositions {

    /**
     * @return whether the subsystem in valid position.
     */
    boolean inCorrectRange(double position);

    /**
     * @return whether the subsystem in invalid position.
     */
    boolean inDeadZone(double position);

    /**
     * Set the velocity you need to apply in valid path in order to come into the target position.
     *
     * @param targetPos       the target position.
     * @param currentPosition the current position.
     * @param minPos          the minimum position.
     * @param maxPos          the maximum position.
     * @return
     */
    double getNearestPosition(double targetPos, double currentPosition, double minPos, double maxPos);

    /**
     * Check the validity of the position.
     *
     * @param position the position to check.
     * @return whether the position is valid.
     */
    boolean checkValidity(double position);
}
