package frc.robot.commands;

import frc.robot.subsystems.IntakeBola;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeBolaOff extends Command {

    private final IntakeBola intakeBola;

    public IntakeBolaOff(IntakeBola intakeBola){
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Ligando rodinhas");
    }
    
    @Override
    public void execute(){
        intakeBola.motorColeta.disable();
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
