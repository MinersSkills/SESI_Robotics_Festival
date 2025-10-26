package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.IntakeBolaConstants;
import frc.robot.subsystems.bola.IntakeBola;

public class IntakeBolaUP extends Command {

    private final IntakeBola intakeBola;
    double tolerancia = 0.0;

    public IntakeBolaUP(IntakeBola intakeBola){
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Voltando intake");
    }
    
    @Override
    public void execute(){
        intakeBola.setReferencia(IntakeBolaConstants.setpoints.SHOOT_POSITION);
        tolerancia = IntakeBolaConstants.setpoints.SHOOT_POSITION - intakeBola.encoder_bola.getPosition();
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
