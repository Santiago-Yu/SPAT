class n8063675 {
	private static int ejecutaUpdate(String N5DBdbVv, String P3SYWhQQ) throws Exception {
		int u1AKUNcS = 0;
		DBConnectionManager eRTIhSXH = null;
		Connection hLrb4sJo = null;
		try {
			eRTIhSXH = DBConnectionManager.getInstance();
			hLrb4sJo = eRTIhSXH.getConnection(N5DBdbVv);
			Statement NTibiws5 = hLrb4sJo.createStatement();
			u1AKUNcS = NTibiws5.executeUpdate(P3SYWhQQ);
			hLrb4sJo.commit();
			NTibiws5.close();
			eRTIhSXH.freeConnection(N5DBdbVv, hLrb4sJo);
		} catch (Exception Zo5KDJzB) {
			log.error("SQL error: " + P3SYWhQQ, Zo5KDJzB);
			Exception tYCUa2At;
			if (eRTIhSXH == null)
				tYCUa2At = new Exception("Could not obtain pool object DbConnectionManager");
			else if (hLrb4sJo == null)
				tYCUa2At = new Exception("The Db connection pool could not obtain a database connection");
			else {
				hLrb4sJo.rollback();
				tYCUa2At = new Exception("SQL Error: " + P3SYWhQQ + " error: " + Zo5KDJzB);
				eRTIhSXH.freeConnection(N5DBdbVv, hLrb4sJo);
			}
			throw tYCUa2At;
		}
		return u1AKUNcS;
	}

}