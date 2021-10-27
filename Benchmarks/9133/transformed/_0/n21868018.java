class n21868018 {
	public void process() throws Exception {
		String L4fkHR1g = FileUtils.readFileToString(new File(getSearchRequestRelativeFilePath()));
		Map<String, String> mjr2n1Gl = new HashMap<String, String>();
		mjr2n1Gl.put("searchXML", L4fkHR1g);
		String ZdSGEwJr = null;
		int LBw0F6WE = -1;
		String GGEryKSQ = null;
		String m3JYKDBs = null;
		FileOutputStream ph6re54h = null;
		if (getUseProxy()) {
			GGEryKSQ = getServerUserName();
			m3JYKDBs = getServerUserPassword();
		}
		if (getUseProxy()) {
			ZdSGEwJr = getProxyHost();
			LBw0F6WE = getProxyPort();
		}
		try {
			InputStream oBar0VP5 = URLUtils.getHttpResponse(getSearchBaseURL(), GGEryKSQ, m3JYKDBs,
					URLUtils.HTTP_POST_METHOD, ZdSGEwJr, LBw0F6WE, mjr2n1Gl, -1);
			ph6re54h = new FileOutputStream(getSearchResponseRelativeFilePath());
			IOUtils.copyLarge(oBar0VP5, ph6re54h);
		} finally {
			if (null != ph6re54h) {
				ph6re54h.flush();
				ph6re54h.close();
			}
		}
	}

}