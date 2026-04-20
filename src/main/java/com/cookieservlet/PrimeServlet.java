package com.cookieservlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("number");

        out.println("<html><body>");

        try {
            int num = Integer.parseInt(input);

            if (num <= 1) {
                out.println("<h3>Error: Please enter a number greater than 1.</h3>");
            } else {
                boolean isPrime = true;

                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime)
                    out.println("<h3>" + num + " is a Prime Number.</h3>");
                else
                    out.println("<h3>" + num + " is NOT a Prime Number.</h3>");
            }

        } catch (NumberFormatException e) {
            out.println("<h3>Error: Invalid input! Please enter a valid integer.</h3>");
        }

        out.println("</body></html>");
    }
}