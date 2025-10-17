package frc.robot.subsystems.boia;
// package frc.robot.subsystems;

// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.SparkBase.ControlType;
// import com.revrobotics.spark.SparkBase.PersistMode;

// import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// public class IntakeBoia extends ExampleSubsystem {
//     // Controle
//     XboxController copillotController = new XboxController(1);

//     // SparkMax e Encoder

//     // SparkRot 1
//     public static SparkMax motorIntakeBoiaRot1 = new SparkMax(30, MotorType.kBrushless);
//     public RelativeEncoder encoderIntakeBoiaRot1;

//     // SparkRot 2
//     public static SparkMax motorIntakeBoiaRot2 = new SparkMax(31, MotorType.kBrushless);
//     public RelativeEncoder encoderIntakeBoiaRot2;

//     // Spark rodinhas
//     public static SparkMax motorIntakeBoiaColeta = new SparkMax(32, MotorType.kBrushless);

//     // Variavel de configuração SparkMax
//     private SparkMaxConfig motorIntakeBoiaRot_Conf;
//     private SparkMaxConfig motorIntakeBoiaRot2_Conf;
//     private SparkMaxConfig motorIntakeBoiaColeta_Conf;

//     public IntakeBoia() {

//         // Motores de rotação
//         motorIntakeBoiaRot_Conf = new SparkMaxConfig();
//         motorIntakeBoiaRot_Conf.encoder.positionConversionFactor(1);
//         motorIntakeBoiaRot_Conf.idleMode(IdleMode.kBrake);
//         motorIntakeBoiaRot_Conf.inverted(false);

//         motorIntakeBoiaRot1.configure(motorIntakeBoiaRot_Conf, null, PersistMode.kNoPersistParameters);

//         motorIntakeBoiaRot2_Conf = new SparkMaxConfig();
//         motorIntakeBoiaRot2_Conf.encoder.positionConversionFactor(1);
//         motorIntakeBoiaRot2_Conf.idleMode(IdleMode.kBrake);
//         motorIntakeBoiaRot2_Conf.inverted(true); // Um dos motores serão invertidos, pois serão dois motores para articular o mesmo mecanismo

//         motorIntakeBoiaRot2.configure(motorIntakeBoiaRot2_Conf, null, PersistMode.kNoPersistParameters);

//         // Motor das rodinhas
//         motorIntakeBoiaColeta_Conf = new SparkMaxConfig();
//         motorIntakeBoiaColeta_Conf.idleMode(IdleMode.kBrake);

//         motorIntakeBoiaColeta.configure(motorIntakeBoiaColeta_Conf, null, PersistMode.kNoPersistParameters);

//         // Pegando valor do encoder
//         encoderIntakeBoiaRot1 = motorIntakeBoiaRot1.getEncoder();
//     }

//     public void setReferencia(double setpoint) {

//         if (setpoint > 0.5) {
//             motorIntakeBoiaRot_Conf.closedLoop.p(0.005);
//             motorIntakeBoiaRot2_Conf.closedLoop.p(0.005);

//             motorIntakeBoiaRot1.configure(motorIntakeBoiaRot_Conf, null, PersistMode.kNoPersistParameters);
//             motorIntakeBoiaRot2.configure(motorIntakeBoiaRot_Conf, null, PersistMode.kNoPersistParameters);

//             motorIntakeBoiaRot1.getClosedLoopController().setReference(setpoint, ControlType.kPosition);
//             motorIntakeBoiaRot2.getClosedLoopController().setReference(setpoint, ControlType.kPosition);

//         } else {
//             motorIntakeBoiaRot_Conf.closedLoop.p(0.01);
//             motorIntakeBoiaRot2_Conf.closedLoop.p(0.01);

//             motorIntakeBoiaRot1.configure(motorIntakeBoiaRot_Conf, null, PersistMode.kNoPersistParameters);
//             motorIntakeBoiaRot2.configure(motorIntakeBoiaRot_Conf, null, PersistMode.kNoPersistParameters);

//             motorIntakeBoiaRot1.getClosedLoopController().setReference(setpoint, ControlType.kPosition);
//             motorIntakeBoiaRot2.getClosedLoopController().setReference(setpoint, ControlType.kPosition);
//         }
//     }

//     public void intakeBoia(){
//         // Articulação
//         if (copillotController.getAButton()){
//             setReferencia(5);
//                 // Adicionar logica do sensor para parar coleta
//         } else if(copillotController.getXButton()){
//             setReferencia(1);
//         }

//         // Rodinhas coleta
//         if (copillotController.getRightBumperButton()){
//             motorIntakeBoiaColeta.set(1);
//         } else if(copillotController.getLeftBumperButton()){
//             motorIntakeBoiaColeta.set(-1);
//         } else {
//             motorIntakeBoiaColeta.disable();
//         }
//     }

//         public void dashboard() {
//         SmartDashboard.putNumber("Posicao Atual motor intakeBoia: ", encoderIntakeBoiaRot1.getPosition());
//     }
// }