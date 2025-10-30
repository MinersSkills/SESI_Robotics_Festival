package frc.robot.commands.cBoia;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.boia.IntakeBoia;

public class IntakeBoiaOff extends Command {

    private final IntakeBoia intakeBoia;

    public IntakeBoiaOff(IntakeBoia intakeBoia) {
        this.intakeBoia = intakeBoia;
        addRequirements(intakeBoia);
    }

    @Override
    public void initialize() {
        System.out.println("Parando intake boia");
    }

    @Override
    public void execute() {
        intakeBoia.setDefaultPosition();
        intakeBoia.motorIntakeBoiaColeta.disable();
    }

    @Override
    public boolean isFinished() {
        return false; 
    }
        
}


