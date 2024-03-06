import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletClient", value = "/ServletClient")
public class ServletClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomClient = request.getParameter("nomClient");
        String villeClient = request.getParameter("villeClient");
        String codeClient = request.getParameter("codeClient");
        if (nomClient != null || villeClient != null || codeClient != null) {
            if (!nomClient.equals("")) {
                Client client = new Client(nomClient, villeClient, codeClient);
                request.setAttribute("client", client);
                redirection("client.jsp", request, response);
            } else {
                redirection("client.jsp", request, response);
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
