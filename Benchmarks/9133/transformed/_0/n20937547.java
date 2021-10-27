class n20937547 {
	public int saveRoom(String zz3CyEz5, String YHkDwdB6, String Bd9tgblL) {
		DBConnection ZlyitM7S = null;
		int n6eRPDaO = -1;
		try {
			ZlyitM7S = DBServiceManager.allocateConnection();
			ZlyitM7S.setAutoCommit(false);
			String GafF3Bsv = "INSERT INTO cafe_Chat_Category "
					+ "(cafe_Chat_Category_pid,cafe_Chat_Category_name, cafe_Chat_Category_icon) "
					+ "VALUES (null,?,?) ";
			PreparedStatement WkCsrmwy = ZlyitM7S.prepareStatement(GafF3Bsv);
			WkCsrmwy.setString(1, zz3CyEz5);
			WkCsrmwy.setString(2, YHkDwdB6);
			WkCsrmwy.executeUpdate();
			GafF3Bsv = "SELECT cafe_Chat_Category_id FROM cafe_Chat_Category " + "WHERE cafe_Chat_Category_name=? ";
			WkCsrmwy = ZlyitM7S.prepareStatement(GafF3Bsv);
			WkCsrmwy.setString(1, zz3CyEz5);
			ResultSet o4WxFj19 = WkCsrmwy.executeQuery();
			if (o4WxFj19.next()) {
				GafF3Bsv = "INSERT INTO cafe_Chatroom (cafe_chatroom_category, cafe_chatroom_name, cafe_chatroom_stringid) "
						+ "VALUES (?,?,?) ";
				WkCsrmwy = ZlyitM7S.prepareStatement(GafF3Bsv);
				WkCsrmwy.setInt(1, o4WxFj19.getInt("cafe_Chat_Category_id"));
				n6eRPDaO = o4WxFj19.getInt("cafe_Chat_Category_id");
				WkCsrmwy.setString(2, zz3CyEz5);
				WkCsrmwy.setString(3, Bd9tgblL);
				WkCsrmwy.executeUpdate();
			}
			ZlyitM7S.commit();
			ZlyitM7S.setAutoCommit(true);
		} catch (SQLException fcZdusXd) {
			try {
				ZlyitM7S.rollback();
			} catch (SQLException L1hQIYcg) {
			}
		} finally {
			if (ZlyitM7S != null)
				ZlyitM7S.release();
		}
		return n6eRPDaO;
	}

}