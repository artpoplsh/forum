/*window.onload=function(){
	//alert("ok");
	
	 $(".login").click(function(){
        // alert("df");
         var username=$('#username').value;
     	alert(username);
        var url="getmsg.php";
 		var data="de";
 		//alert(data);
 		var xhr=new XMLHttpRequest();
 		xhr.open("post",url,true);
 		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
 		xhr.onreadystatechange=function(){
 			if(xhr.readyState==4){
 				 if(xhr.status==200){
 				   var msg=xhr.responseText;
 				   var res = eval('(' + msg + ')');
 				   if((length=res.length)!=0){
 					  // alert(length);
 				   for(var i=0;i<length;i++){
 					   //alert(res[i].content+" "+res[i].time);
 					 }
 				   }
 					}else{
 					        
 					}
 				}
 			}
 		xhr.send(data);
	 }

	)

}*/