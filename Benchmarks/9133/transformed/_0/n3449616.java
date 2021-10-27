class n3449616 {
	public ProgramMessageSymbol deleteProgramMessageSymbol(int WfKZ8AtN) throws AdaptationException {
		ProgramMessageSymbol YD2Uzwqm = null;
		Connection bHZrwBYq = null;
		Statement KNqBLv31 = null;
		ResultSet WRDDkt7W = null;
		try {
			String Ov125Edz = "SELECT * FROM ProgramMessageSymbols " + "WHERE id = " + WfKZ8AtN;
			bHZrwBYq = DriverManager.getConnection(CONN_STR);
			KNqBLv31 = bHZrwBYq.createStatement();
			WRDDkt7W = KNqBLv31.executeQuery(Ov125Edz);
			if (!WRDDkt7W.next()) {
				String BNAoNb4I = "Attempt to delete program message type " + "failed.";
				log.error(BNAoNb4I);
				;
				throw new AdaptationException(BNAoNb4I);
			}
			YD2Uzwqm = getProgramMessageSymbol(WRDDkt7W);
			Ov125Edz = "DELETE FROM ProgramMessageSymbols " + "WHERE id = " + WfKZ8AtN;
			KNqBLv31.executeUpdate(Ov125Edz);
			bHZrwBYq.commit();
		} catch (SQLException T2PDoLdw) {
			try {
				bHZrwBYq.rollback();
			} catch (Exception xcFVaJsQ) {
			}
			String WnONF3n8 = "SQLException in deleteProgramMessageSymbol";
			log.error(WnONF3n8, T2PDoLdw);
			throw new AdaptationException(WnONF3n8, T2PDoLdw);
		} finally {
			try {
				WRDDkt7W.close();
			} catch (Exception tS4x1jOm) {
			}
			try {
				KNqBLv31.close();
			} catch (Exception H9GAetE9) {
			}
			try {
				bHZrwBYq.close();
			} catch (Exception ghf0amG0) {
			}
		}
		return YD2Uzwqm;
	}

}