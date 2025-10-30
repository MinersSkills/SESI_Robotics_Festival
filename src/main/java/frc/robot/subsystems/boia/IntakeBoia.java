package frc.robot.subsystems.boia;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.constants.IntakeBoiaConstants;
import frc.robot.subsystems.ExampleSubsystem;

public class IntakeBoia extends ExampleSubsystem {
    // Controle
    XboxController driveController = new XboxController(0);

    public DigitalInput sensor = new DigitalInput(IntakeBoiaConstants.PORTA_SENSOR);

    // SparkMax e Encoder

    // SparkRot 1
    public static SparkMax motorIntakeBoiaRot1 = new SparkMax(IntakeBoiaConstants.ID_MOTOR_ARTICULACAO, MotorType.kBrushless);
    public RelativeEncoder encoderIntakeBoiaRot1;
    public static SparkMax motorIntakeBoiaColeta = new SparkMax(IntakeBoiaConstants.ID_MOTOR_RODAS, MotorType.kBrushless);

    private SparkMaxConfig motorIntakeBoiaRot_Conf;
    private SparkMaxConfig motorIntakeBoiaColeta_Conf;

    public IntakeBoia() {

        // Motores de rotação
        motorIntakeBoiaRot_Conf = new SparkMaxConfig();
        motorIntakeBoiaRot_Conf.encoder.positionConversionFactor(1);
        motorIntakeBoiaRot_Conf.idleMode(IdleMode.kBrake);
        motorIntakeBoiaRot_Conf.inverted(false);

        motorIntakeBoiaRot1.configure(motorIntakeBoiaRot_Conf, null, PersistMode.kNoPersistParameters);

        // Motor das rodinhas
        motorIntakeBoiaColeta_Conf = new SparkMaxConfig();
        motorIntakeBoiaColeta_Conf.idleMode(IdleMode.kBrake);

        motorIntakeBoiaColeta.configure(motorIntakeBoiaColeta_Conf, null, PersistMode.kNoPersistParameters);

        // Pegando valor do encoder
        encoderIntakeBoiaRot1 = motorIntakeBoiaRot1.getEncoder();
        // encoderIntakeBoiaRot1.setPosition(0);
    }

    public void setReferencia(double setpoint) {
            motorIntakeBoiaRot_Conf.closedLoop.p(IntakeBoiaConstants.PID.P);
            motorIntakeBoiaRot1.configure(motorIntakeBoiaRot_Conf, null, PersistMode.kNoPersistParameters);
            motorIntakeBoiaRot1.getClosedLoopController().setReference(setpoint, ControlType.kPosition);
    }

    public void setIntakePosition(){
        setReferencia(IntakeBoiaConstants.setpoints.INTAKE_POSITION);
    }

    public void setScorePosition(){
        setReferencia(IntakeBoiaConstants.setpoints.SCORE_POSITION);
    }

    public void setDefaultPosition(){
        setReferencia(IntakeBoiaConstants.setpoints.DEFAULT_POSITION);
    }

    public void setWheelShootSpeed(){
        motorIntakeBoiaColeta.set(IntakeBoiaConstants.speed.SPEED_SHOOT);
    }
    
    public void setWheelIntakeSpeed(){
        motorIntakeBoiaColeta.set(IntakeBoiaConstants.speed.SPEED_INTAKE);
    }

    public void intakeBoia() {

        int pov = driveController.getPOV();

        // Articulação
        if (pov == 90) {
            setIntakePosition();
        } else if(pov == 270){
            setDefaultPosition();
        }

        // Rodinhas coleta
        // if (copillotController.getRightBumperButton()) {
        //     setWheelIntakeSpeed();
        // } else if (copillotController.getLeftBumperButton()) {
        //     setWheelShootSpeed();
        // } else {
        //     motorIntakeBoiaColeta.disable();
        // }
    }

    public void dashboard() {
        SmartDashboard.putNumber("Posicao Atual motor intakeBoia: ", encoderIntakeBoiaRot1.getPosition());
    }

    public boolean ativado(){
        System.out.println(!sensor.get());
        return !sensor.get();
    }
}