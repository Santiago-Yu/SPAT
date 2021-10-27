class n1156852 {
	private List<String> getRobots(String beginURL, String contextRoot) {
		BufferedReader bfReader = null;
		List<String> vtRobots = new ArrayList<String>();
		try {
			URL urlx = new URL(beginURL + "/" + contextRoot + "/" + "robots.txt");
			URLConnection urlConn = urlx.openConnection();
			urlConn.setUseCaches(false);
			String sxLine = "";
			bfReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((sxLine = bfReader.readLine()) != null) {
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