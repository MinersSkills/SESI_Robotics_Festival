package frc.robot.constants;

public class IntakeBoiaConstants {
    public static final int ID_MOTOR_ARTICULACAO = 19;
    public static final int ID_MOTOR_RODAS = 4;

    public static final int PORTA_SENSOR = 2;

    public class setpoints{
        public static final double INTAKE_POSITION = 27.8;
        public static final double SCORE_POSITION = 6.5;
        public static final double DEFAULT_POSITION = 0.5;
    }

    public class speed{
        public static final double  SPEED_INTAKE = 0.4;
        public static final double SPEED_SHOOT = -1;
    }

    public class PID{
        public static final double P = 0.031;
    }
}
