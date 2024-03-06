<%@ include file="head.jsp"%>
<title>login</title>
</head>

<body>
<%@ include file="navigation.jsp"%>
<main>
    <h1>formulaire d'authentification</h1>
    <form action="ServletLogin" method="post">
        <label for="login">Login</label>
        <input type="text"
               name="login" id="login" placeholder="login">
        <label for="mdp">Mot de passe</label>
        <input type="password"
               name="mdp" id="mdp" placeholder="mot de passe">
        <button type="submit" name="ok">Valider</button>
    </form>
</main>
<%@ include file="footer.jsp"%>