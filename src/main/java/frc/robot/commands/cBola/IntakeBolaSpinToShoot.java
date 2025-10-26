package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.IntakeBolaConstants;
import frc.robot.subsystems.bola.IntakeBola;

public class IntakeBolaSpinToShoot extends Command{
        private final IntakeBola intakeBola;
        private final double duration = 5;
        private final Timer timer = new Timer();

    public IntakeBolaSpinToShoot(IntakeBola intakeBola){
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize(){
        System.out.println("Ligando rodinhas");
        timer.reset();
        timer.start();
    }
    
    @Override
    public void execute(){
        IntakeBola.motorColeta.set(IntakeBolaConstants.speed.SPEED_SHOOT);
    }

    @Override
    public void end(boolean interrupted){
        intakeBola.motorColeta.disable();
    }

    @Override
    public boolean isFinished(){
        if(timer.get() >= duration){
            return true;
        } else {
            return false;
        }
    }
}
