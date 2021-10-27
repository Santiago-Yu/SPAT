class n5410594 {
	@Override
	public void insert(Connection O0jVvaQV) throws SQLException {
		PreparedStatement LyNdFJqC = null;
		String ButxUxpL = null;
		int C1ixA2Ch = 0;
		try {
			O0jVvaQV.setAutoCommit(false);
			ButxUxpL = "SELECT NEXTVAL(OBJ_SEQ) AS NEXTVAL";
			LyNdFJqC = O0jVvaQV.prepareStatement(ButxUxpL);
			ResultSet xddJfc1R = LyNdFJqC.executeQuery(ButxUxpL);
			C1ixA2Ch = xddJfc1R.getInt("NEXTVAL");
			ButxUxpL = "INSERT INTO OBJECTS" + "(" + "OBJ_ID," + "OBJ_NAME," + "OBTY_CDE" + ")" + "VALUES" + "(" + "?,"
					+ "?," + "?" + ")" + "";
			LyNdFJqC = O0jVvaQV.prepareStatement(ButxUxpL);
			LyNdFJqC.setInt(1, C1ixA2Ch);
			LyNdFJqC.setString(2, getRoomKey());
			LyNdFJqC.setString(3, "ROOM");
			LyNdFJqC.executeUpdate();
			ButxUxpL = "INSERT INTO ROOMS" + "(" + "";
			O0jVvaQV.commit();
		} catch (SQLException WvucsXBX) {
			WvucsXBX.printStackTrace();
			if (O0jVvaQV != null) {
				try {
					System.err.print("Transaction is being rolled back");
					O0jVvaQV.rollback();
				} catch (SQLException uz4w3tDj) {
					uz4w3tDj.printStackTrace();
				}
			}
		} finally {
			if (LyNdFJqC != null) {
				LyNdFJqC.close();
			}
			O0jVvaQV.setAutoCommit(true);
		}
	}

}