<b>Loggedin</b>

Login Page:

<h3>Authorization using OAuth 2 using Spring Social</h3>

<a href="<c:url value="/connect/facebook" />">Connect to FaceBook...</a>

<form name='loginForm' action="social/facebook/getFreindsList" method='GET'>


		  <table>
		  		<tr>
          				<td colspan='2'><input name="search" type="text"
          					value="" />Search Text</td>
          			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login to FaceBook" /></td>
			</tr>
		  </table>


		</form>


