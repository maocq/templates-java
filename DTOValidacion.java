#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import com.qiip.base.infraestructura.acl.dto.DTOValidacion;
import io.vavr.Value;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

import static com.qiip.base.controladores.Validador.*;

public class ${NAME}DTO implements DTOValidacion<${NAME}DTO> {

    private Integer idUsuario;
    private String estado;
    private Integer edad;
    
    public ${NAME}DTO() {
        //Json constructor
    }

    public ${NAME}DTO(Integer idUsuario, String estado, Integer edad) {
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.edad = edad;
    }
 
    public Either<List<String>, ${NAME}DTO> validar() {
        return Validation.combine(
          validarNoNull(idUsuario, "${NAME}.idUsuario"),
          validarTexto(estado, "${NAME}.estado"),
          validarCondicion(edad, n -> n > 18, "")
        ).ap(${NAME}DTO::new).toEither().mapLeft(Value::toList);
    }
}
