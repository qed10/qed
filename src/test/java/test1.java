import java.util.List;

import org.openstack4j.api.OSClient;
import org.openstack4j.api.types.Facing;
import org.openstack4j.core.transport.Config;
import org.openstack4j.openstack.OSFactory;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.identity.v3.User;

public class test1 extends log {
    public static void main(String[] args) {

        System.out.println("开始认证：");
        String projectIdentifier = "bd1a352719e84e40aca3417ea445d286";
        Config config=Config.newConfig().withSSLVerificationDisabled();
        OSClient.OSClientV3 os = OSFactory.builderV3()
                          .withConfig(config)
     //           .withConfig(Config.newConfig().withEndpointURLResolver(endpointUrlResolver))
                .endpoint("http://172.16.0.3:5000/v3")
                .credentials("admin", "admin",Identifier.byId("default"))
                .scopeToProject(Identifier.byId(projectIdentifier)).perspective(Facing.PUBLIC)
                .authenticate();
     //   System.out.println("认证成功" + os.getToken());
         List<? extends User> users = os.identity().users().list();
         System.out.println(users.size());

    //   List<? extends Project> projectList = os.identity().projects().list();
    //   System.out.println(projectList.size());

     //   List<? extends Flavor> flavors = os.compute().flavors().list();
     //   System.out.println(flavors.size());

   }
}