<%@ include file="header.jsp" %>
    <title>Formulaire</title>
    <h2>Formulaire !</h2>
    <form method="POST" action="damier">
        <label for="c">Colonnes :</label><br>
        <input type="number" id="c" name="c"><br>
        <label for="l">Lignes :</label><br>
        <input type="number" id="l" name="l">
        <input type="submit" value="Submit">
    </form>
    <%@ include file="navigation.jsp" %>
        </body>

        </html>