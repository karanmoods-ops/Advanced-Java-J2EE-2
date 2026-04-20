package com.sessiontracking;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String sessionId = session.getId();

        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Tracking Demo</title></head>");
        out.println("<body>");
        out.println("<h2>Session Tracking Information</h2>");
        out.println("<p>Session ID: " + sessionId + "</p>");
        out.println("<p>Session Creation Time: " + createTime + "</p>");
        out.println("<p>Last Access Time: " + lastAccessTime + "</p>");
        out.println("<p>Visit Count: " + visitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}