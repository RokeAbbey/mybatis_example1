package typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import roles.Spitter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpitterTypeHandler extends BaseTypeHandler<Object> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, ((Spitter)parameter).getUsername());
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        new Exception().printStackTrace();
        System.out.println("columnName = " + columnName);
//        System.out.println(rs.getClass().getName());
        return new Spitter().setUsername(rs.getString("username"));
//                .setPassword(rs.getString("password"))
//                .setFirstname(rs.getString("firstname"))
//                .setLastname(rs.getString("lastname"))
//                .setEmail(rs.getString("email"));
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        new Exception().printStackTrace();
        System.out.println("columnIndex = " + columnIndex);
        return new Spitter().setUsername(rs.getString(columnIndex));
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
