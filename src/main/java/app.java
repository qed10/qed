

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.concurrent.CountedCompleter;

import org.openstack4j.core.transport.Config;
//import org.openstack4j.model.identity.User;
import org.openstack4j.model.compute.ext.Migration;
import org.openstack4j.model.compute.ext.MigrationsFilter;
import org.openstack4j.model.storage.object.SwiftAccount;
import org.openstack4j.model.storage.object.SwiftContainer;
import org.openstack4j.model.storage.object.options.CreateUpdateContainerOptions;
import org.openstack4j.openstack.OSFactory;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.OSClient;

import javax.net.ssl.HttpsURLConnection;

/**
 * Hello world!
 *
 */
public abstract class app {

    public static void main(String[] args) throws Exception {

        // 开始认证
        Config config = Config.newConfig().withSSLVerificationDisabled();
        //rustAllHttpsCertificates();
        //HttpsURLConnection.setDefaultHostnameVerifier(HttpsURLConnection.getDefaultHostnameVerifier());
        System.out.println("开始认证：");
        OSClient os = OSFactory.builderV2().withConfig(config)
                .endpoint("http://172.16.0.3:5000/v2.0")
                .credentials("admin", "admin")
                .tenantName("admin")
                .authenticate();
        System.out.println("完成认证：" + os.toString());

        List<? extends Migration> migrations = os.compute().migrations().list();
        // I also added support for the filtering the service offers
    //    MigrationsFilter.create filter = MigrationsFilter.create().host(host).status(Migration.Status.MIGRATING);
    //    migrations = os.compute().migrations().list(filter);

        //          System.out.println("获取Swift账户：");
        SwiftAccount swiftAccount = os.objectStorage().account().get();
        System.out.println(swiftAccount);
        //  System.out.println("获取对象存储元数据信息：");
        //  Map<String, String> metadata = new HashMap<String, String>();
        //  boolean result = os.objectStorage().account().updateMetadata(metadata);
        //  System.out.println(result);

        //  System.out.println("获取容器信息：");
        //   List<? extends SwiftContainer> containers = os.objectStorage().containers().list();

        //   int containerCount = (int) swiftAccount.getContainerCount();

        //    for(int i=0; i<containerCount; i++){
        //        System.out.println(containers.get(i).getName()+containers.get(i).getTotalSize()+"\n");
        //    }

        //    System.out.println("新建容器：");
        //    os.objectStorage().containers().create("xhhuangContainer", CreateUpdateContainerOptions.create()
        //            .accessAnybodyRead()
        //     );
        // }

        //   private static void trustAllHttpsCertificates() throws Exception {
        //       javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        //       javax.net.ssl.TrustManager tm = new http.miTM();
        //      trustAllCerts[0] = tm;
        //       javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
        //               .getInstance("SSL");
        //       sc.init(null, trustAllCerts, null);
        //       javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
//                .getSocketFactory());


    }
}

