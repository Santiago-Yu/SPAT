class n17337889 {
	public int register(String n2PMWVw0, String uw1ZATOI, String MOBIKqWV, String GuTGIqpA, String QYiHlyvr) {
		int A6qjrw3F = 0;
		int mZRZvp1y = -1;
		try {
			getCon().setAutoCommit(false);
			if (!checkUser(n2PMWVw0, uw1ZATOI)) {
				PreparedStatement f6oyveYf = getCon().prepareStatement(
						"insert into user(uname, upass, uemail, uaddr, ucontact)" + " values (?,?,?,?,?)");
				f6oyveYf.setString(1, n2PMWVw0);
				f6oyveYf.setString(2, uw1ZATOI);
				f6oyveYf.setString(3, MOBIKqWV);
				f6oyveYf.setString(4, GuTGIqpA);
				f6oyveYf.setString(5, QYiHlyvr);
				int ToJbbgJz = f6oyveYf.executeUpdate();
				if (ToJbbgJz == 1) {
					ResultSet eXVti60O = f6oyveYf.getGeneratedKeys();
					if (eXVti60O.next()) {
						mZRZvp1y = eXVti60O.getInt(1);
					}
				}
			} else {
				mZRZvp1y = -1;
			}
		} catch (SQLException nKKyP3Uf) {
			nKKyP3Uf.printStackTrace();
			mZRZvp1y = -1;
			try {
				System.out.println("Transaction roll back due to errors");
				getCon().rollback();
			} catch (Exception dru96LCp) {
			}
		}
		return mZRZvp1y;
	}

}