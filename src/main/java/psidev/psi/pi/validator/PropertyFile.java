package psidev.psi.pi.validator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Class for reading a property file.
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */

public class PropertyFile {

    /**
     * Constants.
     */
    private final String STR_NOT_SPECIFIED  = "not specified";
    
    /**
     * Members.
     */
    private Properties props = null;
    
    /**
     * This method load the contents of a .properties file.
     * @param filepath path to the properties file
     * @return the loaded properties as Properties object
     */
    public Properties loadProperties(String filepath) {
        if (this.props == null) {
            this.props = new Properties();
        }
        try{

            InputStream inputStream;
            if(!(new File(filepath).exists())){
                inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("validation.properties");
            }else{
                inputStream = Files.newInputStream(Paths.get(filepath));
            }
            this.props.load(inputStream);

        } catch (IOException fnfexc) {
            fnfexc.printStackTrace(System.err);
        }

        return this.props;
    }

    /**
     * Reads a property from the property file.
     * @param propName the property name
     * @return value for the read property
     */
    public String readProperty(String propName) {
        String propStr = "";
        
        if (this.props != null) {
            propStr = this.props.getProperty(propName);
        }
        
        if (propStr.isEmpty()) {
            propStr = this.STR_NOT_SPECIFIED;
            System.err.printf("Property %s not specified.", propName);
        }
        
        return propStr;
    }
}
