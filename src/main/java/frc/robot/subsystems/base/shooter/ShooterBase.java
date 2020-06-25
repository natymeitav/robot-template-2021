package frc.robot.subsystems.base.shooter;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class ShooterBase extends SubsystemBase {

    public void configPID(TalonFX motor, double kp, double ki, double kd, double kf, int slot, int timeout) {
        motor.config_kP(slot, kp, timeout);
        motor.config_kI(slot, ki, timeout);
        motor.config_kD(slot, kd, timeout);
        motor.config_kF(slot, kf, timeout);
    }

    public void configPID(TalonFX motor, double kp, double ki, double kd, double kf) {
        configPID(motor, kp, ki, kd, kf, 0, 10);
    }

    public abstract double getSpeed();

    public abstract void setSpeed(double speed);

    public abstract boolean isShooterReady();

    public abstract boolean isShooting();

    public abstract void setPower(double power);

    public void stop() {
        setPower(0);
    }


}
