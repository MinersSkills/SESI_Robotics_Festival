package frc.robot.commands.cBoia;
// package frc.robot.commands;

// import frc.robot.subsystems.IntakeBoia;
// import edu.wpi.first.wpilibj2.command.Command;

// public class IntakeBoiaDown extends Command {

//     private final IntakeBoia intakeBoia;
//     private final double setpoint;

//     public IntakeBoiaDown(IntakeBoia intakeBoia, double setpoint){
//         this.intakeBoia = intakeBoia;
//         this.setpoint = setpoint;
//         addRequirements(intakeBoia);
//     // }

//     @Override
//     public void initialize(){
//         System.out.println("Descendo intake para coleta (boia)");
//     }
    
//     @Override
//     public void execute(){
//         intakeBoia.setReferencia(setpoint);
//     }

//     @Override
//     public boolean isFinished(){
//         return false;
//     }
// }