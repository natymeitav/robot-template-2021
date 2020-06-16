package frc.robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.drivetrain.SwerveDrive;

import static frc.robot.Constants.SwerveDrive.JOYSTICK_THRESHOLD;

public class HolonomicDrive extends Command {

    private SwerveDrive swerveDrive;

    public HolonomicDrive(SwerveDrive swerveDrive) {
        this.swerveDrive = swerveDrive;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double forward = -OI.getJoystickY();
        double strafe = OI.getJoystickX();
        double rotation = OI.getJoystickZ();

        forward = joystickDeadband(forward);
        strafe = joystickDeadband(strafe);
        rotation = joystickDeadband(rotation);

        swerveDrive.holonomicDrive(forward, strafe, rotation);
    }

    /**
     * sets the value of the joystick to 0 if the value is less than the threshold
     * @param val the joystick value
     * @return 0 if val is less than the threshold else val
     */
    private double joystickDeadband(double val) {
        if (val < JOYSTICK_THRESHOLD)
            return 0;
        return val;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {
        swerveDrive.stop();
    }



}
