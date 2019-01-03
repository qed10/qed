import com.sun.deploy.net.HttpUtils;


import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.identity.EndpointURLResolver;
import org.openstack4j.api.types.Facing;
import org.openstack4j.core.transport.Config;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Image;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ServerCreate;
import org.openstack4j.model.compute.actions.LiveMigrateOptions;
import org.openstack4j.model.compute.ext.Migration;
import org.openstack4j.model.compute.ext.Migration.Status;
import org.openstack4j.model.compute.ext.MigrationsFilter;
import org.openstack4j.model.identity.URLResolverParams;
import org.openstack4j.model.identity.v3.User;
import org.openstack4j.model.*;
import org.openstack4j.model.storage.object.SwiftAccount;
import org.openstack4j.model.storage.object.SwiftContainer;
import org.openstack4j.openstack.OSFactory;

import java.util.List;

public class log {
    public static void main(String[] args) throws Exception {
        final EndpointURLResolver endpointUrlResolver = new EndpointURLResolver() {
            @Override
            public String findURLV2(URLResolverParams params) {
// TODO Auto-generated method stub
                return null;
            }

            @Override
            public String findURLV3(URLResolverParams params) {
                if (params.type.getServiceName().equals("keystone")) {
                    return "http://172.16.0.3:5000/v3";
                } else if (params.type.getServiceName().equals("glance")) {
                    return "http://172.16.0.3:9292";// 镜像服务，经openstack4j检验用的是v1版本
                } else if (params.type.getServiceName().equals("nova")) {
                    return "http://172.16.0.3:8774/v2.1/bd1a352719e84e40aca3417ea445d286";// compute计算相关
                } else if (params.type.getServiceName().equals("neutron")) {
                    return "http://172.16.0.3:9696";
                } else if (params.type.getServiceName().equals("cinder")) {
                    return "http://172.16.0.3/v1/bd1a352719e84e40aca3417ea445d286";// 块存储经openstack4j检验用的是v1版本
                } else {
                    return null;
                }
            }
        };
        System.out.println("开始认证：");
        String projectIdentifier = "bd1a352719e84e40aca3417ea445d286";
        Config config=Config.newConfig().withSSLVerificationDisabled();
        OSClient.OSClientV3 os = OSFactory.builderV3()
     //           .withConfig(config)
                .withConfig(Config.newConfig().withEndpointURLResolver(endpointUrlResolver))
                .endpoint("http://172.16.0.3:5000/v3")
                .credentials("admin", "admin",Identifier.byId("default"))
                .scopeToProject(Identifier.byId(projectIdentifier)).perspective(Facing.PUBLIC)
                .authenticate();
        System.out.println("认证成功" + os.getToken());

     //   List<? extends Flavor> flavors = os.compute().flavors().list(); for(Flavor flavor :flavors){ System.out.println(flavor); }
     //   System.out.println("认证成功" + os.identity());


        //   List<? extends Flavor> flavors = os.compute().flavors().list();
     //   String token = OSUtils.getAdminToken(); JSONObject images = HttpUtils.doGet("http://ip:端口号/v2/images",token);


     //   List<? extends User> users = os.identity().users().list();

     //   System.out.println(users);
        //   System.out.println(flavors);

     //   List<? extends Image> images=os.compute().images().list();
     //   System.out.println(images);

     //   List<? extends Migration> migrations = os.compute().migrations().list();
     //   System.out.println(migrations);
     //   String host="111";
     //   MigrationsFilter  filter = MigrationsFilter.create().host(host).status(Status.MIGRATING);
     //   migrations = os.compute().migrations().list(filter);
     //   System.out.println(migrations);


     //   ServerCreate sc = Builders.server().name("Ubuntu 2").flavor("flavorId").image("imageId").build();
     //   Server server = os.compute().servers().boot(sc);
        //虚拟机迁移
     //   ActionResponse response=os.compute().servers().liveMigrate("72d3c739-20cc-45b9-add4-e2cb38fael123", LiveMigrateOptions.create().host("node-14.domain.tld").blockMigration(true).diskOverCommit(false));
        //查看迁移记录
     //   List<? extends Migration> migrations = os.compute().migrations().list();
     //   System.out.println(migrations);

    }

}

