import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/plain; charset=utf-8");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("Hello");

//        Example example of reading text
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><head><title>My Servlet</title></head>");
        printWriter.println("<body>");
        printWriter.println("<p><h2>This is simple</h></p>");
        printWriter.println("<p><h3>Servlet example.</h3></p>");
        printWriter.println("<form method=\"post\">");
        printWriter.println("<p>Give Name:<p><input name=\"name\"/><input type=\"submit\" value=\"OK\"/>");
        printWriter.println("</form>");
        printWriter.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("name");
        if (name != null && !"".equals(name)) ;
        printWriter.println("Witaj, " + name);
    }

//      Example of loading a binary file, e.g. a photo
//        byte[] buffer = loadFile("C:\\Users\\ppawl\\Pictures\\Honor 7\\IMG_20160914_105018.jpg");
//        resp.setContentType("image/jpg");
//        resp.setContentLength(buffer.length);
//        resp.addHeader("Content-Description", "attachment;filename=image.jpg");
//        OutputStream outputStream = resp.getOutputStream();
//        outputStream.write(buffer);
//        outputStream.flush();

    private byte[] loadFile(String nameFile) throws IOException {
        File file = new File(nameFile);
        long size = file.length();
        byte[] content = new byte[(int) size];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(content);
        fileInputStream.close();
        return content;
    }
}
