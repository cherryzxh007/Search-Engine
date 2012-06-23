<div class="main">
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
        <div class="title_small">
        	<div style="float:left;margin-top:10px">
        		<a href="/index"><img src="logo_small.jpg" /></a>
        	</div>
        	<div style="float:left; margin-left:20px;">
        		<h3>My History</h3>
        	</div>
        	<div style="clear:both"></div>
        </div>
        <div style="margin-left:100px">
            <table>
            	<tbody>
            		<tr>
            			<td valign="top">
            				<table border="1" cellspacing="1" cellpadding="1">
            					<thead>
            						<tr>
            							<th colspan="2">
            								Search History
            							</th>
            						</tr>
            						<tr>
            							<th>Query</th>
            							<th>Date</th>
            						</tr>
            					</thead>
            					<tbody>
            						$queryRecord:queryrecord()$
            					</tbody>
            				</table>
            			</td>
            			<td valign="top">
            				<table border="1" cellspacing="1" cellpadding="1">
            					<thead>
            						<tr>
            							<th colspan="2">
            								Page Visited History
            							</th>
            						</tr>
            						<tr>
            							<th>Visited Link</th>
            							<th>Date</th>
            						</tr>
            					</thead>
            					<tbody>
            						$visitedRecord:visitedrecord()$
            					</tbody>
            				</table>
            			</td>
            		</tr>
            	</tbody>
            </table>
        </div>
        <div class="clear"></div>
        <div class="footer">
            <div>
                <ul>
                    <li>Zapper 2010 - Copy Right by Leo</li>                    
                </ul>
             </div>
        </div>
    </div> 