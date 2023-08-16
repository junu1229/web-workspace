package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Serverinfo;

public class ItemDAO implements ItemDAOTemplate{
	
	private static ItemDAO dao = new ItemDAO();
	private ItemDAO() {
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
		}
	}
	public static ItemDAO getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM ITEM";
		PreparedStatement ps = conn.prepareStatement(query);
		ArrayList<Item> itemList = new ArrayList<Item>();
		ResultSet rs = ps.executeQuery();
		Item item = null;
		while (rs.next()) {
			item = new Item();
			item.setItemId(rs.getInt("item_id"));
			item.setItemName(rs.getString("item_name"));
			item.setPrice(rs.getInt("price"));
			item.setDescription(rs.getString("description"));
			item.setPictureUrl(rs.getString("picture_url"));
			item.setCount(rs.getInt("count"));
			itemList.add(item);
			
		}
		closeAll(rs, ps, conn);
		return itemList;
	}
	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM ITEM WHERE ITEM_ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, itemId);
		ResultSet rs = ps.executeQuery();
		Item item = null;
		if (rs.next()) {
			item = new Item();
			item.setItemId(rs.getInt("item_id"));
			item.setItemName(rs.getString("item_name"));
			item.setPrice(rs.getInt("price"));
			item.setDescription(rs.getString("description"));
			item.setPictureUrl(rs.getString("picture_url"));
			item.setCount(rs.getInt("count"));
		}
		closeAll(rs, ps, conn);
		return item;
	}
	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Item item = getItem(itemId);
		Connection conn = getConnection();
		String query = "UPDATE ITEM SET COUNT = ? WHERE ITEM_ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, item.getCount()+1);
		ps.setInt(2, itemId);
		int result = ps.executeUpdate();
		closeAll(ps, conn);
		if(result==1) {
			return true;
		}
		return false;
	}

}
