package frc.robot.commands.cBoia;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.boia.IntakeBoia;

public class IntakeBoiaScorePosition extends Command {

    private final IntakeBoia intakeBoia;
    double tolerancia = 0.0;

    public IntakeBoiaScorePosition(IntakeBoia intakeBoia) {
        this.intakeBoia = intakeBoia;
        addRequirements(intakeBoia);
    }

    @Override
    public void initialize() {
        System.out.println("Posição para pontuar");
    }

    @Override
    public void execute() {
        intakeBoia.setScorePosition();
    }

    @Override
    public boolean isFinished() {
        if (intakeBoia.encoderIntakeBoiaRot1.getPosition() >= tolerancia) {
            return true;
        }else{
            return false;
        }
    }
}