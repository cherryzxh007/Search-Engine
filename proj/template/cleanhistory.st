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
        <div class="body_small">
        	<form id="f" method="post" action="/account/cleanhistory">
            <table class="body_bar">
            	<tbody>
            	<tr>
                    <td colspan="2" align="center"><h2>Clear History</h2></td>
                </tr>
                <tr>
                    <td colspan="2"><div class="title_small"><a href="/index"><img src="$zapperlogo$" /></a></div></td>
                </tr>               
                <tr>
                	<td colspan="2">
                		<div style="margin-left:20">                		
                			 <input type="checkbox" name="clearqueryhistory" value="q" />
                			 clear search history
                		</div>
                	</td>
                </tr>  
                <tr>
                	<td colspan="2">
                		<div style="margin-left:20">                		
							<input type="checkbox" name="clearvisitedpage" value="v" />
							clear page visit history
						</div>
					</td>
				</tr>
                <tr>
                	<td  colspan="2" align="center">
                        <input type="button" name="clear" id="clear" value="Clear History" onClick="javascript:cleanHistory();" />
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