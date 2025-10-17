package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.bola.IntakeBola;

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
        IntakeBola.motorColeta.set(speed);
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
