class n3512882 {
	static final void executeUpdate(Collection<String> AlsEz72F, DBConnector ld5WqtZS) throws IOException {
		Connection w243Mh06 = null;
		Statement SozSbRcM = null;
		try {
			w243Mh06 = ld5WqtZS.getDB();
			w243Mh06.setAutoCommit(false);
			SozSbRcM = w243Mh06.createStatement();
			for (String R21tcAP3 : AlsEz72F)
				SozSbRcM.executeUpdate(R21tcAP3);
			w243Mh06.commit();
		} catch (SQLException exHRWD7L) {
			try {
				w243Mh06.rollback();
			} catch (SQLException ZcWPuUki) {
				ZcWPuUki.printStackTrace();
			}
			throw new IOException(exHRWD7L.getMessage());
		} finally {
			if (SozSbRcM != null) {
				try {
					SozSbRcM.close();
				} catch (SQLException Rvt3niPn) {
				}
			}
			if (w243Mh06 != null) {
				try {
					w243Mh06.close();
				} catch (SQLException EQE1hliz) {
				}
			}
		}
	}

}