package frc.robot.subsystems.base.common;

public interface SensorBase {
    void update();

    void reset();

    boolean getState();

    boolean isClose();

    boolean isAway();
}
