class n15737836 {
	public void delete(Site ZAeMZ1ff) throws Exception {
		DBOperation m6hhPhuc = null;
		Connection X6wvNrhx = null;
		PreparedStatement gHMmR7HI = null;
		ResultSet A1xeGql8 = null;
		try {
			String BgSotH6I = "select id from t_ip_doc where channel_path=?";
			m6hhPhuc = createDBOperation();
			X6wvNrhx = m6hhPhuc.getConnection();
			X6wvNrhx.setAutoCommit(false);
			String[] Ci7PtveZ = getSelfDefinePath(ZAeMZ1ff.getPath(), "1", X6wvNrhx, gHMmR7HI, A1xeGql8);
			selfDefineDelete(Ci7PtveZ, X6wvNrhx, gHMmR7HI);
			gHMmR7HI = X6wvNrhx.prepareStatement(BgSotH6I);
			gHMmR7HI.setString(1, ZAeMZ1ff.getPath());
			A1xeGql8 = gHMmR7HI.executeQuery();
			if (A1xeGql8.next()) {
				throw new Exception("???????" + ZAeMZ1ff.getName() + "???????????????");
			} else {
				String GZKBWEdO = "delete from t_ip_site where site_path=?";
				m6hhPhuc = createDBOperation();
				X6wvNrhx = m6hhPhuc.getConnection();
				gHMmR7HI = X6wvNrhx.prepareStatement(GZKBWEdO);
				gHMmR7HI.setString(1, ZAeMZ1ff.getPath());
				gHMmR7HI.executeUpdate();
			}
			X6wvNrhx.commit();
		} catch (SQLException uhmmZfVT) {
			X6wvNrhx.rollback();
			throw uhmmZfVT;
		} finally {
			close(A1xeGql8, null, gHMmR7HI, X6wvNrhx, m6hhPhuc);
		}
	}

}