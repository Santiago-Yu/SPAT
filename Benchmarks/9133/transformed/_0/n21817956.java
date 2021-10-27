class n21817956 {
	public void moveNext(String[] Nxdcxpa6, String[] xSszC7Cj, String pswZalxy, String DjO6jlEA) throws Exception {
		Connection WhCHMgSB = null;
		PreparedStatement V6jY9wR4 = null;
		ResultSet uX2zvjDC = null;
		int pS5yZbyB = Nxdcxpa6.length;
		DBOperation cxe5NczG = factory.createDBOperation(POOL_NAME);
		String vytbpKOr = "select show_order from " + Common.ORGANIZE_TABLE + " where show_order=" + Nxdcxpa6[0]
				+ " and organize_id= '" + xSszC7Cj[0] + "'";
		try {
			WhCHMgSB = cxe5NczG.getConnection();
			WhCHMgSB.setAutoCommit(false);
			V6jY9wR4 = WhCHMgSB.prepareStatement(vytbpKOr);
			uX2zvjDC = V6jY9wR4.executeQuery();
			int gQTTgTSe = 0;
			if (uX2zvjDC.next()) {
				gQTTgTSe = uX2zvjDC.getInt(1);
			}
			String[] WMiM2YOW = new String[pS5yZbyB + 1];
			WMiM2YOW[0] = "update " + Common.ORGANIZE_TABLE + " set show_order=" + gQTTgTSe + " where show_order="
					+ pswZalxy + " and organize_id= '" + DjO6jlEA + "'";
			for (int oqYzViJ5 = 0; oqYzViJ5 < Nxdcxpa6.length; oqYzViJ5++) {
				WMiM2YOW[oqYzViJ5 + 1] = "update " + Common.ORGANIZE_TABLE + " set show_order=show_order+1"
						+ " where show_order=" + Nxdcxpa6[oqYzViJ5] + " and organize_id= '" + xSszC7Cj[oqYzViJ5] + "'";
			}
			for (int hoShjlRV = 0; hoShjlRV < WMiM2YOW.length; hoShjlRV++) {
				V6jY9wR4 = WhCHMgSB.prepareStatement(WMiM2YOW[hoShjlRV]);
				int slqLXrvz = V6jY9wR4.executeUpdate();
				if (slqLXrvz != 1) {
					throw new CesSystemException("Organize.moveNext(): ERROR Inserting data "
							+ "in T_SYS_ORGANIZE update !! resultCount = " + slqLXrvz);
				}
			}
			WhCHMgSB.commit();
		} catch (SQLException m0hba5PB) {
			if (WhCHMgSB != null) {
				WhCHMgSB.rollback();
			}
			throw new CesSystemException(
					"Organize.moveNext(): SQLException while mov organize order " + " :\n\t" + m0hba5PB);
		} finally {
			WhCHMgSB.setAutoCommit(true);
			close(cxe5NczG, V6jY9wR4, uX2zvjDC);
		}
	}

}