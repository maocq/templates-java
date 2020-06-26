#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import com.fasterxml.jackson.databind.JsonNode;
import com.lapso.eventos.Evento;
import com.qiip.base.dominio.respuestas.Error;
import play.libs.Json;

public class ${NAME} extends Evento {

    private Datos datos;

    public ${NAME}(Error error, JsonNode json) {
        this.datos = new Datos(error.getMensaje(), Json.toJson(error).toString(), json);
    }

    public Datos getDatos() {
        return datos;
    }

    public class Datos {
        private String mensaje;
        private String error;
        private JsonNode json;

        public Datos(String mensaje, String error, JsonNode json) {
            this.mensaje = mensaje;
            this.error = error;
            this.json = json;
        }

        public String getMensaje() {
            return mensaje;
        }

        public String getError() {
            return error;
        }

        public JsonNode getJson() {
            return json;
        }
    }
}
