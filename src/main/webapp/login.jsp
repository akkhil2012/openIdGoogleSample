<h1>Spring Security using OpenID Authentication protocol</h1>

	<div id="login-box">

		<h3>Login with Username and Password</h3>



		<form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST'>

		  <table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		  </table>


		</form>

		<c:url var="googleLogoUrl" value="/images/openid.jpg" />

         <img src="${googleLogoUrl}">sdg</img>

         <img src="openid.jpg">dfgd</img>

         <form action="j_spring_openid_security_check" method="post">
           <input name="openid_identifier" type="hidden"

         value="https://www.google.com/accounts/o8/id"/>

         <input type="submit" value="Sign with Google"/>

         </form>


	</div>
