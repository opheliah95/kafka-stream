import java.util.Properties;

import static com.helper.github.opheliah95.MyConst.*;

public class SampleConsumer {

    public static void main(String[] args){
        Properties prop = new Properties();
        prop.put(SERVER, HOST);
        prop.put("group.id", GROUP_ID);
    }

}
