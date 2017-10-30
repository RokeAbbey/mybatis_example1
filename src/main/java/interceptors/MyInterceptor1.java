package interceptors;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts(@Signature(type=Executor.class, method="query",
        args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class MyInterceptor1 implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 本方法是在Plugin.wrap的代理中被调用的
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
//        return null; //拦截器的方法里必须返回一个executor的实例(从源码获知, 返回值是有这样的要求的, 因为就是用这个返回值来进行增删改查等行为的, 当然相应的代理对象也是可以的)
        /*
        Plugin.wrap 方法是用jdk代理, 将target封装一层,(传入的target就是上一个拦截器返回的结果), 所以此处用wrap方法就是用系统的默认实现将target进行一层封装
        然后成为一个洋葱一样的(假设每个拦截器都用Plugin.wrap封装一层), 然后在执行executor的query方法的时候就会一层一层调用intercept方法(每一层都先调用自己的intercept,
        然后由于在intercept中调用了proceed方法, 所以由于执行内层的代理对象的intercept方法, 就会形成调用链, 最后调用真正的executor的query方法)
         */
        /*
        * 如果不懂的话就看看Plugin.wrap的实现, 一下就会懂的
        * plugin默认最好返回Plugin.wrap的结果,不然是不会调用intercept方法的, 因为intercept是在target被代理的时候调用的.
        * 当然自己模仿plugin写一个代理也可以, 不过这样很累
        * */
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties.getProperty("prop1"));
    }
}
