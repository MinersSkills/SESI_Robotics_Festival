package frc.robot.commands.cDrive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drive;

public class DriveRight extends Command {

    private final Drive drive;
    private final double speed;
    private final double duration;
    private final Timer timer = new Timer();

    public DriveRight(Drive drive, double speed, double duration) {
        this.drive = drive;
        this.speed = speed;
        this.duration = duration;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        drive.frenteDireita.set(-speed);
        drive.trasDireita.set(-speed);
    }

    @Override
    public void end(boolean interrupted){
        drive.frenteDireita.disable();
        drive.trasDireita.disable();
    }

    @Override
    public boolean isFinished() {
        if (timer.get() >= duration) {
            return true;
        } else {
            return false;
        }
    }
}