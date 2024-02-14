import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "coucou";
        System.out.println("Serveur initialisé.");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        System.out.println("redirection GET / POST");
        if (isPost(request))
            doPost(request, response);
        else
            doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    private boolean isPost(HttpServletRequest request) {
        return request.getParameterNames().hasMoreElements();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int lignes = Integer.parseInt(request.getParameter("lignes"));
        int col = Integer.parseInt(request.getParameter("col"));

        if (lignes < 0 || lignes > 10 || col < 0 || col > 10) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Erreur: lignes et colonnes invalides" + "</h1>");
            out.println("</body></html>");
        } else {
            request.setAttribute("lignes", lignes);
            request.setAttribute("col", col);
            RequestDispatcher disp = request.getRequestDispatcher("Damier.jsp");
            try {
                disp.forward(request, response);
            } catch (ServletException e) {
                System.out.println("Erreur sur la page de damier.");
            }
        }

    }

    public void destroy() {
        System.out.println("RIP");
    }
}