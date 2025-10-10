package frc.robot.commands;

import frc.robot.subsystems.IntakeBola;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeBolaParar extends Command {

    private final IntakeBola intakeBola;

    public IntakeBolaParar(IntakeBola intakeBola, double setpoint){
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Voltando intake");
    }
    
    @Override
    public void execute(){
        intakeBola.setReferencia(0.3);
        intakeBola.motorColeta.set(0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
