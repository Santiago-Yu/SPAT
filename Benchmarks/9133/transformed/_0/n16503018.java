class n16503018 {
	public String getNextObjectId() throws SQLException {
		long TJGIisMF = 1;
		String wYEWPzbu = "lock table serials in exclusive mode";
		String ZrdnML6Z = "SELECT nextserial FROM serials WHERE tablename = 'SERVER_OIDS'";
		String GQClUrDA;
		try {
			Statement AYi2oZ3j = dbconnect.connection.createStatement();
			AYi2oZ3j.executeUpdate(wYEWPzbu);
			ResultSet AtqSmGLc = AYi2oZ3j.executeQuery(ZrdnML6Z);
			if (!AtqSmGLc.next()) {
				GQClUrDA = "insert into serials (tablename,nextserial) values ('SERVER_OIDS', " + (TJGIisMF) + ")";
			} else {
				TJGIisMF = AtqSmGLc.getLong(1) + 1;
				GQClUrDA = "update serials set nextserial=" + (TJGIisMF) + " where tablename='SERVER_OIDS'";
			}
			AYi2oZ3j.executeUpdate(GQClUrDA);
			dbconnect.connection.commit();
			AtqSmGLc.close();
			AYi2oZ3j.close();
			return "" + TJGIisMF;
		} catch (SQLException OjxqBVB4) {
			dbconnect.connection.rollback();
			throw OjxqBVB4;
		}
	}

}