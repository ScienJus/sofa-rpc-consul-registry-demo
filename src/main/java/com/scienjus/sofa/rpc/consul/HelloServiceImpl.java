package com.scienjus.sofa.rpc.consul;

import com.alipay.sofa.rpc.registry.consul.ConsulConstants;
import com.alipay.sofa.runtime.api.annotation.SofaParameter;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Service;

@Service
@SofaService(
        bindings = @SofaServiceBinding(
                bindingType = "bolt",
                parameters = @SofaParameter(key = ConsulConstants.CONSUL_SERVICE_NAME_KEY, value = "${spring.application.name}-hello-service")
        )
)
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String string) {
        return "Say: " + string;
    }
}
