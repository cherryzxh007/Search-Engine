<div class="header">
            <div id="topMenu">
                     <ul>
                    	$user$
                    	$setting$
                    	$userhistory$                        
                        $logout$
                    </ul>
            </div>
            <div class="clear"></div>
        </div>
		<div class="errormsg">$errormsg$</div>
        <div class="body_small">
        	<form id="f" method="post" action="/account/changepw">
            <table class="body_bar">
            	<tbody>
            	<tr>
                    <td colspan="2" align="center"><h2>Change Password</h2></td>
                </tr>
                <tr>
                    <td colspan="2"><div class="title_small"><a href="/index"><img src="$zapperlogo$" /></a></div></td>
                </tr>
                <tr>
                    <td colspan="2"><strong>Required information</strong></td>
                </tr>
                <tr>
                	<td align="right" nowrap="nowrap">Old Password:</td>
                	<td>
                		<input id="oldpw" name="oldpw" type="password" />
                    </td>
                </tr>
                <tr>
                	<td align="right" nowrap="nowrap">New Password:</td>
                	<td>
                		<input id="newpw" name="newpw" type="password" />
                    </td>
                </tr>
                <tr>
                	<td align="right" nowrap="nowrap">Re-enter New Password:</td>
                	<td>
                		<input id="newpw2" name="newpw2" type="password" />
                    </td>
                </tr>

                <tr>
                	<td  colspan="2" align="center">
                        <input type="button" name="changepw" id="changepw" value="Change" onClick="javascript:changePW();" />
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