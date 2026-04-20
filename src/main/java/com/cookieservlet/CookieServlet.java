package com.cookieservlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET request (display page)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                }
                if (cookie.getName().equals("count")) {
                    count = Integer.parseInt(cookie.getValue());
                }
            }
        }

        // HTML response
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");

        if (existingUser != null) {
            count++;

            // Update count cookie
            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(60); // 1 minute
            response.addCookie(countCookie);

            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page " + count + " times!</h2>");

            // Logout button
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");

        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please login</h2>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Handle POST request (login + logout)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        // If username is provided → LOGIN
        if (userName != null && !userName.isEmpty()) {

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 1 minute

            Cookie countCookie = new Cookie("count", "0");
            countCookie.setMaxAge(60);

            response.addCookie(userCookie);
            response.addCookie(countCookie);

        } else {
            // LOGOUT → delete cookies
            Cookie userCookie = new Cookie("user", "");
            userCookie.setMaxAge(0);

            Cookie countCookie = new Cookie("count", "");
            countCookie.setMaxAge(0);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        response.sendRedirect("CookieServlet");
    }
}