<jsp:useBean id="pageBean" class="beans.PageDataBean" scope="request"></jsp:useBean>
<div class="page-header">
  <h1>  	
  		<jsp:getProperty name="pageBean" property="pageTitle" />
   <small>CS 320</small></h1>
</div>
