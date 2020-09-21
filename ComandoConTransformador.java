#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import com.fasterxml.jackson.databind.JsonNode;
import com.qiip.base.dominio.comandos.Comando;
import com.qiip.base.dominio.comandos.Consecuencia;
import com.qiip.base.dominio.respuestas.Error;
import com.qiip.base.dominio.respuestas.ErrorDominio;
import com.qiip.base.infraestructura.acl.DTO;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import io.vavr.control.Either;
import play.Logger;
import play.libs.Json;

import static com.qiip.base.controladores.Transformador.transformar;

public class ${NAME} implements Comando {
    private final Logger.ALogger logger = Logger.of(this.getClass());

    @Override
    public Future<Consecuencia> ejecutar(JsonNode json) {
        logger.info("Inicio ${NAME} " + json);

        return transformar(json, ${DTO}.class).fold(
          error -> Future.successful(obtenerConcecuenciaFallida(new ErrorDominio("Json invalido", error), json)),
          dto -> execute(dto, json));
    }
    
    private Future<Consecuencia> execute(${DTO} dto, JsonNode json) {
        return Future.successful(
          obtenerConcecuenciaFallida(new ErrorDominio("No definido", List.empty()), json));
    }

    private Consecuencia obtenerConcecuenciaFallida(Error error, JsonNode json) {
        logger.error("Error ${NAME}: " + Json.toJson(error));
        return new Consecuencia(Either.left(error), List.empty());
    }

    private Consecuencia obtenerConcecuenciaExitosa(DTO dto) {
        logger.info("${NAME} exitoso: ");
        return new Consecuencia(Either.right(dto), List.empty());
    }
}
