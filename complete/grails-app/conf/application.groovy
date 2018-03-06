grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

//tag::oauthConfig[]
grails {
	plugin {
		springsecurity {
			rest {
				token {
					storage {
						jwt {
							secret = 'foobar123'*4 //<1>
						}
					}
				}
				oauth {
					frontendCallbackUrl = { String tokenValue -> "http://localhost:8080/successfullyLoggedIn/index#token=${tokenValue}" } //<2>
					facebook {
						client = org.pac4j.oauth.client.FacebookClient //<3>
						key = '160316474555507' //<4>
						secret = '46c35c3ee9f92751ceb796764ae585a1' //<5>
						scope = 'email,user_location' //<6>
						fields = 'id,name,first_name,middle_name,last_name,email' //<7>
						defaultRoles = [] //<8>
					}
				}
			}
		}
	}
}

grails.plugin.springsecurity.providerNames = ['anonymousAuthenticationProvider'] // <9>
//end::oauthConfig[]
