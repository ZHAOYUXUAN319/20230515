<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javaJdbc.JdbcConn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>新規登録できました。</p>
	<p>
		<a href=login.jsp>ログインページへ</a>
	</p>
	<%
	JdbcConn jc = new JdbcConn();

	try {
		jc.getDbcom();

		String roomId = request.getParameter("roomId");
		String syozokuPropertyId = request.getParameter("syozokuPropertyId");
		String roomName = request.getParameter("roomName");
		String roomFloor = request.getParameter("roomFloor");
		String price = request.getParameter("price");
		String station = request.getParameter("station");
		String roomArea = request.getParameter("roomArea");
		String minutesFromStation = request.getParameter("minutesFromStation");

		String sql = "insert into room(room_id, syozoku_property_id, room_name,room_floor,price,station,room_area,minutes_from_station) values('" + roomId + "','" + syozokuPropertyId + "','" + roomName + "','" + roomFloor + "','" + price + "','" + station + "','" + roomArea + "','" + minutesFromStation + "')";
		jc.cud(sql);

	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
	} 
	%>

</body>
</html>
