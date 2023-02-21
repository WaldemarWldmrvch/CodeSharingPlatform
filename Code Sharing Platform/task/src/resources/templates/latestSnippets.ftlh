<html lang="en">
<head>
    <title>Latest</title>
</head>
<body>
    <#list allSnippets as snippet>
         <pre id="code_snippet"> ${snippet.code} </pre>
         <span id="load_date"> ${snippet.date} </span>
 <br>
    </#list>
</table>
</body>
</html>