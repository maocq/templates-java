#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import com.fasterxml.jackson.databind.JsonNode;
import com.qiip.base.dominio.comandos.Comando;
import com.qiip.base.dominio.comandos.Consecuencia;
import com.qiip.base.dominio.respuestas.Error;
import com.qiip.base.dominio.respuestas.ErrorDominio;
import com.qiip.base.infraestructura.acl.DTO;
import controladores.Transformador;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import io.vavr.control.Either;
import play.Logger;
import play.libs.Json;

public class ${NAME} implements Comando, Transformador<${DTO}> {
    private final Logger.ALogger logger = Logger.of(this.getClass());

    @Override
    public Future<Consecuencia> ejecutar(JsonNode json) {

        return transformarJson(json, ${DTO}.class).fold(
          error -> Future.successful(obtenerConcecuenciaFallida(new ErrorDominio("Json invalido", error), json)),
          dto -> execute(dto, json));
    }
    
    private Future<Consecuencia> execute(${DTO} dto, JsonNode json) {
        return Future.successful(
          obtenerConcecuenciaFallida(new ErrorDominio("No definido", List.empty()), json));
    }

    private Consecuencia obtenerConcecuenciaFallida(Error error, JsonNode json) {
        logger.error("Error Algo: " + Json.toJson(error));
        return new Consecuencia(Either.left(error), List.empty());
    }

    private Consecuencia obtenerConcecuenciaExitosa(DTO dto) {
        logger.info("Algo exitoso: ");
        return new Consecuencia(Either.right(dto), List.empty());
    }
}
