import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello huehvevzijvo!";
        System.out.println("Le serveur passe bien par init");
    }

    public void service(HttpServletRequest request, HttpServletResponse reponse) throws IOException, ServletException {
        System.out.println("le serveur passe bien par le service");
        doPost(request, reponse);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String col = (String) request.getParameter("c");
        String lin = (String) request.getParameter("l");
        request.setAttribute("col", col);
        request.setAttribute("lin", lin);
        RequestDispatcher disp = request.getRequestDispatcher("damier.jsp");
        try {
            disp.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        // response.sendRedirect("index.jsp");
    }

    public void destroy() {
        System.out.println("le serveur passe bien par le  destroy");
    }
}