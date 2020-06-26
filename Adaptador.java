#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

public class ${NAME}Adaptador {

    public static ${NAME} transformar(${NAME}Record record) {
        return new ${NAME}(
          record.getId(),
          ...
          
          FechaAdaptador.obtenerFecha(record.getFechaCreacion()),
          FechaAdaptador.obtenerFecha(record.getFechaActualizacion())
        );
    }

    public static ${NAME}Record transformar(${NAME} entidad) {
        return new ${NAME}Record(
          entidad.getId(),
          ...
          
          FechaAdaptador.obtenerFecha(entidad.getFechaCreacion()),
          FechaAdaptador.obtenerFecha(entidad.getFechaActualizacion()));
    }
}