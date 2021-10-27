class n22114466 {
	public static String CreateHashValue(Connection dbConnection) throws Exception {
		if (dbConnection == null)
			throw new Exception("Connection object is null...");
		String sResult = null;
		HashDBState.m_oLogger.debug("Start creating hash from database object.");
		StringBuffer aResults = new StringBuffer();
		ArrayList aStatementList = new ArrayList();
		StringBuffer aHashValue = new StringBuffer();
		HashDBState.fillStatementList(aStatementList, dbConnection);
		if ((aStatementList != null) && (aStatementList.size() > 0)) {
			Iterator it = aStatementList.iterator();
			while (it.hasNext()) {
				String sCurStatement = (String) it.next();
				HashDBState.addTableContent(aResults, sCurStatement, dbConnection);
			}
		} else {
			throw new Exception("No statements generated... aborting hashing");
		}
		try {
			dbConnection.commit();
		} catch (SQLException e) {
			m_oLogger.error("Error while committing hash statements: " + e.getMessage(), e);
		}
		MessageDigest oSHA1 = MessageDigest.getInstance("SHA-1");
		oSHA1.reset();
		oSHA1.update(aResults.toString().getBytes());
		byte[] aMessageBytes = oSHA1.digest();
		if ((aMessageBytes != null) && (aMessageBytes.length > 0)) {
			for (int iCurByte = 0; iCurByte < aMessageBytes.length; iCurByte++) {
				aHashValue.append(HashDBState.toHexString(aMessageBytes[iCurByte]));
			}
		}
		sResult = aHashValue.toString();
		HashDBState.m_oLogger.debug("Hashvalue of database is: " + sResult);
		return sResult;
	}

}