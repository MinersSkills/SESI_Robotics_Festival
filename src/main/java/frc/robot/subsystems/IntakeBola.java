package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.XboxController;

public class IntakeBola extends ExampleSubsystem{

    // Controle
    XboxController driveController = new XboxController(0);

    // SparkMax e Enconder 
    public static SparkMax motorIntakeBola = new SparkMax(5, MotorType.kBrushless);
    public static SparkMax motorColeta = new SparkMax(2, MotorType.kBrushless);
    public RelativeEncoder encoder_bola;
    private SparkMaxConfig motor_intakeBConf;
    private SparkMaxConfig motorColetaConf;

    public IntakeBola(){
        // Configurando SparkMax Intake
        motor_intakeBConf = new SparkMaxConfig();
        motor_intakeBConf.encoder.positionConversionFactor(1);
        motor_intakeBConf.idleMode(IdleMode.kBrake);
        motor_intakeBConf.inverted(false);

        motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);

        // Configurando SparkMax coleta
        motorColetaConf = new SparkMaxConfig();
        motorColetaConf.idleMode(IdleMode.kBrake);

        motorColeta.configure(motorColetaConf, null, PersistMode.kNoPersistParameters);

        // Pegando valor do encoder
        encoder_bola = motorIntakeBola.getEncoder();
    }

    public void setReferencia(double setpoint){
        
        if (setpoint > 0.5){
            motor_intakeBConf.closedLoop.p(0.05);
            motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);
            motorIntakeBola.getClosedLoopController().setReference(setpoint, ControlType.kPosition);

        } else {
            motor_intakeBConf.closedLoop.p(0.5);
            motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);
            motorIntakeBola.getClosedLoopController().setReference(setpoint, ControlType.kPosition);
        }

    }

    public void intakeBola(){
        
        if(driveController.getAButtonPressed()){
            setReferencia(10);
            motorColeta.set(1);
                // Adicionar lógica do sensor para parar a coleta
        } else if(driveController.getXButtonPressed()){
            setReferencia(0.3);
            motorColeta.set(0);
        }
    }
}