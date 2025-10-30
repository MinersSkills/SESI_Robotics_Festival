// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.cBoia.IntakeBoiaDown;
import frc.robot.commands.cBoia.IntakeBoiaLeftTrigger;
import frc.robot.commands.cBoia.IntakeBoiaOff;
import frc.robot.commands.cBoia.IntakeBoiaRightTrigger;
import frc.robot.commands.cBoia.IntakeBoiaScorePosition;
import frc.robot.commands.cBoia.IntakeBoiaSpinToIntake;
import frc.robot.commands.cBoia.IntakeBoiaSpinToShoot;
import frc.robot.commands.cBoia.IntakeBoiaUp;
import frc.robot.commands.cBola.IntakeBolaDown;
import frc.robot.commands.cBola.IntakeBolaSpinToIntake;
import frc.robot.commands.cBola.IntakeBolaSpinToShoot;
import frc.robot.commands.cBola.IntakeBolaOff;
import frc.robot.commands.cBola.IntakeBolaUP;
import frc.robot.commands.cDrive.DriveBack;
import frc.robot.commands.cDrive.DriveForward;
import frc.robot.commands.cDrive.DriveLeft;
import frc.robot.joysticks.KeyboardController;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.boia.IntakeBoia;
import frc.robot.subsystems.bola.IntakeBola;
import frc.robot.subsystems.drive.Drive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final KeyboardController keyboardOperator = new KeyboardController();
  private Drive drive = new Drive();
  public IntakeBola intakeBola = new IntakeBola();
  public IntakeBoia intakeBoia = new IntakeBoia();
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  // Chamar funcoes do robo
  public void chamarFuncoes() {
    drive.drive();
    intakeBola.intakeBola();
    intakeBoia.intakeBoia();
    intakeBola.ativado();
    intakeBoia.ativado();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // COLOCAR AQUI OS COMANDOS PARALELOS!
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    keyboardOperator.getCTrigger().onTrue(
        Commands.runOnce(() -> System.out.println("Tecla C detectada via NetworkTables!")));

    keyboardOperator.getCTrigger().onTrue(
        Commands.sequence(
            new IntakeBolaDown(intakeBola),
            new IntakeBolaSpinToIntake(intakeBola),
            new IntakeBolaUP(intakeBola)));

    keyboardOperator.getXTrigger().onTrue(new IntakeBolaOff(intakeBola));

    m_driverController.y().onTrue(
        Commands.sequence(
            new IntakeBolaDown(intakeBola),
            new IntakeBolaSpinToIntake(intakeBola),
            new IntakeBolaUP(intakeBola)));

    keyboardOperator.getMTrigger().onTrue( // coleta
        Commands.sequence(
            new IntakeBoiaDown(intakeBoia),
            new IntakeBoiaSpinToIntake(intakeBoia),
            new IntakeBoiaUp(intakeBoia)));

    m_driverController.a().onTrue( // coleta
        Commands.sequence(
            new IntakeBoiaDown(intakeBoia),
            new IntakeBoiaSpinToIntake(intakeBoia),
            new IntakeBoiaUp(intakeBoia)));

    m_driverController.x().onTrue( // pontuar
        Commands.sequence(
            new IntakeBoiaScorePosition(intakeBoia),
            new IntakeBoiaSpinToShoot(intakeBoia),
            new IntakeBoiaOff(intakeBoia)));
    
    m_driverController.leftTrigger().onTrue(
      Commands.sequence(
        new IntakeBoiaLeftTrigger(intakeBoia)
      )
    );

    m_driverController.rightTrigger().onTrue(
      Commands.sequence(
        new IntakeBoiaRightTrigger(intakeBoia)
      )
    );

    m_driverController.start().onTrue(new IntakeBoiaOff(intakeBoia)); // parar tudo

    m_driverController.b().onTrue(new IntakeBolaOff(intakeBola));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Commands.sequence(
        new DriveBack(drive, 0.35, 1.1),
        new IntakeBolaDown(intakeBola),
        new IntakeBolaSpinToIntake(intakeBola),
        new IntakeBolaUP(intakeBola),
        new DriveForward(drive, 0.45, 1.45),
        new WaitCommand(0.6),
        new DriveLeft(drive, 0.45, 0.85),
        new WaitCommand(0.5),
        new DriveBack(drive, 0.45, 1.7),
        new WaitCommand(0.5),
        new IntakeBolaSpinToShoot(intakeBola));
  }
}