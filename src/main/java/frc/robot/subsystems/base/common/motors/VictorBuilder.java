package frc.robot.subsystems.base.common.motors;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * Provide a builder for Victor motors.
 *
 * @author Barel
 * @version 1.0
 * @since 2020-off
 */
public class VictorBuilder {
    private final VictorSPX motor;

    /**
     * Create a builder for the victors.
     *
     * @param port         the port of the victor.
     * @param inverted     whether the victor is inverted.
     * @param openLoopRamp Configures the open-loop ramp rate.
     */
    public VictorBuilder(int port, boolean inverted, double openLoopRamp) {
        motor = new VictorSPX(port);
        motor.configFactoryDefault();
        motor.setInverted(inverted);
        motor.configOpenloopRamp(openLoopRamp);
        motor.setNeutralMode(NeutralMode.Coast);
        motor.enableVoltageCompensation(true);
        motor.configVoltageCompSaturation(12.);
    }

    /**
     * Set PID to victors.
     *
     * @param kp      proportional.
     * @param ki      integral.
     * @param kd      derivative.
     * @param kf      feed-forward.
     * @param victors victors to configure.
     */
    public static void configPID(double kp, double ki, double kd, double kf, VictorSPX... victors) {
        for (VictorSPX motor : victors) {
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
    public VictorBuilder overrideNeuralMode(NeutralMode mode) {
        motor.setNeutralMode(mode);
        return this;
    }

    /**
     * @param position    sensor position.
     * @param sensorPhase the phase of the sensor.
     * @return a reference to this object.
     * @see #addSensor(boolean)
     */
    public VictorBuilder addSensor(int position, boolean sensorPhase) {
        motor.setSelectedSensorPosition(position);
        motor.setSensorPhase(sensorPhase);

        return this;
    }

    /**
     * @param sensorPhase the phase of the sensor.
     * @return a reference to this object.
     * @see #addSensor(int, boolean)
     */
    public VictorBuilder addSensor(boolean sensorPhase) {
        return addSensor(0, sensorPhase);
    }

    /**
     * config the PID for the victor.
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
    public VictorBuilder addPID(int slot, double kp, double ki, double kd, double kf, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);

        return this;
    }

    /**
     * config the PID for the victor.
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
    public VictorBuilder addPID(int slot, double kp, double ki, double kd, double kf) {
        return addPID(slot, kp, ki, kd, kf, 10);
    }

    /**
     * config the PID for the victor.
     *
     * @param kp proportional.
     * @param ki integral.
     * @param kd derivative.
     * @param kf feed-forward.
     * @return a reference to this object.
     * @see #addPID(int, double, double, double, double)
     * @see #addPID(int, double, double, double, double, int)
     */
    public VictorBuilder addPID(double kp, double ki, double kd, double kf) {
        return addPID(0, kp, ki, kd, kf);
    }

    /**
     * config the soft limits and cruise velocity.
     *
     * @param sofLimitEnabled whether the soft limit is enabled.
     * @param softThreshold   the threshold.
     * @param cruiseVelocity  cruise velocity.
     * @return a reference to this object.
     */
    public VictorBuilder configPhysics(boolean sofLimitEnabled, int softThreshold, int cruiseVelocity) {
        motor.configForwardSoftLimitEnable(sofLimitEnabled);
        motor.configReverseSoftLimitEnable(sofLimitEnabled);
        motor.configForwardSoftLimitThreshold(softThreshold);
        motor.configReverseSoftLimitThreshold(softThreshold);

        motor.configMotionCruiseVelocity(cruiseVelocity);
        return this;
    }

    /**
     * @param master the victor to follow.
     * @return a reference to this object.
     */
    public VictorBuilder follow(VictorSPX master) {
        motor.follow(master);
        return this;
    }

    /**
     * @param master the talon to follow.
     * @return a reference to this object.
     */
    public VictorBuilder follow(TalonSRX master) {
        motor.follow(master);
        return this;
    }

    /**
     * @param master the falcon to follow.
     * @return a reference to this object.
     */
    public VictorBuilder follow(TalonFX master) {
        motor.follow(master);
        return this;
    }
    
    /**
     * Create a victor object.
     *
     * @return new Victor.
     */
    public VictorSPX build() {
        return motor;
    }
}
