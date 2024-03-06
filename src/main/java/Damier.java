import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "damierServlet", value = "/damier")
public class Damier extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String col = request.getParameter("c");
        String lin = request.getParameter("l");
        if (lin != null && col != null && !lin.isEmpty() && !col.isEmpty()) {
            request.setAttribute("col", col);
            request.setAttribute("lin", lin);
            try {
                int l = Integer.parseInt(lin);
                int c = Integer.parseInt(col);
                if (l > 0 && l <= 20 && c > 0 && c <= 20) {
                    request.setAttribute("col", col);
                    request.setAttribute("lin", lin);
                    RequestDispatcher disp = request.getRequestDispatcher("damier.jsp");
                    disp.forward(request, response);
                }
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else
            response.sendRedirect("accueil.jsp");
    }

}
