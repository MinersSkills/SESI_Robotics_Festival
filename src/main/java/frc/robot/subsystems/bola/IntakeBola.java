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
import frc.robot.constants.IntakeBolaConstants;

public class IntakeBola extends ExampleSubsystem {

    // Controle
    XboxController driveController = new XboxController(0);

    // Sensor para coleta
    public DigitalInput sensor = new DigitalInput(IntakeBolaConstants.PORTA_SENSOR);

    // SparkMax e Enconder
    public static SparkMax motorIntakeBola = new SparkMax(IntakeBolaConstants.ID_MOTOR_ARTICULACAO, MotorType.kBrushless);
    public static SparkMax motorColeta = new SparkMax(IntakeBolaConstants.ID_MOTOR_RODAS, MotorType.kBrushless);
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

        if (setpoint > IntakeBolaConstants.setpoints.TOLERANCE) {
            motor_intakeBConf.closedLoop.p(IntakeBolaConstants.PID.P_BACK);
            motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);
            motorIntakeBola.getClosedLoopController().setReference(setpoint, ControlType.kPosition);

        } else {
            motor_intakeBConf.closedLoop.p(IntakeBolaConstants.PID.P_GO);
            motorIntakeBola.configure(motor_intakeBConf, null, PersistMode.kNoPersistParameters);
            motorIntakeBola.getClosedLoopController().setReference(setpoint, ControlType.kPosition);
        }
    }

    public void setIntakePosition(){
        setReferencia(IntakeBolaConstants.setpoints.INTAKE_POSITION);
    }

    public void setShootPosition(){
        setReferencia(IntakeBolaConstants.setpoints.SHOOT_POSITION);
    }

    public void setWheelsIntake(){
        motorColeta.set(IntakeBolaConstants.speed.SPEED_INTAKE);
    }

    public void setWheelsShoot(){
        motorColeta.set(IntakeBolaConstants.speed.SPEED_SHOOT);
    }

    public void intakeBola() {

        int pov = driveController.getPOV();

        // Articulação
        if (pov == 0) {
            setIntakePosition();
        } else if (pov == 180) {
            setShootPosition();
        } 
        
        // Rodinhas coleta
        if (driveController.getRightBumperButton()){
            setWheelsIntake();
        } else if(driveController.getLeftBumperButton()){
            setWheelsShoot();
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