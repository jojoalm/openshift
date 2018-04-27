/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author josia
 */

@Path("/upload")
public class ServiceJAXRS  extends HttpServlet{
    @POST
    @Path("file")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.MULTIPART_FORM_DATA})
    public Response uploadFile (
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception {
        
         String UPLOAD_PATH = "OPENSHIFT_DATA_DIR";
        try {
            int read = 0;
            byte[] bytes = new byte[1024];
            File file = new File(UPLOAD_PATH+fileMetaData.getFileName());
            System.out.println("Upload File Path : "+file.getAbsolutePath());
            OutputStream out = new FileOutputStream(file);
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new WebApplicationException("Error while uploading file. Please try again !!");
        }
        return Response.ok("Data uploaded successfully !!").build();
    }
}
