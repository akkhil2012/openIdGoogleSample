<h1>Spring Security using OpenID Authentication protocol</h1>

	<div id="login-box">

		<h3>Login with Username and Password</h3>




		<c:url var="googleLogoUrl" value="/images/openid.jpg" />

         <img src="${googleLogoUrl}">sdg</img>

         <img src="openid.jpg">dfgd</img>

         <form action="j_spring_openid_security_check" method="post">
           <input name="openid_identifier" type="hidden"

         value="https://www.google.com/accounts/o8/id"/>

         <input type="submit" value="Sign with Google"/>

         </form>


	</div>
