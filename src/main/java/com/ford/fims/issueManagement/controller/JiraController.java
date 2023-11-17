package com.ford.fims.issueManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.fims.issueManagement.service.JiraService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/jira")
//@Api("JIRA Controller for FIMS")
public class JiraController {
	
	  @Autowired
	  private JiraService jiraService;
	  
		@Value("${jira.projectKey}")
		private String projectKey;
		
		@Value("${jira.issueType}")
		private Long issueType;
		
		@Value("${jira.issueSummary}")
		private String issueSummary;


	    @PostMapping(value = "/create-ticket", consumes = {MediaType.ALL_VALUE})
	    @ApiOperation(value = "To Create ticket in JIRA", notes = "To load data to JIRA")
	    public ResponseEntity<String> triggerCupidStageBatch() {

	        try {
	        	String result = jiraService.createIssue(projectKey, issueType, issueSummary);
	            if (StringUtils.hasText(result)) {
	                return ResponseEntity.ok("ADDING TICKET To JIRA PROCESS IS COMPLETED!");
	            } else {
	                return ResponseEntity.ok("ADDING TICKET To JIRA PROCESS IS NOT COMPLETED!");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(e.toString());
	        }
	    }
	
	

}
