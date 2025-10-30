package frc.robot.joysticks;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class KeyboardController {
    private final NetworkTable table;

    public KeyboardController(){
        // Conecta a mesma table do KeyboardListener
        table = NetworkTableInstance.getDefault().getTable("OperatorController");
    }

    // Função para ler tecla vinda da NetworkTable
    private Trigger createTrigger(String key){
        return new Trigger(() -> table.getEntry(key).getBoolean(false));
    }

    // Criando triggers para utlizar no RobotContainer
    public Trigger getCTrigger(){
        return createTrigger("c");
    }

    public Trigger getXTrigger(){
        return createTrigger("x");
    }

    public Trigger getMTrigger(){
        return createTrigger("m");
    }

    public Trigger getNTrigger(){
        return createTrigger("n");
    }

    public Trigger getBTrigger(){
        return createTrigger("b");
    }
}
