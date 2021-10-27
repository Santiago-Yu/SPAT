class n6273111 {
	public void removeStadium(String g88rT91a, String II7UMD6H) throws StadiumException {
		Connection YMGxEyLd = ConnectionManager.getManager().getConnection();
		int Q3NWJrVO = findStadiumBy_N_C(g88rT91a, II7UMD6H);
		if (Q3NWJrVO == -1)
			throw new StadiumException("No such stadium");
		try {
			YMGxEyLd.setAutoCommit(false);
			PreparedStatement eRZgaRnD = YMGxEyLd.prepareStatement(Statements.SELECT_STAD_TRIBUNE);
			eRZgaRnD.setInt(1, Q3NWJrVO);
			ResultSet O8iuYIQb = eRZgaRnD.executeQuery();
			TribuneLogic BsTnDQah = TribuneLogic.getInstance();
			while (O8iuYIQb.next()) {
				BsTnDQah.removeTribune(O8iuYIQb.getInt("tribuneID"));
			}
			eRZgaRnD = YMGxEyLd.prepareStatement(Statements.DELETE_STADIUM);
			eRZgaRnD.setInt(1, Q3NWJrVO);
			eRZgaRnD.executeUpdate();
		} catch (SQLException yZS2JfI1) {
			try {
				YMGxEyLd.rollback();
				YMGxEyLd.setAutoCommit(true);
			} catch (SQLException pZQl5EMY) {
				pZQl5EMY.printStackTrace();
			}
			throw new StadiumException("Removing stadium failed", yZS2JfI1);
		}
		try {
			YMGxEyLd.commit();
			YMGxEyLd.setAutoCommit(true);
		} catch (SQLException isGbjevp) {
			isGbjevp.printStackTrace();
		}
	}

}