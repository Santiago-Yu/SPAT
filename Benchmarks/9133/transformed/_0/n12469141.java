class n12469141 {
	public Program deleteProgram(int KomH4mB3) throws AdaptationException {
		Program aM3MX6lD = null;
		Connection Yz2lFU9E = null;
		Statement W61o415b = null;
		ResultSet ryKH6b3S = null;
		try {
			String CtBztmCw = "SELECT * FROM Programs WHERE id = " + KomH4mB3;
			Yz2lFU9E = DriverManager.getConnection(CONN_STR);
			W61o415b = Yz2lFU9E.createStatement();
			ryKH6b3S = W61o415b.executeQuery(CtBztmCw);
			if (!ryKH6b3S.next()) {
				Yz2lFU9E.rollback();
				String Q86GFKtq = "Attempt to delete program failed.";
				log.error(Q86GFKtq);
				throw new AdaptationException(Q86GFKtq);
			}
			aM3MX6lD = getProgram(ryKH6b3S);
			CtBztmCw = "DELETE FROM Programs WHERE id = " + KomH4mB3;
			W61o415b.executeUpdate(CtBztmCw);
			Yz2lFU9E.commit();
		} catch (SQLException F5BFnTNC) {
			try {
				Yz2lFU9E.rollback();
			} catch (Exception B0tRQPNo) {
			}
			String UTt6Buqt = "SQLException in deleteProgram";
			log.error(UTt6Buqt, F5BFnTNC);
			throw new AdaptationException(UTt6Buqt, F5BFnTNC);
		} finally {
			try {
				ryKH6b3S.close();
			} catch (Exception SylwiA5Y) {
			}
			try {
				W61o415b.close();
			} catch (Exception At0Pa9FZ) {
			}
			try {
				Yz2lFU9E.close();
			} catch (Exception tdWrmKB8) {
			}
		}
		return aM3MX6lD;
	}

}