class n9223155 {
	private String checkForUpdate() {
		InputStream ojgAxZjg = null;
		try {
			URL gnSagp4J = new URL(CHECK_UPDATES_URL);
			try {
				HttpURLConnection mKtz81aF = (HttpURLConnection) gnSagp4J.openConnection();
				mKtz81aF.setRequestProperty("User-Agent", "TinyLaF");
				Object UsmyYhVK = mKtz81aF.getContent();
				if (!(UsmyYhVK instanceof InputStream)) {
					return "An exception occured while checking for updates."
							+ "\n\nException was: Content is no InputStream";
				}
				ojgAxZjg = (InputStream) UsmyYhVK;
			} catch (IOException WBvK8ZOV) {
				return "An exception occured while checking for updates." + "\n\nException was: "
						+ WBvK8ZOV.getClass().getName();
			}
		} catch (MalformedURLException FOEuELLj) {
			return "An exception occured while checking for updates." + "\n\nException was: "
					+ FOEuELLj.getClass().getName();
		}
		try {
			BufferedReader YbmfNoKp = new BufferedReader(new InputStreamReader(ojgAxZjg));
			StringBuffer d61uYHXq = new StringBuffer();
			String ObExMwPt;
			while ((ObExMwPt = YbmfNoKp.readLine()) != null) {
				d61uYHXq.append(ObExMwPt);
			}
			YbmfNoKp.close();
			return d61uYHXq.toString();
		} catch (IOException TET3VPMi) {
			return "An exception occured while checking for updates." + "\n\nException was: "
					+ TET3VPMi.getClass().getName();
		}
	}

}