import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDamier", value = "/ServletDamier")
public class ServletDamier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ligne = request.getParameter("ligne");
        String col = request.getParameter("col");
        if (ligne.equals("") || col.equals("") || ligne == null || col == null) {
            redirection("accueil.jsp", request, response);
        } else {
            int la_ligne = Integer.parseInt(ligne);
            int la_col = Integer.parseInt(col);
            if ((la_ligne > 0 & la_ligne <= 20) & (la_col > 0 & la_col <= 20)) {
                request.setAttribute("col", la_col);
                request.setAttribute("ligne", la_ligne);
                redirection("damier.jsp", request, response);
            } else {
                redirection("accueil.jsp?e", request, response);
            }
        }
    }

    public void redirection(String file,
            HttpServletRequest req,
            HttpServletResponse res) {
        RequestDispatcher disp = req.getRequestDispatcher(file);
        try {
            disp.forward(req, res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
