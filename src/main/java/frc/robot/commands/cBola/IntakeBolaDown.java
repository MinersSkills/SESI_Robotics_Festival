package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.IntakeBolaConstants;
import frc.robot.subsystems.bola.IntakeBola;

public class IntakeBolaDown extends Command {

    private final IntakeBola intakeBola;
    double tolerancia = 0.0;

    public IntakeBolaDown(IntakeBola intakeBola){
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Descendo intake para coleta");
    }
    
    @Override
    public void execute(){
        intakeBola.setReferencia(IntakeBolaConstants.setpoints.INTAKE_POSITION);
        tolerancia = IntakeBolaConstants.setpoints.INTAKE_POSITION - intakeBola.encoder_bola.getPosition();
    }

    @Override
    public boolean isFinished(){
        if (intakeBola.encoder_bola.getPosition() >= tolerancia) {
            return true;
        }else{
            return false;
        }
    }

}
