package frc.robot.commands.cBola;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.bola.IntakeBola;

public class IntakeBolaOff extends Command {

    private final IntakeBola intakeBola;
    private final double setpoint = 1;

    public IntakeBolaOff(IntakeBola intakeBola) {
        this.intakeBola = intakeBola;
        addRequirements(intakeBola);
    }

    @Override
    public void initialize() {
        System.out.println("Ligando rodinhas");
    }

    @Override
    public void execute() {
        intakeBola.setReferencia(setpoint);
        IntakeBola.motorColeta.disable();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}