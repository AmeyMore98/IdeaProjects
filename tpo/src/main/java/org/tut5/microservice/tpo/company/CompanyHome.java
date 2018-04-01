package org.tut5.microservice.tpo.company;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;

@Path("/company")
public class CompanyHome {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public InputStream getCompanyHome() throws FileNotFoundException {
		File f = new File("C:\\Users\\Amay\\IdeaProjects\\tpo\\src\\main\\webapp\\CompHome.html");
		return new FileInputStream(f);
	}
}
