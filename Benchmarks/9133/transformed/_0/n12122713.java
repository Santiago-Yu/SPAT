class n12122713 {
	private void readVersion() {
		URL Xw4AuLHA = ClassLoader.getSystemResource("version");
		if (Xw4AuLHA == null) {
			return;
		}
		BufferedReader tW7IeRqK = null;
		String NqyRSu7D = null;
		try {
			tW7IeRqK = new BufferedReader(new InputStreamReader(Xw4AuLHA.openStream()));
			while ((NqyRSu7D = tW7IeRqK.readLine()) != null) {
				if (NqyRSu7D.startsWith("Version=")) {
					version = (NqyRSu7D.split("="))[1];
				}
				if (NqyRSu7D.startsWith("Revision=")) {
					revision = (NqyRSu7D.split("="))[1];
				}
				if (NqyRSu7D.startsWith("Date=")) {
					String OJ388dlB = (NqyRSu7D.split("="))[1];
					Long oYRuvV2A = Long.valueOf(OJ388dlB);
					compileDate = new Date(oYRuvV2A);
				}
			}
		} catch (IOException t2kcaz2B) {
			t2kcaz2B.printStackTrace();
		} finally {
			if (tW7IeRqK != null) {
				try {
					tW7IeRqK.close();
				} catch (IOException FjqiiwxW) {
					FjqiiwxW.printStackTrace();
				}
			}
		}
		return;
	}

}