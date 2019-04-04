import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/plain; charset=utf-8");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("Hello");
//        resp.setContentType("text/html; charset=utf-8");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("<html><head><title>My Servlet</title></head>");
//        printWriter.println("<body>");
//        printWriter.println("<p><h2>This is simple</h></p>");
//        printWriter.println("<p><h3>Servlet example.</h3></p>");
//        printWriter.println("</body></html>");

        byte[] buffer = loadFile("C:\\java.png");
        resp.setContentType("image/jpg");
        resp.setContentLength(buffer.length);
        resp.addHeader("Content-Description", "attachment;filename=image.jpg");
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(buffer);
        outputStream.flush();
    }

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
