<%@ include file="head.jsp"%>
<title>damier</title>
</head>

<body>
<%@ include file="navigation.jsp"%>

    <%!
 public String fairedamier(int i, int j){
     StringBuilder mondamier = new StringBuilder();
     mondamier.append("<p>Damier avec "+i+" lignes et "+
     j+" colonnes</p>");
     mondamier.append("<table>");
     for (int l=0;l<=i;l++){
         mondamier.append("<tr>");
         for (int c=0;c<=j;c++){
             if ((l+c)%2==0){
                 mondamier.append("<td>&nbsp;</td>");
             } else {
                 mondamier.append("<td class='noir'>&nbsp;</td>");
             }
         }
         mondamier.append("</tr>");
     }
     mondamier.append("</table>");
     return(mondamier.toString());
 }
 %>
<main>
    <h1>Affichage du damier</h1>

<%
    if(request.getAttribute("ligne")!=null && request.getAttribute("col")!=null){
        String ligne=request.getAttribute("ligne").toString();
        String col=request.getAttribute("col").toString();
        if (ligne!=null || col!=null){
            int la_ligne=Integer.parseInt(ligne);
            int la_col=Integer.parseInt(col);%>
            <%= fairedamier(la_ligne,la_col) %>
    <%
        } else {
            response.sendRedirect("accueil.jsp?e");
        }
        }
        else {
          response.sendRedirect("accueil.jsp?e");
         }
%>
</main>
<%@ include file="footer.jsp"%>