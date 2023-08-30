package DAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "HomeDAO", value = "/HomeDAO")
public class HomeDAO extends HttpServlet {
    private String message;


    public static void uploadSingleFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final int maxMemorySize = 1024 * 1024 * 3;
        final int maxRequestSize = 1024 * 1024 * 50;
        final String address = "D:\\";

        // Hello
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            request.setAttribute("messgae", "not have enctype: multipart/form-data");


        } else {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemorySize);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxRequestSize);
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter= items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if(item.isFormField()) {
                    String fileName = item.getName();
//               pathFIle; Vị trí chúng ta muốn upload file vào
//                thông báo cho sever
                    String pathFile = address + File.separator+ fileName;
                    File uploadFile = new File(pathFile);
                    try {
                        item.write(uploadFile);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


                } else {
                    request.setAttribute("message","Upload file fail");
                }
            }
        }


    }
}