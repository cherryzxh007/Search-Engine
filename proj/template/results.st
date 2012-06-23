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
        <div class="body_small">
            <table class="body_bar">
                <tr>
                    <td><div class="title_small"><a href="/index"><img src="logo_small.jpg" /></a></div></td>
                    <td><div class="searchBox_small">
                        <form id="f" action="/search">
                            <input type="text" title="zapper search" name="q" id="q" maxlength="2048" size="50" value="$queryword$" />
                            <input type="submit" name="s" id="s" value="Search" />                
                        </form>
                        </div>
                    </td>
                    <td class="title_result">
                        Showing <b>$RecordSetting$</b> of $recordNum$ for <b>$querysearch$</b>
                    </td>
                </tr>
            </table>
        </div>
		<div class="searchSuggestion">
			<b>Top 10 Search Keyword :</b>
            <ol>
                $querySuggestionTool:querysuggestion()$
            </ol>
        </div>
        <div id="result">
            <ul>
                $searchTool:info()$
            </ul>
        </div>
        <div id="pageResult">
        	<ul>$pageTool:page()$</ul>
        </div>
        <div class="clear"></div>
        <div class="body_small">
            <table class="body_bar">
                <tr>
                    <td><div class="title_small"><a href="/index"><img src="logo_small.jpg"/></a></div></td>
                    <td><div class="searchBox_small">
                        <form id="fbottom" action="/search">
                            <input type="text" title="zapper search" name="q" id="qbottom" maxlength="2048" size="50" value="$queryword$" />
                            <input type="submit" name="s" id="sbottom" value="Search" />                
                        </form>
                        </div>
                    </td>
                    <td class="title_result">
                    </td>
                </tr>
            </table>
        </div>
        <div class="footer">
            <div>
                <ul>
                    <li>Zapper 2010 - Copy Right by Leo</li>                    
                </ul>
             </div>
        </div>
</div> 