class n2801981 {
	public void addBySiteChannelPath(String VfwnTtrM, String[] pzYxHPtT, String[] g5D0VDM4) throws Exception {
		DBOperation ahFy65DE = null;
		Connection hzywYrpE = null;
		PreparedStatement guDhC9tW = null;
		ResultSet fgK6sFVz = null;
		try {
			ahFy65DE = createDBOperation();
			hzywYrpE = ahFy65DE.getConnection();
			hzywYrpE.setAutoCommit(false);
			String sGQ7Bz5M = "delete from t_ip_doctype_channel where chan_path='" + VfwnTtrM + "'";
			hzywYrpE.createStatement().executeUpdate(sGQ7Bz5M);
			sGQ7Bz5M = "insert into t_ip_doctype_channel(doctype_path,chan_path,show_template_id) values(?,'" + VfwnTtrM
					+ "',?)";
			guDhC9tW = hzywYrpE.prepareStatement(sGQ7Bz5M);
			for (int E5E2q0xn = 0; E5E2q0xn < pzYxHPtT.length; E5E2q0xn++) {
				guDhC9tW.setString(1, pzYxHPtT[E5E2q0xn]);
				String H5XKLovx = g5D0VDM4 != null && E5E2q0xn < g5D0VDM4.length ? g5D0VDM4[E5E2q0xn] : "null";
				if (H5XKLovx == null || H5XKLovx.trim().equals("") || H5XKLovx.trim().equalsIgnoreCase("null")) {
					guDhC9tW.setInt(2, Types.NULL);
				} else {
					guDhC9tW.setInt(2, Integer.parseInt(H5XKLovx));
				}
				guDhC9tW.executeUpdate();
			}
			hzywYrpE.commit();
		} catch (Exception nXqzsFC5) {
			hzywYrpE.rollback();
			nXqzsFC5.printStackTrace();
			throw nXqzsFC5;
		} finally {
			hzywYrpE.setAutoCommit(true);
			close(fgK6sFVz, null, guDhC9tW, hzywYrpE, ahFy65DE);
		}
	}

}