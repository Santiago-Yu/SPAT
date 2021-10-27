class n1371265 {
	public void update(String channelPath, String dataField, String fatherDocId) {
		String sqlInitial = "select uri from t_ip_doc_res where doc_id = '" + fatherDocId + "' and type=" + " '"
				+ ces.platform.infoplat.core.DocResource.DOC_MAGAZINE_TYPE + "' ";
		Connection conn = null;
		String sqlsortURL = "update t_ip_doc_res set uri = ? where doc_id = '" + fatherDocId + "' " + " and type = '"
				+ ces.platform.infoplat.core.DocResource.DOC_MAGAZINE_TYPE + "' ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String url = "";
			dbo = (ERDBOperation) createDBOperation();
			StringTokenizer st = null;
			boolean flag = true;
			conn = dbo.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sqlInitial);
			rs = ps.executeQuery();
			if (rs.next())
				url = rs.getString(1);
			if (!url.equals("")) {
				String sortDocId = "";
				st = new StringTokenizer(url, ",");
				while (st.hasMoreTokens()) {
					if (flag) {
						flag = false;
						sortDocId = "'" + st.nextToken() + "'";
					} else {
						sortDocId = sortDocId + "," + "'" + st.nextToken() + "'";
					}
				}
				String sqlsort = "select id from t_ip_doc where id in (" + sortDocId + ") order by " + dataField;
				ps = conn.prepareStatement(sqlsort);
				String sortURL = "";
				rs = ps.executeQuery();
				boolean sortflag = true;
				while (rs.next()) {
					if (sortflag) {
						sortflag = false;
						sortURL = rs.getString(1);
					} else {
						sortURL = sortURL + "," + rs.getString(1);
					}
				}
				ps = conn.prepareStatement(sqlsortURL);
				ps.setString(1, sortURL);
				ps.executeUpdate();
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			close(rs, null, ps, conn, dbo);
		}
	}

}