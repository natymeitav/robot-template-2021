package frc.robot.subsystems.base.common.motors;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.utilities.VictorConfiguration;

public class VictorBuilder {
    private final VictorSPX motor;

    public VictorBuilder(int port, boolean inverted, double openLoopRamp) {
        motor = new VictorSPX(port);
        motor.configFactoryDefault();
        motor.setInverted(inverted);
        motor.configOpenloopRamp(openLoopRamp);
        motor.setNeutralMode(NeutralMode.Coast);
        motor.enableVoltageCompensation(true);
        motor.configVoltageCompSaturation(12.);
    }

    public static void configMotors(VictorConfiguration configurations, VictorSPX... victors) {
        for (VictorSPX victor : victors) {
            victor.configAllSettings(configurations.motorConfigs);
            victor.configVoltageCompSaturation(configurations.getVoltageCompensationSaturation());
            victor.setNeutralMode(configurations.getNeutralMode());
            victor.enableVoltageCompensation(configurations.isEnableVoltageCompensation());
        }
    }

    public static void configPID(double kp, double ki, double kd, double kf, VictorSPX... victors) {
        for (VictorSPX motor : victors) {
            motor.config_kP(0, kp, 10);
            motor.config_kI(0, ki, 10);
            motor.config_kD(0, kd, 10);
            motor.config_kF(0, kf, 10);
        }
    }

    public VictorBuilder overrideNeuralMode(NeutralMode mode) {
        motor.setNeutralMode(mode);
        return this;
    }

    public VictorBuilder addSensor(int position, boolean sensorPhase) {
        motor.setSelectedSensorPosition(position);
        motor.setSensorPhase(sensorPhase);

        return this;
    }

    public VictorBuilder addSensor(boolean sensorPhase) {
        return addSensor(0, sensorPhase);
    }

    public VictorBuilder addPID(int slot, double kp, double ki, double kd, double kf, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);

        return this;
    }

    public VictorBuilder addPID(int slot, double kp, double ki, double kd, double kf) {
        return addPID(slot, kp, ki, kd, kf, 10);
    }

    public VictorBuilder addPID(double kp, double ki, double kd, double kf) {
        return addPID(0, kp, ki, kd, kf);
    }

    public VictorBuilder configPhysics(boolean sofLimitEnabled, int softThreshold, int cruiseVelocity) {
        motor.configForwardSoftLimitEnable(sofLimitEnabled);
        motor.configReverseSoftLimitEnable(sofLimitEnabled);
        motor.configForwardSoftLimitThreshold(softThreshold);
        motor.configReverseSoftLimitThreshold(softThreshold);

        motor.configMotionCruiseVelocity(cruiseVelocity);
        return this;
    }

    public VictorBuilder follow(TalonFX master) {
        motor.follow(master);
        return this;
    }

    public VictorSPX build() {
        return motor;
    }
}
