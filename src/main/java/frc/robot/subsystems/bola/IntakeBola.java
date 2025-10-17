package frc.robot.subsystems.bola;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ExampleSubsystem;

public class IntakeBola extends ExampleSubsystem {

    // Controle
    XboxController driveController = new XboxController(0);

    // Sensor para coleta
    public DigitalInput sensor = new DigitalInput(1);

    // SparkMax e Enconder
    public static SparkMax motorIntakeBola = new SparkMax(2, MotorType.kBrushless);
    public static SparkMax motorColeta = new SparkMax(16, MotorType.kBrushless);
    public RelativeEncoder encoder_bola;
    private SparkMaxConfig motor_intakeBConf;
    private SparkMaxConfig motorColetaConf;

    public IntakeBola() {
        // Configurando SparkMax Intake
        motor_intakeBConf = new SparkMaxConfig();
        motor_intakeBConf.encoder.positionConversionFactor(1);
        motor_intakeBConf.idleMode(IdleMode.kBrake);
        motor_intakeBConf.inverted(false);

        motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);

        // Configurando SparkMax coleta
        motorColetaConf = new SparkMaxConfig();
        motorColetaConf.idleMode(IdleMode.kBrake);
        motorColetaConf.inverted(true);

        motorColeta.configure(motorColetaConf, null, PersistMode.kNoPersistParameters);

        // Pegando valor do encoder
        encoder_bola = motorIntakeBola.getEncoder();
    }

    public void setReferencia(double setpoint) {

        if (setpoint > 0.5) {
            motor_intakeBConf.closedLoop.p(0.05); // talvez 0.09
            motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);
            motorIntakeBola.getClosedLoopController().setReference(setpoint, ControlType.kPosition);

        } else {
            motor_intakeBConf.closedLoop.p(0.8);
            motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);
            motorIntakeBola.getClosedLoopController().setReference(setpoint, ControlType.kPosition);
        }

    }

    public void intakeBola() {

        // Articulação
        if (driveController.getAButton()) {
            setReferencia(7.6);
        } else if (driveController.getXButton()) {
            setReferencia(1);
        } 

        // Rodinhas coleta
        if (driveController.getRightBumperButton()){
            motorColeta.set(0.7);
        } else if(driveController.getLeftBumperButton()){
            motorColeta.set(-0.7);
        } else {
            motorColeta.disable();
        }
    }

    public void dashboard() {
        SmartDashboard.putNumber("Posicao Atual motor intakeBola: ", encoder_bola.getPosition());
    }

    // sensor para coleta
    public boolean ativado(){
        return sensor.get();
    }
}