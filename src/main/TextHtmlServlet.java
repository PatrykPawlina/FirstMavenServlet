import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TextHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Example example of reading text
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        if (req.getCookies() != null)
            for (int i = 0; i < req.getCookies().length; i++) {
                Cookie cookie = req.getCookies()[i];
                if (cookie.getName().equals("name")) {
                    printWriter.println("Hello " + cookie.getValue());
                    return;
                }
                printWriter.println("<html><head><title>My Servlet</title></head>");
                printWriter.println("<body>");
                printWriter.println("<p><h2>This is simple</h></p>");
                printWriter.println("<p><h3>Servlet example.</h3></p>");
                printWriter.println("<form method=\"post\">");
                printWriter.println("<p>Give Name:<p><input name=\"name\"/><input type=\"submit\" value=\"OK\"/>");
                printWriter.println("</form>");
                printWriter.println("</body></html>");
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("name");
        if (name != null && !"".equals(name)) {
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
            printWriter.println("Hello, " + name);
        }
    }
}
