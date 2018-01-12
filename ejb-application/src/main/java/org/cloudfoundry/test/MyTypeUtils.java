package org.cloudfoundry.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.annotation.Resource;

@Path("/my-type")
@Produces(MediaType.TEXT_PLAIN)
public class MyTypeUtils {

  @Resource(name= "someId")
  private MyType myType;

  @GET
  @Path("/check-my-type")
  public String checkMyType() {
    return myType.toString();
  }

}
