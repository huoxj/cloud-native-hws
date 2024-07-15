package io.daocloud.adminservice.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RandomRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer lb = getLoadBalancer();
        if(lb == null) return null;

        List<Server> servers = lb.getReachableServers();
        // 如果没有可达服务器，返回空
        if(servers.isEmpty()) return null;
        // 返回随机服务器
        Server selected = servers.get((int)(Math.random() * 114514) % servers.size());
        System.out.println("[Ribbon Custom Rule]: selected server " + selected.getMetaInfo().getInstanceId());
        return selected;

    }


}
