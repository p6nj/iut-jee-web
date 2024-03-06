<%@ include file="head.jsp"%>
<title>Formulaire</title>
</head>

<body>
<%@ include file="navigation.jsp"%>

<main>
    <h1>formulaire du damier</h1>
    <form action="ServletDamier" method="post">
        <label for="ligne">Nbre de ligne</label>
        <input type="number"
               min="1" max="20" step="1"
               name="ligne" id="ligne">
        <label for="col">Nbre de colonne</label>
        <input type="number"
               min="1" max="20" step="1"
               name="col" id="col">
        <button type="submit" name="ok">Valider</button>
    </form>
</main>

<%@ include file="footer.jsp"%>