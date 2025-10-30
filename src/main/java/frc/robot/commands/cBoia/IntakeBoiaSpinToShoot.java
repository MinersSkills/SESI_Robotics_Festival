package frc.robot.commands.cBoia;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.IntakeBoiaConstants;
import frc.robot.subsystems.boia.IntakeBoia;

public class IntakeBoiaSpinToShoot extends Command {

    private final IntakeBoia intakeBoia;
    private double duration = 0.8;
    private final Timer timer = new Timer();

    public IntakeBoiaSpinToShoot(IntakeBoia intakeBoia){
        this.intakeBoia = intakeBoia;
        addRequirements(intakeBoia);
    }

    @Override
    public void initialize(){
        System.out.println("Ligando rodinhas para cuspir");
        timer.reset();
        timer.start();
    }
    
    @Override
    public void execute(){
        IntakeBoia.motorIntakeBoiaColeta.set(IntakeBoiaConstants.speed.SPEED_SHOOT);
    }

    @Override
    public void end(boolean interrupted){
        intakeBoia.motorIntakeBoiaColeta.disable();
    }

    @Override
    public boolean isFinished(){
        if(timer.get() >= duration){
            return true;
        } else{
            return false;
        }
    }

}
