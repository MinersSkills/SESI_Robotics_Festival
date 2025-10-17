package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.bola.IntakeBola;

public class IntakeBolaParar extends Command {

    private final IntakeBola intakeBola;
    private final double setpoint = 1;
    double tolerancia = 0.0;

    public IntakeBolaParar(IntakeBola intakeBola){
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Voltando intake");
    }
    
    @Override
    public void execute(){
        intakeBola.setReferencia(setpoint);
        tolerancia = setpoint - intakeBola.encoder_bola.getPosition();
    }

    @Override
    public boolean isFinished(){
        if (intakeBola.ativado() == true){
            return false;
        } else{
            return true;
        }
    }

}
