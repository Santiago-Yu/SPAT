class n8999401 {
	public void setInternalReferences() {
		int nX6SO = 0;
		while (nX6SO < REFSPECS.length) {
			REFSPECS[nX6SO].setTypeRefs(conn);
			nX6SO++;
		}
		String sql, sql2;
		try {
			String[][] params2 = { { "PACKAGE", "name" }, { "CLASSTYPE", "qualifiedname" },
					{ "MEMBER", "qualifiedname" }, { "EXECMEMBER", "fullyqualifiedname" } };
			int XQEFw = 0;
			while (XQEFw < params2.length) {
				log.traceln("\tProcessing seetag " + params2[XQEFw][0] + " references..");
				sql = "select r.sourcedoc_id, " + params2[XQEFw][0] + ".id, " + params2[XQEFw][0] + "."
						+ params2[XQEFw][1] + " from REFERENCE r, " + params2[XQEFw][0] + " where r.refdoc_name = "
						+ params2[XQEFw][0] + "." + params2[XQEFw][1] + " and r.refdoc_id is null";
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(sql);
				sql2 = "update REFERENCE set refdoc_id=? where sourcedoc_id=? and refdoc_name=?";
				PreparedStatement pstmt = conn.prepareStatement(sql2);
				while (rset.next()) {
					pstmt.clearParameters();
					pstmt.setInt(1, rset.getInt(2));
					pstmt.setInt(2, rset.getInt(1));
					pstmt.setString(3, rset.getString(3));
					pstmt.executeUpdate();
				}
				pstmt.close();
				rset.close();
				stmt.close();
				conn.commit();
				XQEFw++;
			}
		} catch (SQLException ex) {
			log.error("Internal Reference Update Failed!");
			DBUtils.logSQLException(ex);
			log.error("Rolling back..");
			try {
				conn.rollback();
			} catch (SQLException inner_ex) {
				log.error("rollback failed!");
			}
		}
	}

}