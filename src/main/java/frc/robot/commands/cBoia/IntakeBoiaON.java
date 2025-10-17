package frc.robot.commands.cBoia;
// package frc.robot.commands;

// import frc.robot.subsystems.IntakeBoia;
// import edu.wpi.first.wpilibj2.command.Command;

// public class IntakeBoiaON extends Command {

//     private final IntakeBoia intakeBoia;
//     private final double speed;

//     public IntakeBoiaON(IntakeBoia intakeBoia, double speed){
//         this.intakeBoia = intakeBoia;
//         this.speed = speed;
//         addRequirements(intakeBoia);
//     }

//     @Override
//     public void initialize(){
//         System.out.println("Ligando rodinhas");
//     }
    
//     @Override
//     public void execute(){
//         intakeBoia.motorIntakeBoiaColeta.set(speed);
//     }

//     @Override
//     public boolean isFinished(){
//         return false;
//     }

// }