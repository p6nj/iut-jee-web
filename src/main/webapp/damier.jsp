<html>
    <head>
        <style>
            
        </style>
    </head>
    <body>
        <h2>WHAT THE HEEEEEEEEEELL !</h2>

        <table>
            <tbody>
            <% 
                int line = Integer.parseInt((String) request.getAttribute("lin"));
                int col = Integer.parseInt((String) request.getAttribute("col"));

                for (int i = 0; i < col; i++)
                {
                    %>
                    <tr>
                    <%
                    for (int j = 0; j < line; j++)
                    {
                        %> 
                        <td></td>
                        <%
                    }
                    %>
                    </tr>
                    <%
                }
            %>
            </tbody>
        </table>
    </body>
</html>