<b>Loggedin</b>

Login Page:

<h3>Authorization using OAuth 2 using Spring Social</h3>

<form name='connectFBForm' action="/connect/facebook" method='POST'>


		  <table>

			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login to FaceBook" /></td>
			</tr>
		  </table>


		</form>

<form name='loginForm' action="social/facebook/getFreindsList" method='GET'>


		  <table>

				<td colspan='2'><input name="submit" type="submit"
					value="Get Freinds List for  FaceBook" /></td>
			</tr>
		  </table>


		</form>


		To get the User Details from DATABASE
		<html>
          <body>
           <form action="enterAccountDtls/" method="POST">
            <label for="Account">Enter Account Details</label>
            <label for="Name">Account Holder Name</label>
             <input type="Name" name="name" id="name"><br>
            <label for="AccountType">AccountType</label>
              <input type="AccountType" name="accountType" id="AccountType"><br>
              <input type="submit" value="Submit details">
           </form>

          </body>
        </html>


