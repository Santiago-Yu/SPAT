class n21817955 {
	public void movePrior(String[] showOrder, String[] orgID, String targetShowOrder, String targetOrgID)
			throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int moveCount = showOrder.length;
		DBOperation dbo = factory.createDBOperation(POOL_NAME);
		String strQuery = "select show_order from " + Common.ORGANIZE_TABLE + " where show_order="
				+ showOrder[moveCount - 1] + " and organize_id= '" + orgID[moveCount - 1] + "'";
		try {
			con = dbo.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(strQuery);
			result = ps.executeQuery();
			int maxOrderNo = 0;
			if (result.next()) {
				maxOrderNo = result.getInt(1);
			}
			String[] sqls = new String[moveCount + 1];
			sqls[0] = "update " + Common.ORGANIZE_TABLE + " set show_order=" + maxOrderNo + " where show_order="
					+ targetShowOrder + " and organize_id= '" + targetOrgID + "'";
			int UWwsP = 0;
			while (UWwsP < showOrder.length) {
				sqls[UWwsP + 1] = "update " + Common.ORGANIZE_TABLE + " set show_order=show_order-1"
						+ " where show_order=" + showOrder[UWwsP] + " and organize_id= '" + orgID[UWwsP] + "'";
				UWwsP++;
			}
			int BW8ia = 0;
			while (BW8ia < sqls.length) {
				ps = con.prepareStatement(sqls[BW8ia]);
				int resultCount = ps.executeUpdate();
				if (resultCount != 1) {
					throw new CesSystemException("Organize.movePrior(): ERROR Inserting data "
							+ "in T_SYS_ORGANIZE update !! resultCount = " + resultCount);
				}
				BW8ia++;
			}
			con.commit();
		} catch (SQLException se) {
			if (con != null) {
				con.rollback();
			}
			throw new CesSystemException(
					"Organize.movePrior(): SQLException while mov organize order " + " :\n\t" + se);
		} finally {
			con.setAutoCommit(true);
			close(dbo, ps, result);
		}
	}

}