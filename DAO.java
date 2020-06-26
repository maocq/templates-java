#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(${NAME}RecordMapper.class)
public interface ${NAME}DAO {

	@SqlQuery("INSERT INTO xxx RETURNING *")
    ${NAME}Record insertar(@BindBean("r") ${NAME}Record record);

    @SqlQuery("SELECT * FROM xxx WHERE id = :id and estado = 'ACTIVO'")
    ${NAME}Record buscarPorId(@Bind("id") Integer id);
}
