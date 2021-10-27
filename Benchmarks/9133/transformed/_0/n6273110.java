class n6273110 {
	public void addStadium(Stadium AJxm0tVt) throws StadiumException {
		Connection BFq07Iu5 = ConnectionManager.getManager().getConnection();
		if (findStadiumBy_N_C(AJxm0tVt.getName(), AJxm0tVt.getCity()) != -1)
			throw new StadiumException("Stadium already exists");
		try {
			PreparedStatement oTwZDvAw = BFq07Iu5.prepareStatement(Statements.INSERT_STADIUM);
			BFq07Iu5.setAutoCommit(false);
			oTwZDvAw.setString(1, AJxm0tVt.getName());
			oTwZDvAw.setString(2, AJxm0tVt.getCity());
			oTwZDvAw.executeUpdate();
			int SNPWU7JX = getMaxId();
			TribuneLogic pir90j0P = TribuneLogic.getInstance();
			for (Tribune IIqQP3ww : AJxm0tVt.getTribunes()) {
				int XwLcsi81 = pir90j0P.addTribune(IIqQP3ww);
				if (XwLcsi81 != -1) {
					oTwZDvAw = BFq07Iu5.prepareStatement(Statements.INSERT_STAD_TRIBUNE);
					oTwZDvAw.setInt(1, SNPWU7JX);
					oTwZDvAw.setInt(2, XwLcsi81);
					oTwZDvAw.executeUpdate();
				}
			}
		} catch (SQLException YtrBxVj6) {
			try {
				BFq07Iu5.rollback();
				BFq07Iu5.setAutoCommit(true);
			} catch (SQLException CEtT5r1v) {
				CEtT5r1v.printStackTrace();
			}
			throw new StadiumException("Adding stadium failed", YtrBxVj6);
		}
		try {
			BFq07Iu5.commit();
			BFq07Iu5.setAutoCommit(true);
		} catch (SQLException yz5XbM6e) {
			yz5XbM6e.printStackTrace();
		}
	}

}