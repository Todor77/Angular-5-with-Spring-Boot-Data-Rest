<html>
<head>

</head>
<body>

hello world in the template / view

<form action="/greet">
	<input type="text" name="greet" />
	<button>Submit</button>
</form>

<#if name_to_greet??>
	Hello ${name_to_greet}!
</#if>

${something_completely_different}

</body>

</html>

