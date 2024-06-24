package com.system.RentalSystemSpringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConverterProperties {

    @Value("${jwt.converter.principal-attribute:sub}")
    private String principalAttribute;

    @Value("${jwt.converter.resource-id:springboot-app}")
    private String resourceId;

    public String getPrincipalAttribute() {
        return principalAttribute;
    }

    public void setPrincipalAttribute(String principalAttribute) {
        this.principalAttribute = principalAttribute;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
