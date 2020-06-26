#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ${NAME}RecordMapper implements ResultSetMapper<${NAME}Record> {

    @Override
    public ${NAME}Record map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new ${NAME}Record(
          r.getInt("id"),
          r.getString("nombre"),         
          r.getTimestamp("fecha_creacion"),
          r.getTimestamp("fecha_actualizacion"));
    }

}
