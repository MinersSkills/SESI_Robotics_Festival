package frc.robot.commands;

import frc.robot.subsystems.IntakeBola;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeBolaGirar extends Command {

    private final IntakeBola intakeBola;
    private final double speed;

    public IntakeBolaGirar(IntakeBola intakeBola, double speed){
        this.intakeBola = intakeBola;
        this.speed = speed;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Ligando rodinhas");
    }
    
    @Override
    public void execute(){
        intakeBola.motorColeta.set(speed);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
