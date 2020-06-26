#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import io.vavr.concurrent.Future;
import io.vavr.control.Option;
import org.skife.jdbi.v2.DBI;
import play.db.Database;

import javax.inject.Inject;

public class ${NAME}Repositorio {

    private Database db;

    @Inject
    public ${NAME}Repositorio(Database db) {
        this.db = db;
    }

    public Future<Option<${NAME}>> buscarPorId(String idUsuario) {
        return Future.of(() ->
          Option.of(new DBI(db.getDataSource()).onDemand(${NAME}DAO.class).buscarPorId(idUsuario))
            .map(${NAME}Adaptador::transformar));
    }

    public Future<${NAME}> insertar(${NAME} entidad) {
        return Future.of(() -> ${NAME}Adaptador.transformar(new DBI(db.getDataSource())
          .onDemand(${NAME}DAO.class).insertar(${NAME}Adaptador.transformar(entidad))));
    }    
}
