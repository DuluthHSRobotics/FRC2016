#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}

import edu.wpi.first.wpilibj.command.Subsystem;

#end
#parse("File Header.java")
public class ${NAME} extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand();
    }
}