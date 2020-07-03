package frc.robot.subsystems.base.common.motors;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

/**
 * A builder for Talon FX motor controllers.
 *
 * @author Barel
 * @version 1.0
 * @since 2020-off
 */
public class FalconBuilder {
    private final TalonFX motor;

    /**
     * Create a builder for the falcons.
     *
     * @param port         the port of the falcon.
     * @param inverted     whether the falcon is inverted.
     * @param openLoopRamp Configures the open-loop ramp rate.
     */
    public FalconBuilder(int port, boolean inverted, double openLoopRamp) {
        motor = new TalonFX(port);
        motor.configFactoryDefault();
        motor.setInverted(inverted);
        motor.configOpenloopRamp(openLoopRamp);
        motor.setNeutralMode(NeutralMode.Coast);
        motor.enableVoltageCompensation(true);
        motor.configVoltageCompSaturation(12.);
        motor.overrideSoftLimitsEnable(false);
        motor.overrideLimitSwitchesEnable(false);
    }

    /**
     * Set PID to falcons.
     *
     * @param kp      proportional.
     * @param ki      integral.
     * @param kd      derivative.
     * @param kf      feed-forward.
     * @param falcons falcons to configure.
     */
    public static void configPID(double kp, double ki, double kd, double kf, TalonFX... falcons) {
        for (TalonFX motor : falcons) {
            motor.config_kP(0, kp, 10);
            motor.config_kI(0, ki, 10);
            motor.config_kD(0, kd, 10);
            motor.config_kF(0, kf, 10);
        }
    }

    /**
     * @param mode the new mode.
     * @return a reference to this object.
     */
    public FalconBuilder overrideNeuralMode(NeutralMode mode) {
        motor.setNeutralMode(mode);
        return this;
    }

    /**
     * @param position    sensor position.
     * @param sensorPhase the phase of the sensor.
     * @return a reference to this object.
     * @see #addSensor(boolean)
     */
    public FalconBuilder addSensor(int position, boolean sensorPhase) {
        motor.setSelectedSensorPosition(position);
        motor.setSensorPhase(sensorPhase);

        return this;
    }

    /**
     * @param sensorPhase the phase of the sensor.
     * @return a reference to this object.
     * @see #addSensor(int, boolean)
     */
    public FalconBuilder addSensor(boolean sensorPhase) {
        return addSensor(0, sensorPhase);
    }

    /**
     * config the PID for the falcon.
     *
     * @param slot    the slot of the pid.
     * @param kp      proportional.
     * @param ki      integral.
     * @param kd      derivative.
     * @param kf      feed-forward.
     * @param timeout the delta time between each change to the PID.
     * @return a reference to this object.
     * @see #addPID(int, double, double, double, double)
     * @see #addPID(double, double, double, double)
     */
    public FalconBuilder addPID(int slot, double kp, double ki, double kd, double kf, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);

        return this;
    }

    /**
     * config the PID for the falcon.
     *
     * @param slot the slot of the pid.
     * @param kp   proportional.
     * @param ki   integral.
     * @param kd   derivative.
     * @param kf   feed-forward.
     * @return a reference to this object.
     * @see #addPID(int, double, double, double, double, int)
     * @see #addPID(double, double, double, double)
     */
    public FalconBuilder addPID(int slot, double kp, double ki, double kd, double kf) {
        return addPID(slot, kp, ki, kd, kf, 10);
    }

    /**
     * config the PID for the falcon.
     *
     * @param kp proportional.
     * @param ki integral.
     * @param kd derivative.
     * @param kf feed-forward.
     * @return a reference to this object.
     * @see #addPID(int, double, double, double, double)
     * @see #addPID(int, double, double, double, double, int)
     */
    public FalconBuilder addPID(double kp, double ki, double kd, double kf) {
        return addPID(0, kp, ki, kd, kf);
    }

    /**
     * config the soft limits and cruise velocity.
     *
     * @param sofLimitEnabled whether the soft limit is enabled.
     * @param softThreshold   the threshold.
     * @return a reference to this object.
     */
    public FalconBuilder configSoftLimit(boolean sofLimitEnabled, int softThreshold) {
        motor.configForwardSoftLimitEnable(sofLimitEnabled);
        motor.configReverseSoftLimitEnable(sofLimitEnabled);
        motor.configForwardSoftLimitThreshold(softThreshold);
        motor.configReverseSoftLimitThreshold(softThreshold);

        return this;
    }


    /**
     * config the acceleration and the cruise velocity.
     *
     * @param acceleration the acceleration in for the motor.
     * @param cruiseVelocity  cruise velocity.
     * @return a reference to this object.
     */
    public FalconBuilder configVelocityAndAcceleration(int acceleration, int cruiseVelocity) {
        motor.configMotionAcceleration(acceleration);
        motor.configMotionCruiseVelocity(cruiseVelocity);

        return this;
    }


    /**
     * config the current limit.
     *
     * @param enabled       whether the limit is enabled.
     * @param supply        current limit to supply.
     * @param threshold     the threshold.
     * @param thresholdTime the threshold time.
     * @return a reference to this object.
     */
    public FalconBuilder configCurrentLimit(boolean enabled, double supply, double threshold, int thresholdTime) {
        motor.configSupplyCurrentLimit(
                new SupplyCurrentLimitConfiguration(enabled, supply, threshold, thresholdTime)
        );

        return this;
    }

    /**
     * @param master the falcon to follow.
     * @return a reference to this object.
     */
    public FalconBuilder follow(TalonFX master) {
        motor.follow(master);
        return this;
    }

    /**
     * Create a falcon object.
     *
     * @return new Falcon.
     */
    public TalonFX build() {
        return motor;
    }
}
