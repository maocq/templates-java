package infraestructura.procesadores.agregadorpagos;

import com.fasterxml.jackson.databind.JsonNode;
import com.lapso.eventos.Evento;
import com.lapso.eventos.ProcesadorEspecifico;
import com.qiip.base.dominio.respuestas.Error;
import com.qiip.base.dominio.respuestas.ErrorDominio;
import controladores.Transformador;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import play.Logger;
import play.libs.Json;

public class ${NAME} implements ProcesadorEspecifico, Transformador<${DTO}> {
    private final Logger.ALogger logger = Logger.of(this.getClass());


    @Override
    public String getNombreProcesador() {
        return "UsuarioAgregadorPagoRegistrado";
    }

    @Override
    public Future<List<Evento>> ejecutar(Evento evento) {
        logger.info("Inicio ${NAME}: " + Json.toJson(evento));

        return transformarJson(evento.getDatosAsJson(), ${DTO}.class).fold(
          error -> Future.successful(obtenerEventosDeFallo(new ErrorDominio("Error mensaje", error), evento.getDatosAsJson())),
          dto -> procesar(dto, evento.getDatosAsJson())
        );
    }

    private Future<List<Evento>> procesar(${DTO} mensaje, JsonNode json) {
        return Future.successful(obtenerEventosDeFallo(
          new ErrorDominio("No implementado", List.empty()), json));
    }

    private List<Evento> obtenerEventosDeFallo(Error error, JsonNode json) {
        logger.error("Error en ${NAME}: " + Json.toJson(error));
        return List.empty();
    }

    private List<Evento> obtenerEventosDeExito() {
        logger.info("${NAME} exitoso");
        return List.empty();
    }
}
