package javaJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BukenService {
	// 管理者物件一覧、
	public List<BukenBean> kanrisyabukenlistInfo() {
		JdbcConn jc = new JdbcConn();
		List<BukenBean> list = new ArrayList<BukenBean>();

		try {
			jc.getDbcom();
			String sql = "SELECT * FROM Property order by property_id";

			try {
				ResultSet resultSet = jc.tt(sql);
				while (resultSet.next()) {
					BukenBean bukenBeanlist = new BukenBean();
					bukenBeanlist.setPropertyId(resultSet.getString("property_id"));
					bukenBeanlist.setPropertyName(resultSet.getString("property_name"));
					bukenBeanlist.setAddress(resultSet.getString("address"));
					bukenBeanlist.setPropertyType(resultSet.getString("property_type"));
					bukenBeanlist.setPropertyArea(resultSet.getString("property_area"));
					bukenBeanlist.setPrice(resultSet.getString("price"));
					bukenBeanlist.setStatus(resultSet.getString("status"));
					list.add(bukenBeanlist);
				}
				jc.closeDbcom();
			} catch (SQLException ex) {
				Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return list;
	}

	// 管理者部屋一覧
	public List<HeyaBean> kanrisyaheyalistInfo() {
		JdbcConn jc = new JdbcConn();
		List<HeyaBean> list = new ArrayList<HeyaBean>();

		try {
			jc.getDbcom();

			String sql = "SELECT * FROM Room";

			try {
				ResultSet resultSet = jc.tt(sql);
				while (resultSet.next()) {
					HeyaBean heyaBeanlist = new HeyaBean();
					heyaBeanlist.setRoomId(resultSet.getString("room_id"));
					heyaBeanlist.setSyozokuPropertyId(resultSet.getString("syozoku_property_id"));
					heyaBeanlist.setRoomName(resultSet.getString("room_name"));
					heyaBeanlist.setRoomFloor(resultSet.getString("room_floor"));
					heyaBeanlist.setPrice(resultSet.getString("price"));
					heyaBeanlist.setStation(resultSet.getString("station"));
					heyaBeanlist.setRoomArea(resultSet.getString("room_area"));
					heyaBeanlist.setMinutesFromStation(resultSet.getString("minutes_from_station"));
					list.add(heyaBeanlist);
				}
				jc.closeDbcom();
			} catch (SQLException ex) {
				Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return list;
	}

	// 物件検索一覧、
	public List<BukenBean> bukenkensaku(String id) {
		JdbcConn jc = new JdbcConn();
		List<BukenBean> list = new ArrayList<BukenBean>();

		try {
			jc.getDbcom();

			String sql = "SELECT * FROM Property where property_id = " + id + "";
			try {
				ResultSet resultSet = jc.tt(sql);
				while (resultSet.next()) {
					BukenBean bukenBeanlist = new BukenBean();
					bukenBeanlist.setPropertyId(resultSet.getString("property_id"));
					bukenBeanlist.setPropertyName(resultSet.getString("property_name"));
					bukenBeanlist.setAddress(resultSet.getString("address"));
					bukenBeanlist.setPropertyType(resultSet.getString("property_type"));
					bukenBeanlist.setPropertyArea(resultSet.getString("property_area"));
					bukenBeanlist.setPrice(resultSet.getString("price"));
					bukenBeanlist.setStatus(resultSet.getString("status"));
					list.add(bukenBeanlist);
				}
				jc.closeDbcom();
			} catch (SQLException ex) {
				Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return list;
	}

	// 管理者部屋検索一覧
	public List<HeyaBean> heyakensaku(String id) {
		JdbcConn jc = new JdbcConn();
		List<HeyaBean> list = new ArrayList<HeyaBean>();

		try {
			jc.getDbcom();

			String sql = "SELECT * FROM Room where room_id = " + id + "";
			try {
				ResultSet resultSet = jc.tt(sql);
				while (resultSet.next()) {
					HeyaBean heyaBeanlist = new HeyaBean();
					heyaBeanlist.setRoomId(resultSet.getString("room_id"));
					heyaBeanlist.setSyozokuPropertyId(resultSet.getString("syozoku_property_id"));
					heyaBeanlist.setRoomName(resultSet.getString("room_name"));
					heyaBeanlist.setRoomFloor(resultSet.getString("room_floor"));
					heyaBeanlist.setPrice(resultSet.getString("price"));
					heyaBeanlist.setStation(resultSet.getString("station"));
					heyaBeanlist.setRoomArea(resultSet.getString("room_area"));
					heyaBeanlist.setMinutesFromStation(resultSet.getString("minutes_from_station"));
					list.add(heyaBeanlist);
				}
				jc.closeDbcom();
			} catch (SQLException ex) {
				Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return list;

	}

//物件削除、
	public void bukenDelete(BukenBean bb) throws SQLException {
		JdbcConn jc = new JdbcConn();
		try {
			jc.getDbcom();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from Property ");
			sb.append(" where ");
			sb.append(" property_id = '" + bb.getPropertyId() + "'");
			sb.append(";");
			System.out.println(sb);
			System.out.println(sb.toString());
			jc.cud(sb.toString());

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// 部屋削除
	HeyaBean heyaBean = new HeyaBean();

	public void heyeDelete(HeyaBean heyaBean) throws SQLException {
		JdbcConn jc = new JdbcConn();
		try {
			jc.getDbcom();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from Room ");
			sb.append(" where ");
			sb.append(" room_id = '" + heyaBean.getRoomId() + "'");
			sb.append(";");
			System.out.println(sb);
			System.out.println(sb.toString());
			jc.cud(sb.toString());

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(BukenService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}


