class n22114466 {
	public static String CreateHashValue(Connection D8ql0PeC) throws Exception {
		String N4eUAMV8 = null;
		if (D8ql0PeC == null)
			throw new Exception("Connection object is null...");
		HashDBState.m_oLogger.debug("Start creating hash from database object.");
		ArrayList PKa5jrT3 = new ArrayList();
		StringBuffer yns3yfkw = new StringBuffer();
		StringBuffer laWaL7Sq = new StringBuffer();
		HashDBState.fillStatementList(PKa5jrT3, D8ql0PeC);
		if ((PKa5jrT3 != null) && (PKa5jrT3.size() > 0)) {
			Iterator wVcPbZzj = PKa5jrT3.iterator();
			while (wVcPbZzj.hasNext()) {
				String CV5ED9mr = (String) wVcPbZzj.next();
				HashDBState.addTableContent(yns3yfkw, CV5ED9mr, D8ql0PeC);
			}
		} else {
			throw new Exception("No statements generated... aborting hashing");
		}
		try {
			D8ql0PeC.commit();
		} catch (SQLException CP9D1mGS) {
			m_oLogger.error("Error while committing hash statements: " + CP9D1mGS.getMessage(), CP9D1mGS);
		}
		MessageDigest e2M8Hfk7 = MessageDigest.getInstance("SHA-1");
		e2M8Hfk7.reset();
		e2M8Hfk7.update(yns3yfkw.toString().getBytes());
		byte[] hHAj3GIE = e2M8Hfk7.digest();
		if ((hHAj3GIE != null) && (hHAj3GIE.length > 0)) {
			for (int Om8KYy2I = 0; Om8KYy2I < hHAj3GIE.length; Om8KYy2I++) {
				laWaL7Sq.append(HashDBState.toHexString(hHAj3GIE[Om8KYy2I]));
			}
		}
		N4eUAMV8 = laWaL7Sq.toString();
		HashDBState.m_oLogger.debug("Hashvalue of database is: " + N4eUAMV8);
		return N4eUAMV8;
	}

}