package javaJdbc;
import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomId = request.getParameter("roomId");
		String syozokuPropertyId = request.getParameter("syozokuPropertyId");
		String roomName = request.getParameter("roomName");
		String roomFloor = request.getParameter("roomFloor");
		String price = request.getParameter("price");
		String station = request.getParameter("station");
		String roomArea = request.getParameter("roomArea");
		String minutesFromStation = request.getParameter("minutesFromStation");
		System.out.println(roomId);
		try {

			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres", "postgres",
					"319333633");

			String sql = "UPDATE room SET syozoku_property_id = " + syozokuPropertyId + ",room_name = " + roomName+ ", room_floor = " + roomFloor + ", price = " + price + ", station = " + station + ", room_area = "+ roomArea + ", minutes_from_station = " + minutesFromStation + " WHERE room_id = " + roomId + "";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();


//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, syozokuPropertyId);
//			pstmt.setString(2, roomName);
//			pstmt.setString(3, roomFloor);
//			pstmt.setString(4, price);
//			pstmt.setString(5, station);
//			pstmt.setString(6, roomArea);
//			pstmt.setString(7, minutesFromStation);
//			pstmt.setString(8, roomId);
//
//			int rowsAffected = pstmt.executeUpdate();

			

			//pstmt.close();
			conn.close();

//			if (rowsAffected > 0) {
//				response.getWriter().write("更新成功");
//			} else {
//				response.getWriter().write("更新失败");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("更新失败");
		}
	}
}