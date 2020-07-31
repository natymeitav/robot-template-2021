package frc.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;


public class drivetrain extends SubsystemBase {
    public final TalonFX motorRight = new TalonFX(1);
    public final TalonFX followRight = new TalonFX(2);
    public final TalonFX motorLeft = new TalonFX(3);
    public final TalonFX followLeft = new TalonFX(4);

    public drivetrain() {
        followRight.follow(motorRight);
        followLeft.follow(motorLeft);

        motorRight.setInverted(Ports.Drivetrain.IS_INVERTED);
        followRight.setInverted(Ports.Drivetrain.IS_INVERTED);
        motorLeft.setInverted(Ports.Drivetrain.ISNT_INVERTED);
        followLeft.setInverted(Ports.Drivetrain.ISNT_INVERTED);
    }

    /**
     * This function gets the distance that the right motors have gone. It uses UnitModel to turn the amount of ticks into meters.
     */
    public void getDistanceRight(){
        System.out.println(ticksPerMetetr.toTicks(motorRight.getSelectedSensorPosition()));
        }

    /**
     * This function gets the distance that the left motors have gone. It uses UnitModel to turn the amount of ticks into meters.
     */
    public void getDistanceLeft(){
        System.out.println(ticksPerMetetr.toTicks(motorLeft.getSelectedSensorPosition()));
    }

    public void SetPower(double leftPower, double rightPower) {
        motorRight.set(ControlMode.PercentOutput, rightPower);
        motorLeft.set(ControlMode.PercentOutput, leftPower);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    UnitModel ticksPerMetetr = new UnitModel();


}