package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.XboxController;


public class Drive{

    // Controle
    XboxController driveController = new XboxController(0);

    // Motores drive train
    private WPI_VictorSPX frenteEsquerda;
    private WPI_VictorSPX trasEsquerda;

    private WPI_VictorSPX frenteDireita;
    private WPI_VictorSPX trasDireita;



    // Inicializando ID dos VictorSPX
    public Drive(){
        frenteEsquerda = new WPI_VictorSPX(3);
        frenteDireita = new WPI_VictorSPX(5);

        trasDireita = new WPI_VictorSPX(4);
        trasEsquerda = new WPI_VictorSPX(2);

        //Invertendo motores
        frenteDireita.setInverted(true);
        trasDireita.setInverted(true);
    }


    public void drive(){
        double velocidade = driveController.getRawAxis(1); // Movimenta frente e tras
        double rotacao = driveController.getRawAxis(4); // Movimenta para os lados

        double esquerda = velocidade + rotacao;
        double direita = velocidade - rotacao;

        // Faz os motores funcionar
        frenteEsquerda.set(ControlMode.PercentOutput,(esquerda));
        trasEsquerda.set(ControlMode.PercentOutput, (esquerda));

        frenteDireita.set(ControlMode.PercentOutput, (direita));
        trasDireita.set(ControlMode.PercentOutput, (direita));
    }
}