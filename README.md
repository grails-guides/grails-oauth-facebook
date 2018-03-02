# grails-oauth-facebook
How to add Facebook Oauth2 authentication using Spring Security Rest

Currently this guide is incomplete. I believe it is close but what is returned from facebook with the plugin does not seem
to be fully complete. When attempting to login I see that the following URLs are hit and both return 302, which seems fine

`https://www.facebook.com/v2.2/dialog/oauth?client_id=160316474555507&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Foauth%2Fcallback%2Ffacebook&state=UuHxXQVhQt&scope=email`


`http://localhost:8080/oauth/callback/facebook?code=AQAn9AS9pjWNdOPMnr7Wbw1AKpBoiBExDER6HGnOgH4d1wpCfN3FiDf9vVqptwb0r8GEBEuOWvTQ2OPhBl05fSLC5hvmUWH5K7GRgTpjx4m-nOA_rnIDgTUZs0cW0xs49B3ix1ShnP2bN9-fRZ2FvTMzbfmpYMvQSSy4nu2IVfqHIR86Pn-KDDIq7Z764MUUN0Ce1_HS3IwFR1v1uckKCg0xdSRb-lqthBSovWCEha1MlT17YotmUP1GjSTdZQBFJPAgU1ZwmAcFXAYANkdIKZqqILOeWLeBc6TerOXuHHLNojb9lKnGwAFMKcBpHpUpHl0&state=UuHxXQVhQt`

But after the browser url has the following

`http://localhost:8080/login/auth#token=&error=500&message=org.scribe.exceptions.OAuthException%3A+Response+body+is+incorrect.+Can%27t+extract+a+token+from+this%3A+%27%7B%22access_token%22%3A%22EAACRzpaEfHMBAFWcZBBpl3llajVKCem8hWM2iZA8QpTPuhlCx97M12697Kww62QujVr8hAWhmEjapK0BtYRWX8rWETi6hSsGf2EGhZAl9Xsfsviw8xAcsYIv0xZCLRYhBkjRVzFCYSCemWGmGo4ZAC2WZAYzJ9y2hUCWzzNO1mFgZDZD%22%2C%22token_type%22%3A%22bearer%22%2C%22expires_in%22%3A5179347%7D%27&error_description=org.scribe.exceptions.OAuthException%3A+Response+body+is+incorrect.+Can%27t+extract+a+token+from+this%3A+%27%7B%22access_token%22%3A%22EAACRzpaEfHMBAFWcZBBpl3llajVKCem8hWM2iZA8QpTPuhlCx97M12697Kww62QujVr8hAWhmEjapK0BtYRWX8rWETi6hSsGf2EGhZAl9Xsfsviw8xAcsYIv0xZCLRYhBkjRVzFCYSCemWGmGo4ZAC2WZAYzJ9y2hUCWzzNO1mFgZDZD%22%2C%22token_type%22%3A%22bearer%22%2C%22expires_in%22%3A5179347%7D%27&error_code=OAuthException`

In stepping through the spring-security-rest plugin in `RestOauthController.callback` where it calls
`restOauthService.storeAuthentication(provider, context)` it is throwing an error because token is null.

As per the url above what I am seeing returned is `code=xxxxx` looking in the documentation here `https://developers.facebook.com/docs/facebook-login/manually-build-a-login-flow#confirm`
it appears that a second step is required if code is received and a second call must be placed in order to receive the
access_token which the plugin does not appear to currently do.