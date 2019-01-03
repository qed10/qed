import org.openstack4j.api.OSClient;
import org.openstack4j.api.types.Facing;
import org.openstack4j.core.transport.Config;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;

import java.util.List;

public class flavors {
    public static void main(String[] args) throws Exception {
        String projectIdentifier = "bd1a352719e84e40aca3417ea445d286";
        Config config=Config.newConfig().withSSLVerificationDisabled();
        OSClient.OSClientV3 os = OSFactory.builderV3()
                           .withConfig(config)
                .endpoint("http://172.16.0.3:5000/v3")
                .credentials("admin", "admin", Identifier.byId("default"))
                .scopeToProject(Identifier.byId(projectIdentifier)).perspective(Facing.PUBLIC)
                .authenticate();
        List<? extends Flavor> flavors = os.compute().flavors().list(); for(Flavor flavor :flavors){ System.out.println(flavor); }
    }
}
