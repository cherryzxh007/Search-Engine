<div class="header">
        <div id="topMenu">
                    <ul>
                        <li><a href="/login" title="Sign in">Sign in</a></li>
                    </ul>
            </div>
            <div class="clear"></div>
        </div>
		<div class="errormsg">$errormsg$</div>
        <div class="body_small">
        	<form id="f" method="post" action="/login">
            <table class="body_bar">
            	<tbody>
            	<tr>
                    <td colspan="2" align="center"><h2>Sign in</h2></td>
                </tr>
                <tr>
                    <td colspan="2"><div class="title_small"><a href="/index"><img src="logo_small.jpg" /></a></div></td>
                </tr>
                <tr>
                    <td align="right" nowrap="nowrap">Email:</td>
                    <td>
                    	<input type="text" id="useremail" name="useremail" />
                    </td>
                </tr>
                <tr>
                	<td align="right" nowrap="nowrap">Password:</td>
                	<td>
                		<input id="pw" name="pw" type="password" />
                    </td>
                </tr>
                <tr>
                	<td colspan="2" align="center">
                		<a href="/register" title="Register">Registration</a>
                	</td>
                </tr>
                <tr>
                	<td  colspan="2"  align="center">
                        <input type="button" name="signIn" id="signIn" value="Sign In" onClick="javascript:getLogin();" />
                    </td>
                </tr>                
                </tbody>
            </table>
            </form>
        </div>
        <div class="footer">
            <div>
                <ul>
                    <li>Zapper 2010 - Copy Right by Leo</li>                    
                </ul>
             </div>
        </div>
</div>