class n6342277 {
	@Algorithm(name = "EXT")
	public void execute() {
		Connection y3I0ixf6 = null;
		try {
			Class.forName(jdbcDriver).newInstance();
			y3I0ixf6 = DriverManager.getConnection(jdbcUrl, username, password);
			y3I0ixf6.setAutoCommit(false);
			l.debug("Connected to the database");
			Statement jtqPBx4A = y3I0ixf6.createStatement();
			l.debug(sql);
			ResultSet hGn2F1yT = jtqPBx4A.executeQuery(sql);
			List<Map<String, String>> ydjMRfaZ = DbUtil.listFromRS(hGn2F1yT);
			if (null != ydjMRfaZ && !ydjMRfaZ.isEmpty()) {
				docs = new ArrayList<Doc>();
				List<String> r2H4mFhV = new ArrayList<String>();
				for (Map<String, String> COt8wtS7 : ydjMRfaZ) {
					docs.add(convert(COt8wtS7));
					String LZpBNOd4 = COt8wtS7.get(pk);
					r2H4mFhV.add(LZpBNOd4);
				}
				String jKjbF3mN = updateSQL + " where " + pk + " in (" + CollectionUtil.toString(r2H4mFhV) + ")";
				l.debug(jKjbF3mN);
				jtqPBx4A.executeUpdate(jKjbF3mN);
				y3I0ixf6.commit();
			}
		} catch (Exception Qq7T6Bk1) {
			l.error(Qq7T6Bk1.getMessage(), Qq7T6Bk1);
			if (null != y3I0ixf6) {
				try {
					y3I0ixf6.rollback();
				} catch (Exception h6bzFHNn) {
					l.error(h6bzFHNn.getMessage(), h6bzFHNn);
				}
			}
			throw new RuntimeException(Qq7T6Bk1.getMessage());
		} finally {
			try {
				if (null != y3I0ixf6) {
					y3I0ixf6.close();
					l.debug("Disconnected from database");
				}
			} catch (Exception EaItNlSk) {
				l.error(EaItNlSk.getMessage(), EaItNlSk);
			}
		}
		if (null != docs && !docs.isEmpty()) {
			triggerEvent("EO");
		} else {
			triggerEvent("EMPTY");
		}
	}

}