package typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@MappedJdbcTypes(JdbcType.VARCHAR)
public class ExampleTypeHandler extends BaseTypeHandler<List> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("i = " + i + ", parameter = " + parameter + ", parameter.class = " + parameter.getClass());
        ps.setString(i, "abcdefghi");
    }

    @Override
    public List getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("columnName = " + columnName);
        String listStr = rs.getString(columnName);
        return str2list(listStr);
    }

    private List<String> str2list(String listStr){

        listStr = listStr.replaceAll("\\[|\\]", "");
        List<String> list =  new ArrayList();/*rs.getString(columnName);*/
        for(String s : listStr.split(","))
            list.add(s);
        return list;
    }
    @Override
    public List getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        System.out.println("columnName = " + columnIndex);
        String listStr = rs.getString(columnIndex);
        return str2list(listStr);
    }

    @Override
    public List getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        System.out.println("columnName = " + columnIndex);
        return new ArrayList();//cs.getString(columnIndex);
    }
}
