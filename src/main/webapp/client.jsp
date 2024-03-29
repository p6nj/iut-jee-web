<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ListIterator" %>
<%! public class Client {

    String nomClient;
    String villeClient;
    String codeClient;

    public Client(String nomClient, String villeClient, String codeClient) {
        this.nomClient = nomClient;
        this.villeClient = villeClient;
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }
}
%>
<%@ include file="head.jsp"%>
<title>Client</title>
</head>
<%! ArrayList listeClient = new ArrayList<Client>();%>

<%! public String afficherClient(Client client){
  StringBuilder ac = new StringBuilder();
  ac.append("<p>Client : <b>"+client.getNomClient()+"</b></p>");
          return(ac.toString());
}
%>
<body>
<%@ include file="navigation.jsp"%>
<main class="client">
    <div>
    <h2>Insertion des clients</h2>
    <form action="ServletClient" method="post">
        <label for="nomClient">Nom du client</label>
        <input type="text"
               name="nomClient" id="nomClient">
        <label for="villeClient">Ville du client</label>
        <input type="text"
               name="villeClient" id="villeClient">
        <label for="codeClient">Ville du client</label>
        <input type="text"
               name="codeClient" id="codeClient">
        <button type="submit" name="ok">Valider</button>
    </form>
    </div>
    <div>
        <h2>affichage des clients</h2>
        <%
            Client cli = (Client) request.getAttribute("client");
            if (cli!=null){
                listeClient.add(cli);
                ListIterator<Client> li = listeClient.listIterator();
                while (li.hasNext()){%>
                    <%= afficherClient(li.next())%>
                <% }
            }
        %>
    </div>
</main>
<%@ include file="footer.jsp"%>