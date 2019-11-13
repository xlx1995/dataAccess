import com.xlx.service.Callback;
import com.xlx.service.Xfile;
import com.xlx.service.impl.XfileImpl;
import com.xlx.util.ReMessage;
import org.junit.Test;

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

}
