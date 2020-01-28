import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.xlx.db.pojo.Role;
import com.xlx.service.Callback;
import com.xlx.service.Xfile;
import com.xlx.service.impl.XfileImpl;
import com.xlx.util.ProtobufUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xlx
 * @descritption
 * @data 2019/10/23
 */
public class TestAccess {

    public static void main(String[] args) {
        Xfile xfile = new XfileImpl();
        Callback callback = reMessage -> System.out.println(reMessage);
        xfile.testAsync(callback);
    }




    @Test
    public void t3() throws IOException {
        Role role = new Role();
        role.setId(1);
        role.setName("xlx");
        byte[] bytes = ProtobufUtil.proToByte(role);
        Role role1  = ProtobufUtil.byteToCls(bytes, Role.class);
        System.out.println(role1.toString());

    }

    @Test
    public void t2() throws IOException {
        Role role = new Role();
        role.setId(1);
        role.setName("xlx");
        Codec<Role> codec = ProtobufProxy.create(Role.class);
        byte[] bytes = codec.encode(role);
        Role decode = codec.decode(bytes);
        System.out.println(decode.toString());

    }

//    @Test
//    public void t1(){
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
////        StudentDo bean = ctx.getBean("student2",StudentDo.class);
//        BusinessPersoon bean = ctx.getBean(BusinessPersoon.class);
//        bean.use();
//
//    }

}
