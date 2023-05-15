<%@page import="org.omg.PortableInterceptor.SUCCESSFUL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="javaJdbc.BukenBean"%>
<%@ page import="javaJdbc.HeyaBean"%>
<%@ page import="javaJdbc.BukenService"%>
<%@ page import="javaJdbc.JdbcConn"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.logging.Level"%>
<%@ page import="java.util.logging.Logger"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#bk {
	text-align: center;
	display: flex;
}

#bk p {
	border: solid 2px;
	padding: 10px;
	margin: 10px;
}

#bkHome {
	width: 600px;
	height: 400px;
}

#bkIframe {
	display: flex;
	flex-direction: column;
}

#bkkensaku {
	width: 600px;
	margin-bottom: 20px;
}

#ks {
	margin: 20px;
}
</style>

</head>
<body>
	welcome:
	<%
String name = (String) session.getAttribute("uname");
%>

	<div id="bk">
		<p>
			<a href='buken.jsp'>管理者物件一覧</a>
		</p>
		<p>
			<a href='BukenShiki.jsp'>物件新規</a>
		</p>

		<p>
			<a href='buken.jsp'>物件編集</a>
		</p>

	</div>

	<%
	String bkdelect = request.getParameter("bkdelect");
	System.out.println("bkdelect: " + bkdelect);
	BukenService listdelect = new BukenService();
	BukenBean bukenBean = new BukenBean();
	if (bkdelect != null && !bkdelect.isEmpty()) {
		bukenBean.setPropertyId(bkdelect);
		listdelect.bukenDelete(bukenBean);
	}
	%>


	<form method="GET">
		<input type="submit" value="物件削除"> <input type="submit"
			value="物件編集"> <input type="text" name="bkdelect">
	</form>




	<%
	BukenService list = new BukenService();
	List<BukenBean> listinfo = list.kanrisyabukenlistInfo();
	List<HeyaBean> listinfoheya = list.kanrisyaheyalistInfo();
	List<BukenBean> mergedList = new ArrayList<>();
	List<HeyaBean> mergedListheya = new ArrayList<>();
	mergedList.addAll(listinfo);
	mergedListheya.addAll(listinfoheya);
	//mergedList.addAll(listinfo1); // 添加搜索结果
	%>
	<table>
		<thead>
			<tr>
				<th>物件ID</th>
				<th>物件名</th>
				<th>住所</th>
				<th>タイプ</th>
				<th>面積</th>
				<th>金額</th>
				<th>状態</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BukenBean c : mergedList) {
			%>
			<tr>
				<td contentEditable="true" onclick="getCellData(this)"><%=c.getPropertyId()%></td>
				<td contentEditable="true"><%=c.getPropertyName()%></td>
				<td contentEditable="true"><%=c.getAddress()%></td>
				<td contentEditable="true"><%=c.getPropertyType()%></td>
				<td contentEditable="true"><%=c.getPropertyArea()%></td>
				<td contentEditable="true"><%=c.getPrice()%></td>
				<td contentEditable="true"><%=c.getStatus()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>




	<%
	String inputValue = request.getParameter("inputValue");
	System.out.println("Input Value: " + inputValue);
	BukenService list1 = new BukenService();
	List<BukenBean> listinfo1 = list1.bukenkensaku(inputValue);
	%>
	<form method="GET">
		<input type="submit" value="搜索"> <input type="text"
			name="inputValue">
	</form>
	<table>
		<thead>
			<tr>
				<th>物件ID</th>
				<th>物件名</th>
				<th>住所</th>
				<th>タイプ</th>
				<th>面積</th>
				<th>金額</th>
				<th>状態</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (BukenBean c : listinfo1) {
			%>
			<tr>
				<td><input type="text" value="<%=c.getPropertyId()%>"></td>
				<td><input type="text" value="<%=c.getPropertyName()%>"></td>
				<td><input type="text" value="<%=c.getAddress()%>"></td>
				<td><input type="text" value="<%=c.getPropertyType()%>"></td>
				<td><input type="text" value="<%=c.getPropertyArea()%>"></td>
				<td><input type="text" value="<%=c.getPrice()%>"></td>
				<td><input type="text" value="<%=c.getStatus()%>"></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>


	<div id="bk">
		<p>
			<a href=''>管理者部屋一覧</a>
		</p>
		<p>
			<a href='HeyaShiki.jsp'>部屋新規</a>
		</p>

	</div>
	<%
	String hydelect = request.getParameter("hydelect");
	//System.out.println("hydelect: " + hydelect);
	BukenService listhydelect = new BukenService();
	HeyaBean heyaBean = new HeyaBean();
	if (hydelect != null && !hydelect.isEmpty()) {
		heyaBean.setRoomId(hydelect);
		listhydelect.heyeDelete(heyaBean);
	}
	%>

	<form method="GET">
		<input type="submit" value="部屋削除"> <input type="submit"
			value="部屋編集"> <input type="text" name="hydelect">
	</form>

	<table>
		<thead>
			<tr>
				<th>部屋ID</th>
				<th>所属物件ID</th>
				<th>部屋名</th>
				<th>階数</th>
				<th>金額</th>
				<th>駅</th>
				<th>面積</th>
				<th>駅から時間（分）</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (HeyaBean c : mergedListheya) {
			%>
			<tr>
				<td><input type="text" value="<%=c.getRoomId()%>"></td>
				<td><input type="text" value="<%=c.getSyozokuPropertyId()%>"></td>
				<td><input type="text" value="<%=c.getRoomName()%>"></td>
				<td><input type="text" value="<%=c.getRoomFloor()%>"></td>
				<td><input type="text" value="<%=c.getPrice()%>"></td>
				<td><input type="text" value="<%=c.getStation()%>"></td>
				<td><input type="text" value="<%=c.getRoomArea()%>"></td>
				<td><input type="text" value="<%=c.getMinutesFromStation()%>"></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	String inputValueheya = request.getParameter("inputValueheya");
	System.out.println("Input Value: " + inputValue);
	BukenService listheya = new BukenService();
	List<HeyaBean> listinfoheyakensaku = listheya.heyakensaku(inputValueheya);
	%>
	<form method="GET">
		<input type="submit" value="搜索"> <input type="text"
			name="inputValueheya">
	</form>

	<form action="../UpdateServlet" method="post">
		<table>
			<thead>
				<tr>
					<th>部屋ID</th>
					<th>所属物件ID</th>
					<th>部屋名</th>
					<th>階数</th>
					<th>金額</th>
					<th>駅</th>
					<th>面積</th>
					<th>駅から時間（分）</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (HeyaBean c : listinfoheyakensaku) {
				%>
				<tr>
					<td><input type="text" name="roomId"
						value="<%=c.getRoomId()%>"></td>
					<td><input type="text" name="syozokuPropertyId"
						value="<%=c.getSyozokuPropertyId()%>"></td>
					<td><input type="text" name="roomName"
						value="<%=c.getRoomName()%>"></td>
					<td><input type="text" name="roomFloor"
						value="<%=c.getRoomFloor()%>"></td>
					<td><input type="text" name="price" value="<%=c.getPrice()%>"></td>
					<td><input type="text" name="station"
						value="<%=c.getStation()%>"></td>
					<td><input type="text" name="roomArea"
						value="<%=c.getRoomArea()%>"></td>
					<td><input type="text" name="minutesFromStation"
						value="<%=c.getMinutesFromStation()%>"></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<button type="submit">提交</button>
	</form>


</body>
</html>