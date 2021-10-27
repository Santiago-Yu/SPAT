class n10115624 {
	public void registerSchema(String RQulBNoy, String SI6ygyUv, long TL8pqIql, String KxqECJAM, String A2MeGDZ8)
			throws SQLException {
		Connection IRvdg2yc = null;
		PreparedStatement Zki6tZKe = null;
		try {
			IRvdg2yc = this.getRepositoryConnection(p_ctx.getApplication(), "default", 2);
			String LcsH4RPi = MessageLocalizer.getMessage("SCHEMA_CREATED_BY_OBJECT") + " [" + SI6ygyUv + "] "
					+ MessageLocalizer.getMessage("WITH_BOUI") + " [" + TL8pqIql + "]";
			Zki6tZKe = IRvdg2yc.prepareStatement("DELETE FROM NGTDIC WHERE TABLENAME=? and objecttype='S'");
			Zki6tZKe.setString(1, RQulBNoy);
			Zki6tZKe.executeUpdate();
			Zki6tZKe.close();
			Zki6tZKe = IRvdg2yc.prepareStatement("INSERT INTO NGTDIC (SCHEMA,OBJECTNAME,OBJECTTYPE,TABLENAME, "
					+ "FRIENDLYNAME, EXPRESSION) VALUES (" + "?,?,?,?,?,?)");
			Zki6tZKe.setString(1, A2MeGDZ8);
			Zki6tZKe.setString(2, RQulBNoy);
			Zki6tZKe.setString(3, "S");
			Zki6tZKe.setString(4, RQulBNoy);
			Zki6tZKe.setString(5, LcsH4RPi);
			Zki6tZKe.setString(6, KxqECJAM);
			Zki6tZKe.executeUpdate();
			Zki6tZKe.close();
			IRvdg2yc.commit();
		} catch (Exception P1CEdaSR) {
			IRvdg2yc.rollback();
			P1CEdaSR.printStackTrace();
			throw new SQLException(P1CEdaSR.getMessage());
		} finally {
			if (Zki6tZKe != null) {
				try {
					Zki6tZKe.close();
				} catch (Exception GYwqGTwh) {
				}
			}
		}
	}

}