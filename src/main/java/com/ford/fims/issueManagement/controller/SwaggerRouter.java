package com.ford.fims.issueManagement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@Api(value = "Swagger", hidden = true)
public class SwaggerRouter {

  @GetMapping("/")
  @ApiIgnore
  @ApiOperation(value = "Swagger Documentation",
      notes = "Redirects default uri to swagger documentation", hidden = true)
  public ModelAndView getApiInfo() {
	  return new ModelAndView("redirect:/swagger-ui/");
  }


}
