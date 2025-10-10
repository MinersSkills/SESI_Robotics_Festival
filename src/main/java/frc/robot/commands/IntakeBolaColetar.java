package frc.robot.commands;

import frc.robot.subsystems.IntakeBola;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeBolaColetar extends Command {

    private final IntakeBola intakeBola;
    private final double setpoint;

    public IntakeBolaColetar(IntakeBola intakeBola, double setpoint){
        this.intakeBola = intakeBola;
        this.setpoint = setpoint;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Descendo intake para coleta");
    }
    
    @Override
    public void execute(){
        intakeBola.setReferencia(setpoint);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
