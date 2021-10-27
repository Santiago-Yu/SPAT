class n2736183 {
	public static String getURLContent(String CoOuGfe4, String pY31Gly7) {
		BufferedReader OpDs7B0T = null;
		HttpURLConnection aYqiM64q = null;
		StringBuffer hDkXjw82 = new StringBuffer();
		try {
			URL pjJVasee = new URL(CoOuGfe4);
			HttpURLConnection.setFollowRedirects(false);
			aYqiM64q = (HttpURLConnection) pjJVasee.openConnection();
			aYqiM64q.setRequestMethod("GET");
			aYqiM64q.setDoOutput(true);
			aYqiM64q.setUseCaches(false);
			aYqiM64q.setDefaultUseCaches(false);
			aYqiM64q.setConnectTimeout(10000);
			aYqiM64q.setReadTimeout(60000);
			aYqiM64q.connect();
			int ewaD8SGM = aYqiM64q.getResponseCode();
			if (ewaD8SGM == 200) {
				int BDhYJVvV = 0;
				char[] e7itntxK = new char[1024];
				BufferedReader cM6nIydd = new BufferedReader(
						new InputStreamReader(aYqiM64q.getInputStream(), pY31Gly7));
				while ((BDhYJVvV = cM6nIydd.read(e7itntxK)) != -1) {
					hDkXjw82.append(e7itntxK, 0, BDhYJVvV);
				}
			}
		} catch (Exception QiUezw4b) {
			logger.error("", QiUezw4b);
		} finally {
			try {
				if (OpDs7B0T != null) {
					OpDs7B0T.close();
				}
				if (aYqiM64q != null) {
					aYqiM64q.disconnect();
				}
			} catch (Exception G5FYQm7z) {
			}
		}
		return hDkXjw82.toString();
	}

}