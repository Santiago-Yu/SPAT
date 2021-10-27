class n18488919 {
	private void insert(Connection M0kONmUL) throws SQLException {
		if (m_fromDb)
			throw new IllegalStateException("The record already exists in the database");
		StringBuffer Bk3VyYvR = new StringBuffer("INSERT INTO ifServices (nodeID,ipAddr,serviceID");
		StringBuffer bSood9bq = new StringBuffer("?,?,?");
		if ((m_changed & CHANGED_IFINDEX) == CHANGED_IFINDEX) {
			bSood9bq.append(",?");
			Bk3VyYvR.append(",ifIndex");
		}
		if ((m_changed & CHANGED_STATUS) == CHANGED_STATUS) {
			bSood9bq.append(",?");
			Bk3VyYvR.append(",status");
		}
		if ((m_changed & CHANGED_LASTGOOD) == CHANGED_LASTGOOD) {
			bSood9bq.append(",?");
			Bk3VyYvR.append(",lastGood");
		}
		if ((m_changed & CHANGED_LASTFAIL) == CHANGED_LASTFAIL) {
			bSood9bq.append(",?");
			Bk3VyYvR.append(",lastFail");
		}
		if ((m_changed & CHANGED_SOURCE) == CHANGED_SOURCE) {
			bSood9bq.append(",?");
			Bk3VyYvR.append(",source");
		}
		if ((m_changed & CHANGED_NOTIFY) == CHANGED_NOTIFY) {
			bSood9bq.append(",?");
			Bk3VyYvR.append(",notify");
		}
		if ((m_changed & CHANGED_QUALIFIER) == CHANGED_QUALIFIER) {
			bSood9bq.append(",?");
			Bk3VyYvR.append(",qualifier");
		}
		Bk3VyYvR.append(") VALUES (").append(bSood9bq).append(')');
		if (log().isDebugEnabled())
			log().debug("DbIfServiceEntry.insert: SQL insert statment = " + Bk3VyYvR.toString());
		PreparedStatement bcj5wPZ0 = null;
		PreparedStatement B06AgzFn = null;
		final DBUtils JinjmNay = new DBUtils(getClass());
		try {
			bcj5wPZ0 = M0kONmUL.prepareStatement(Bk3VyYvR.toString());
			JinjmNay.watch(bcj5wPZ0);
			Bk3VyYvR = null;
			int wtiAdCB8 = 1;
			bcj5wPZ0.setInt(wtiAdCB8++, m_nodeId);
			bcj5wPZ0.setString(wtiAdCB8++, m_ipAddr.getHostAddress());
			bcj5wPZ0.setInt(wtiAdCB8++, m_serviceId);
			if ((m_changed & CHANGED_IFINDEX) == CHANGED_IFINDEX)
				bcj5wPZ0.setInt(wtiAdCB8++, m_ifIndex);
			if ((m_changed & CHANGED_STATUS) == CHANGED_STATUS)
				bcj5wPZ0.setString(wtiAdCB8++, new String(new char[] { m_status }));
			if ((m_changed & CHANGED_LASTGOOD) == CHANGED_LASTGOOD) {
				bcj5wPZ0.setTimestamp(wtiAdCB8++, m_lastGood);
			}
			if ((m_changed & CHANGED_LASTFAIL) == CHANGED_LASTFAIL) {
				bcj5wPZ0.setTimestamp(wtiAdCB8++, m_lastFail);
			}
			if ((m_changed & CHANGED_SOURCE) == CHANGED_SOURCE)
				bcj5wPZ0.setString(wtiAdCB8++, new String(new char[] { m_source }));
			if ((m_changed & CHANGED_NOTIFY) == CHANGED_NOTIFY)
				bcj5wPZ0.setString(wtiAdCB8++, new String(new char[] { m_notify }));
			if ((m_changed & CHANGED_QUALIFIER) == CHANGED_QUALIFIER)
				bcj5wPZ0.setString(wtiAdCB8++, m_qualifier);
			int TnS0JsFC;
			try {
				TnS0JsFC = bcj5wPZ0.executeUpdate();
			} catch (SQLException sZvTnsfU) {
				log().warn("ifServices DB insert got exception; will retry after "
						+ "deletion of any existing records for this ifService " + "that are marked for deletion.",
						sZvTnsfU);
				M0kONmUL.rollback();
				String IIDp8LqT = "DELETE FROM ifServices WHERE status = 'D' "
						+ "AND nodeid = ? AND ipAddr = ? AND serviceID = ?";
				B06AgzFn = M0kONmUL.prepareStatement(IIDp8LqT);
				JinjmNay.watch(B06AgzFn);
				B06AgzFn.setInt(1, m_nodeId);
				B06AgzFn.setString(2, m_ipAddr.getHostAddress());
				B06AgzFn.setInt(3, m_serviceId);
				TnS0JsFC = B06AgzFn.executeUpdate();
				TnS0JsFC = bcj5wPZ0.executeUpdate();
			}
			log().debug("insert(): SQL update result = " + TnS0JsFC);
		} finally {
			JinjmNay.cleanUp();
		}
		m_fromDb = true;
		m_changed = 0;
	}

}