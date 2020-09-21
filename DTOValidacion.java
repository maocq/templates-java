#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import com.qiip.base.infraestructura.acl.dto.DTOValidacion;
import io.vavr.Value;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Validation;
import org.apache.commons.lang3.StringUtils;

public class ${NAME}DTO implements DTOValidacion<${NAME}DTO> {

    private Integer idUsuario;
    private String estado;
    
    public ${NAME}DTO() {
        //Json constructor
    }

    public ${NAME}DTO(Integer idUsuario, String estado) {
        this.idUsuario = idUsuario;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getEstado() {
        return estado;
    }
 
    public Either<List<String>, ${NAME}DTO> validar() {
        return Validation.combine(
          validarIdUsuario(),
          validarEstado()
        ).ap(${NAME}DTO::new).toEither().mapLeft(Value::toList);
    }

    private Validation<String, Integer> validarIdUsuario() {
        return idUsuario == null
          ? Validation.invalid("${NAME}.idUsuario")
          : Validation.valid(idUsuario);
    }

    private Validation<String, String> validarEstado() {
        return StringUtils.isBlank(estado)
          ? Validation.invalid("${NAME}.estado")
          : Validation.valid(estado);
    }
}
