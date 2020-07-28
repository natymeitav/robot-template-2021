package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Intake extends SubsystemBase {
    public final TalonSRX motor = new TalonSRX(Ports.Intake.MOTOR);
    private final Solenoid piston = new Solenoid(2);

    public Intake() {
        motor.setInverted(Ports.Intake.IS_INVERTED);
    }

    public void SetPower(double power) {
        motor.set(ControlMode.PercentOutput, power);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }


    public enum state {
        OPEN,
        CLOSE,
        TOGGLE
    }

    public void setPiston(state pistonState) {
        switch (pistonState) {
            case OPEN:
                piston.set(true);
                break;

            case CLOSE:
                piston.set(false);
                break;

            case TOGGLE:
                piston.set(!piston.get());
                break;
        }
    }
}
