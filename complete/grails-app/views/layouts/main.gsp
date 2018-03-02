<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
		            <asset:image src="grails.svg" alt="Grails Logo"/>
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav" />
                </ul>
            </div>
        </div>
    </div>

    <div class="centered" style="margin: 10px auto;">
        <g:link controller="book" action="index">
            <g:message code="book.all" default="All"/>
        </g:link>
        <span>|</span>
        <g:link controller="bookFavourite" action="index">
            <g:message code="book.favourite" default="Favourites"/>
        </g:link>
        <span>|</span>
        <sec:ifNotLoggedIn>
            <a href="/oauth/authenticate/facebook">${g.message(code: "login.facebook", default:"Login with Facebook")}</a>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            <g:form controller="logout" style="display: inline;">
                <input type="submit" value="${g.message(code: "logout", default:"Logout")}"/>
            </g:form>
        </sec:ifLoggedIn>
    </div>

    <g:if test="${flash.message}">
        <div class="message" style="display: block">${flash.message}</div>
    </g:if>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
