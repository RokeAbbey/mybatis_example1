package objectfactory;

import org.apache.ibatis.executor.BaseExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExampleObjectFactory extends DefaultObjectFactory{

    @Override
    public <T> T create(Class<T> type) {
        System.out.println("type = " + type);
//        new Exception().printStackTrace();
//        Object
//        SimpleExecutor


        return super.create(type);

    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        System.out.println("type = " + type + ", constructorArgTypes " + constructorArgTypes + ", args = " + constructorArgs);
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        return super.resolveInterface(type);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
