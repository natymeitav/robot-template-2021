package frc.robot.subsystems.base.gripper;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * @author Barel
 * @version 1.0
 * @since 2020-off
 * <p>
 * The class contains various methods that every {@code Gripper} <b>should</b> implement.
 * <p>
 * The purpose of this class is to provide guidelines and restrict what's important to us and what's not.
 */
public abstract class GripperBase extends SubsystemBase {

    /**
     * Get the current distance from an object.
     *
     * @return the distance from an object.
     */
    public abstract double getDistance();

    /**
     * @return whether or not an object is inside the gripper
     */
    public abstract boolean isObjectInside();

    /**
     * @return the current speed in the right side of the gripper.
     */
    public abstract double getRightSpeed();

    /**
     * Set speed to the right side of the gripper.
     *
     * @param speed the speed to apply on the right side of the gripper.
     */
    public abstract void setRightSpeed(double speed);

    /**
     * @return the current speed in the left side of the gripper.
     */
    public abstract double getLeftSpeed();

    /**
     * Set speed to the left side of the gripper.
     *
     * @param speed the speed to apply on the left side of the gripper.
     */
    public abstract void setLeftSpeed(double speed);

    /**
     * Set the speed for both of the wheels.
     *
     * @param leftSpeed the power to apply on the left side of the gripper.
     * @param rightSpeed the power to apply on the right side of the gripper.
     */
    public void setSpeed(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }

    /**
     * Set the <b>same</b> speed to both sides of the gripper.
     *
     * @param speed the speed to apply on both side of the gripper.
     */
    public void setSpeed(double speed) {
        setSpeed(speed, speed);
    }
}
