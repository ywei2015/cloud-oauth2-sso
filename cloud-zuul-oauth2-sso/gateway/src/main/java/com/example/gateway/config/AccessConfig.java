package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AccessConfig {

	@Bean
	public AffirmativeBased accessDecisionManager() {
		List<AccessDecisionVoter<?>> accessDecisionVoters = new ArrayList<>();
		AuthenticatedVoter authenticatedVoter = new AuthenticatedVoter();
		RoleVoter roleVoter = new RoleVoter();
		accessDecisionVoters.add(authenticatedVoter);
		accessDecisionVoters.add(roleVoter);
		accessDecisionVoters.add(urlMatchVoter());
		return new AffirmativeBased(accessDecisionVoters);
	}

	@Bean
	public UrlMatchVoter urlMatchVoter() {
		return new UrlMatchVoter();
	}

	@Bean
	public UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource() {
		return new UrlFilterInvocationSecurityMetadataSource();
	}

}
