package frc.robot.commands.cBoia;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.IntakeBoiaConstants;
import frc.robot.subsystems.boia.IntakeBoia;

public class IntakeBoiaSpinToIntake extends Command {

    private final IntakeBoia intakeBoia;

    public IntakeBoiaSpinToIntake(IntakeBoia intakeBoia){
        this.intakeBoia = intakeBoia;
        addRequirements(intakeBoia);
    }

    @Override
    public void initialize(){
        System.out.println("Ligando rodinhas para coleta");
    }
    
    @Override
    public void execute(){
        IntakeBoia.motorIntakeBoiaColeta.set(IntakeBoiaConstants.speed.SPEED_INTAKE);
    }

    @Override
    public void end(boolean interrupted) {
        intakeBoia.motorIntakeBoiaColeta.disable();
    }

    @Override
    public boolean isFinished(){
        if(intakeBoia.ativado() == true){
            return true;            
        } else {
            return false;
        }
    }

}
