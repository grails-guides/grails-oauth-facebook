// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'demo.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'demo.UserRole'
grails.plugin.springsecurity.authority.className = 'demo.Role'
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
				oauth {
					frontendCallbackUrl = { String tokenValue -> "http://localhost:8080/successfullyLoggedIn/index#token=${tokenValue}" } //<1>
					facebook {
						client = org.pac4j.oauth.client.FacebookClient //<2>
						key = '160316474555507' //<3>
						secret = '46c35c3ee9f92751ceb796764ae585a1' //<4>
						scope = 'email,user_location' //<5>
						fields = 'id,name,first_name,middle_name,last_name,username'
						defaultRoles = ['ROLE_USER', 'ROLE_FACEBOOK'] //<6>
					}
				}
			}
		}
	}
}
//end::oauthConfig[]
