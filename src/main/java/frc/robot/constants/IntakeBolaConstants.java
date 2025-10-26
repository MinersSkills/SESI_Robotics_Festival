package frc.robot.constants;

public class IntakeBolaConstants {

    public static final int ID_MOTOR_ARTICULACAO = 2;
    public static final int ID_MOTOR_RODAS = 16;

    public static final int PORTA_SENSOR = 1;

    public class setpoints{
        public static final double  INTAKE_POSITION = 7;
        public static final double SHOOT_POSITION = 1;
        public static final double TOLERANCE = 0.5;
    }

    public class speed{
        public static final double SPEED_INTAKE = 0.4;
        public static final double SPEED_SHOOT = -0.7;
    }

    public class PID{
        public static final double P_GO = 0.8;
        public static final double P_BACK = 0.05;
    }
}
