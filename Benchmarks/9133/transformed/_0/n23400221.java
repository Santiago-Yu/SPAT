class n23400221 {
	public void delete(Channel WephnO2X) throws Exception {
		DBOperation dKjaRMZA = null;
		Connection N06QlSvO = null;
		PreparedStatement qWg9oB6t = null;
		ResultSet xIhoV1gS = null;
		try {
			dKjaRMZA = createDBOperation();
			N06QlSvO = dKjaRMZA.getConnection();
			N06QlSvO.setAutoCommit(false);
			String[] POehgZv3 = getSelfDefinePath(WephnO2X.getPath(), "1", N06QlSvO, qWg9oB6t, xIhoV1gS);
			selfDefineDelete(POehgZv3, N06QlSvO, qWg9oB6t);
			String EKh5HyQY = "delete from t_ip_channel where channel_path=?";
			qWg9oB6t = N06QlSvO.prepareStatement(EKh5HyQY);
			qWg9oB6t.setString(1, WephnO2X.getPath());
			qWg9oB6t.executeUpdate();
			EKh5HyQY = "delete from t_ip_channel_order where channel_order_site = ?";
			qWg9oB6t.setString(1, WephnO2X.getPath());
			qWg9oB6t.executeUpdate();
			N06QlSvO.commit();
		} catch (SQLException nqbtlxHb) {
			N06QlSvO.rollback();
			log.error("??????????channelPath=" + WephnO2X.getPath(), nqbtlxHb);
			throw nqbtlxHb;
		} finally {
			close(xIhoV1gS, null, qWg9oB6t, N06QlSvO, dKjaRMZA);
		}
	}

}