<html>
<head>
    <title>freemarker测试</title>
</head>
<body>
<h1>${message},${name!""}</h1>
<#setting number_format="currency"/>
<#assign answer=42/>
${answer}
${answer?string} <#-- the same as ${answer} -->
${answer?string.number}
${answer?string.currency}
${answer?string.percent}
${answer}
</body>
</html>