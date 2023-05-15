<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- postの内容はページで見えない。Get内容見える -->
	



	<form action="HeyaInsert.jsp" method="post">

    
    	部屋ID：<input type="text" name= "roomId"/><br/>
		所属物件ID：<input type="text" name= "syozokuPropertyId"/><br/>
		部屋名：<input type="text" name= "roomName"/><br/>
		階数：<input type="text" name= "roomFloor"/><br/>
		金額：<input type="text" name= "price"/><br/>
		駅：<input type="text" name= "station"/><br/>
		面積：<input type="text" name= "roomArea"/><br/>
		駅から時間（分）：<input type="text" name= "minutesFromStation"/><br/>
    	<button type="submit">新規登録</button>
	</form>

</body>
</html>
