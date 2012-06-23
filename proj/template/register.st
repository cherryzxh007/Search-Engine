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
        	<form id="f" method="post" action="/register">
            <table class="body_bar">
            	<tbody>
            	<tr>
                    <td colspan="2" align="center"><h2>Create Account</h2></td>
                </tr>
                <tr>
                    <td colspan="2"><div class="title_small"><a href="/index"><img src="logo_small.jpg" /></a></div></td>
                </tr>
                <tr>
                    <td colspan="2"><strong>Required information</strong></td>
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
                	<td align="right" nowrap="nowrap">Re-enter Password:</td>
                	<td>
                		<input id="repw" name="repw" type="password" />
                    </td>
                </tr>
                <tr>
                	<td align="right" nowrap="nowrap">First Name:</td>
                	<td>
                		<input type="text" id="firstname" name="firstname" />
                    </td>
                </tr>
                <tr>
                	<td align="right" nowrap="nowrap">Last Name:</td>
                	<td>
                		<input type="text" id="lastname" name="lastname" />
                    </td>
                </tr>                
                <tr>
                	<td  colspan="2" align="center">
                        <input type="button" name="register" id="register" value="Register" onClick="javascript:getRegister();" />
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