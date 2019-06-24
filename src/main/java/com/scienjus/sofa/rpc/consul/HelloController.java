package com.scienjus.sofa.rpc.consul;

import com.alipay.sofa.rpc.registry.consul.ConsulConstants;
import com.alipay.sofa.runtime.api.annotation.SofaParameter;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @SofaReference(
            binding = @SofaReferenceBinding(
                    bindingType = "bolt",
                    parameters = @SofaParameter(key = ConsulConstants.CONSUL_SERVICE_NAME_KEY, value = "${spring.application.name}-hello-service")
            ),
            jvmFirst = false
    )
    private HelloService helloService;

    @GetMapping("/say/{word}")
    public String hello(@PathVariable("word") String word) {
        return helloService.say(word);
    }
}
