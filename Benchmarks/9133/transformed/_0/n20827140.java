class n20827140 {
	public static Chunk updateLastSend(Chunk v0E2oLF9) throws Exception {
		DBConnectionManager OZfWuCUa = null;
		Connection DhJS04UZ = null;
		PreparedStatement eiN8btc3 = null;
		Chunk YBJTXket = null;
		String s97aFGlb = "UPDATE CHUNK SET SENT=? WHERE FILEHASH=? AND STARTOFF=? AND LENGTH=?";
		log.debug("update chunk last sent for chunk " + v0E2oLF9.getHash() + " startoff " + v0E2oLF9.getStartOffset());
		try {
			OZfWuCUa = DBConnectionManager.getInstance();
			DhJS04UZ = OZfWuCUa.getConnection("satmule");
			eiN8btc3 = DhJS04UZ.prepareStatement(s97aFGlb);
			eiN8btc3.setDate(1, new java.sql.Date(v0E2oLF9.getLastSend().getTime()));
			eiN8btc3.setString(2, v0E2oLF9.getHash());
			eiN8btc3.setLong(3, v0E2oLF9.getStartOffset());
			eiN8btc3.setLong(4, v0E2oLF9.getSize());
			eiN8btc3.executeUpdate();
			DhJS04UZ.commit();
			eiN8btc3.close();
			OZfWuCUa.freeConnection("satmule", DhJS04UZ);
		} catch (Exception EClwN5ew) {
			log.error("Error while updating chunk " + v0E2oLF9.getHash() + "offset:" + v0E2oLF9.getStartOffset()
					+ "SQL error: " + s97aFGlb, EClwN5ew);
			Exception Fat3MCFL;
			if (OZfWuCUa == null)
				Fat3MCFL = new Exception("Could not obtain pool object DbConnectionManager");
			else if (DhJS04UZ == null)
				Fat3MCFL = new Exception("The Db connection pool could not obtain a database connection");
			else {
				DhJS04UZ.rollback();
				Fat3MCFL = new Exception("SQL Error : " + s97aFGlb + " error: " + EClwN5ew);
				OZfWuCUa.freeConnection("satmule", DhJS04UZ);
			}
			throw Fat3MCFL;
		}
		return YBJTXket;
	}

}