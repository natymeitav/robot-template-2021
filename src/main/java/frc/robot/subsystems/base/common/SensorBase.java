package frc.robot.subsystems.base.common;

/**
 * Add methods that indicated that the subsystem that sensors are major part of the subsystem.
 * <p>
 *
 * @author Barel
 * @version 1.0
 * @since 2020-off
 */
public interface SensorBase {

    /**
     * Update the values from the sensors.
     */
    void update();

    /**
     * reset the values to the default.
     */
    void reset();

    /**
     * @return whether the object was sensed by the proximity.
     */
    boolean getState();

    /**
     * Return whether the proximity senses an object.
     * If you wish to check whether the proximity lost the object, use {@link #isAway()} instead.
     *
     * @return whether the proximity sense a object.
     */
    boolean isClose();

    /**
     * Return whether the proximity lost the object.
     * If you wish to check whether the proximity sense the object, use {@link #isClose()} instead.
     *
     * @return whether the proximity lost the object.
     */
    boolean isAway();
}
