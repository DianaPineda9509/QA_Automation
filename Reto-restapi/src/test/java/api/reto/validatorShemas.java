package api.reto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import utils.JsonSchemaValidator;

public class validatorShemas {


    public static String validationSchemas(String response, String schemaJson) {

        String validationSchema =  JsonSchemaValidator.validateJsonAgainstSchema(response, schemaJson);
        assertEquals("", validationSchema, "Resultado de la validacion del schema");

        return  "Resultado de la validacion del Schema: " + validationSchema;
    }

    
}
