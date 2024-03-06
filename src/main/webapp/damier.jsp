<%@ include file="header.jsp" %>
<%! public String damierBuilder(int i, int j){
    StringBuilder damier=new StringBuilder();
    damier.append("<p>Damier avec "+i+"lignes et "+j+" colonnes</p>");
    damier.append("<table>");
    for(int l=0;l<=i;l++){
        damier.append("<tr>");
        for(int c=0;c<=j;c++){
            if((l+c)%2==0)damier.append("<td>&nbsp;</td>");
            else damier.append("<td class='noir'>&nbsp;</td>");
        }
        damier.append("<tr>");
    }
    damier.append("</table>");
    return damier.toString();
} %>
<title>Damier</title>
</head>
<main>
    <%! if((String lin=request.getAttribute("ligne"))!=null && (String col=request.getAttribute("col"))!=null){
        int l = Integer.parseInt(lin);
        int c = Integer.parseInt(col);
        if(l > 0 && l <= 20 && c > 0 && c <= 20)%><%= damierBuilder(l,c) %><%
        else response.sendRedirect("accueil.jsp?e");
    }%>
<%@ include file="footer.jsp" %>