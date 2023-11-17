package com.ford.fims.issueManagement.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

@Configuration
public class JiraConfiguration {
	
	@Value("${jira.siteURL}")
	private String jiraUrl;
	
	@Value("${jira.username}")
	private String username;
	
	@Value("${jira.password}")
	private String password;

	@Bean
	 public JiraRestClient getJiraRestClient() {
	        return new AsynchronousJiraRestClientFactory()
	          .createWithBasicHttpAuthentication(getJiraUri(), username, password);
	    }

	    private URI getJiraUri() {
	        return URI.create(jiraUrl);
	    }
}
