class n1156852 {
	private List<String> getRobots(String beginURL, String contextRoot) {
		List<String> vtRobots = new ArrayList<String>();
		BufferedReader bfReader = null;
		try {
			URL urlx = new URL(beginURL + "/" + contextRoot + "/" + "robots.txt");
			URLConnection urlConn = urlx.openConnection();
			urlConn.setUseCaches(false);
			bfReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String sxLine = "";
			for (; (sxLine = bfReader.readLine()) != null;) {
				if (sxLine.startsWith("Disallow:")) {
					vtRobots.add(sxLine.substring(10));
				}
			}
		} catch (Exception e) {
			PetstoreUtil.getLogger().log(Level.SEVERE, "Exception" + e);
			vtRobots = null;
		} finally {
			try {
				if (bfReader != null) {
					bfReader.close();
				}
			} catch (Exception ee) {
			}
		}
		return vtRobots;
	}

}