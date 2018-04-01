package org.tut5.microservice.tpo.faculty;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;

@Path("/faculty")
public class FacultyHome {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public InputStream getFaultyHome() throws FileNotFoundException {
		File f = new File("C:\\Users\\Amay\\IdeaProjects\\tpo\\src\\main\\webapp\\TpoHome.html");
		return new FileInputStream(f);
	}
}