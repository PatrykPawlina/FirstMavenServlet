package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession httpSession = req.getSession();
        httpSession.setMaxInactiveInterval(5);
        Integer counter = (Integer) httpSession.getAttribute("counter");
        if (counter == null)
            counter = 1;
        else
            counter++;
        httpSession.setAttribute("counter", counter);
        printWriter.println("Counter: " + counter);
    }
}
