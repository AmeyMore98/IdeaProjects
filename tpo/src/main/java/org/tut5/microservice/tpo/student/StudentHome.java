package org.tut5.microservice.tpo.student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;

@Path("/student")
public class StudentHome {

	@GET
	@Produces({MediaType.TEXT_HTML})
	public InputStream getStudentHome() throws FileNotFoundException {
		File f = new File("C:\\Users\\Amay\\IdeaProjects\\tpo\\src\\main\\webapp\\StudentHome.html");
		return new FileInputStream(f);
	}
}
