package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.IntakeBolaConstants;
import frc.robot.subsystems.bola.IntakeBola;

public class IntakeBolaSpinToIntake extends Command {

    private final IntakeBola intakeBola;

    public IntakeBolaSpinToIntake(IntakeBola intakeBola){
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Ligando rodinhas");
    }
    
    @Override
    public void execute(){
        IntakeBola.motorColeta.set(IntakeBolaConstants.speed.SPEED_INTAKE);
    }

    @Override
    public boolean isFinished(){
        if(intakeBola.ativado() == true){
            return false;            
        } else {
            return true;
        }
    }

}
