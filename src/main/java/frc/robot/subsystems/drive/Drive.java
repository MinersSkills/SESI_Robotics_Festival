package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.constants.DriveConstants;
import frc.robot.subsystems.ExampleSubsystem;


public class Drive extends ExampleSubsystem{

    // Controle
    XboxController driveController = new XboxController(0);

    // Motores drive train
    public WPI_VictorSPX frenteEsquerda;
    public WPI_VictorSPX trasEsquerda;

    public WPI_VictorSPX frenteDireita;
    public WPI_VictorSPX trasDireita;



    // Inicializando ID dos VictorSPX
    public Drive(){
        frenteEsquerda = new WPI_VictorSPX(DriveConstants.id.ID_VICTOR_FRENTE_ESQUERDA);
        frenteDireita = new WPI_VictorSPX(DriveConstants.id.ID_VICTOR_FRENTE_DIREITA);

        trasDireita = new WPI_VictorSPX(DriveConstants.id.ID_VICTOR_TRAS_DIREITA);
        trasEsquerda = new WPI_VictorSPX(DriveConstants.id.ID_VICTOR_TRAS_ESQUERDA);

        //Invertendo motores
        frenteDireita.setInverted(true);
        trasDireita.setInverted(true);
    }


    public void drive(){
        double velocidade = driveController.getRawAxis(DriveConstants.axis.DRIVE_AXIS); // Movimenta frente e tras
        double rotacao = driveController.getRawAxis(DriveConstants.axis.TURN_AXIS); // Movimenta para os lados

        double esquerda = velocidade + rotacao;
        double direita = velocidade - rotacao;

        // Faz os motores funcionar
        frenteEsquerda.set(ControlMode.PercentOutput,(esquerda));
        trasEsquerda.set(ControlMode.PercentOutput, (esquerda));

        frenteDireita.set(ControlMode.PercentOutput, (direita));
        trasDireita.set(ControlMode.PercentOutput, (direita));
    }
}