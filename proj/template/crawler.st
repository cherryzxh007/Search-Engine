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
        <div class="body">
            <div class="title_small"><a href="/index"><img src="$zapperlogo$" /></a></div>
            <div class="searchBox">
            	<form id="f" action="/account/crawler" method="post">
                    <b>new seed URL:</b> <input type="text" title="new url" name="seedurl" id="seedurl" maxlength="2048" size="40" />
                    <input type="button" name="c" id="c" value="Crawl"  onClick="javascript:crawl();"  />                
            	</form>
            </div>
        </div>
        <div class="footer">
            <div>
                <ul>
                    <li>Zapper 2010 - Copy Right by Leo</li>                    
                </ul>
             </div>
        </div>
</div> 