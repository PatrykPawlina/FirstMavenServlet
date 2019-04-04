import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/plain; charset=utf-8");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("Hello");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html><head><title>My Servlet</title></head>");
        printWriter.println("<body>");
        printWriter.println("<p>This is simple</p>");
        printWriter.println("<p>Servlet example.</p>");
        printWriter.println("</body></html>");
    }
}
