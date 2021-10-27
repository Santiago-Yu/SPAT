class n17102809 {
	private int create() throws SQLException {
		Connection KBmRvLBb = null;
		Statement Wlvw4eRS = null;
		ResultSet aHi5luiG = null;
		String hgvA9qaq = null;
		try {
			KBmRvLBb = dataSource.getConnection();
			Wlvw4eRS = KBmRvLBb.createStatement();
			hgvA9qaq = "insert into " + DB.Tbl.users + "(" + col.name + "," + col.login + "," + col.pass + ","
					+ col.passHash + "," + col.email + "," + col.role + "," + col.addDate + ") values('" + name + "','"
					+ login + "','" + pass + "','" + pass.hashCode() + "','" + email + "'," + role + ",now())";
			Wlvw4eRS.executeUpdate(hgvA9qaq, new String[] { col.id });
			aHi5luiG = Wlvw4eRS.getGeneratedKeys();
			while (aHi5luiG.next()) {
				int NHzLB1BM = aHi5luiG.getInt(1);
				KBmRvLBb.commit();
				return NHzLB1BM;
			}
			throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §á§à§Ý§å§é§Ú§ä§î generatedKey §á§â§Ú §ã§à§Ù§Õ§Ñ§ß§Ú§Ú §á§à§Ý§î§Ù§à§Ó§Ñ§ä§Ö§Ý§ñ.");
		} catch (SQLException Ljgu1YI8) {
			try {
				KBmRvLBb.rollback();
			} catch (Exception YsxkI9C5) {
			}
			throw Ljgu1YI8;
		} finally {
			try {
				aHi5luiG.close();
			} catch (Exception iVe9B9dN) {
			}
			try {
				Wlvw4eRS.close();
			} catch (Exception CaYNXW8h) {
			}
			try {
				KBmRvLBb.close();
			} catch (Exception GXkIDopf) {
			}
		}
	}

}