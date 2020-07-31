package frc.robot.subsystems.DriveTrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain.drivetrain;


/**
 * An example command that uses an example subsystem.
 */
public class DriveCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final drivetrain m_subsystem;
    private double power;

    public DriveCommand(drivetrain m_subsystem) {
        this.m_subsystem = m_subsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_subsystem.SetPower(-RobotContainer.left.getY(), -RobotContainer.right.getY());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_subsystem.SetPower(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}

