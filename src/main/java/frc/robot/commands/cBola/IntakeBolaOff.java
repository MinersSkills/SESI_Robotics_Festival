package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.IntakeBolaConstants;
import frc.robot.subsystems.bola.IntakeBola;

public class IntakeBolaOff extends Command {

    private final IntakeBola intakeBola;

    public IntakeBolaOff(IntakeBola intakeBola) {
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize() {
        System.out.println("Parando coleta");
    }

    @Override
    public void execute() {
        intakeBola.setReferencia(IntakeBolaConstants.setpoints.SHOOT_POSITION);
        IntakeBola.motorColeta.disable();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}