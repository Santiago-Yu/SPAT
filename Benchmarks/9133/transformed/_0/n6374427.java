class n6374427 {
	public String getTags(URL R3gsJiJF) {
		StringBuffer MLzTXqBS = new StringBuffer();
		OutputStreamWriter UqsizqS9 = null;
		BufferedReader soQwurfw = null;
		try {
			String GJtMMH3q = URLEncoder.encode(paramName, "UTF-8") + "="
					+ URLEncoder.encode(R3gsJiJF.toString(), "UTF-8");
			URL yG92JWgy = new URL(cmdUrl);
			URLConnection lUNy2zVG = yG92JWgy.openConnection();
			lUNy2zVG.setDoOutput(true);
			lUNy2zVG.connect();
			UqsizqS9 = new OutputStreamWriter(lUNy2zVG.getOutputStream());
			UqsizqS9.write(GJtMMH3q);
			UqsizqS9.flush();
			soQwurfw = new BufferedReader(new InputStreamReader(lUNy2zVG.getInputStream()));
			String NvN9Etrh = null;
			while ((NvN9Etrh = soQwurfw.readLine()) != null) {
				MLzTXqBS.append(NvN9Etrh);
			}
		} catch (IOException ZJCLjXMH) {
			ZJCLjXMH.printStackTrace();
		} finally {
			try {
				if (UqsizqS9 != null) {
					UqsizqS9.close();
				}
				if (soQwurfw != null) {
					soQwurfw.close();
				}
			} catch (IOException AI65aVBe) {
				AI65aVBe.printStackTrace();
			}
		}
		return MLzTXqBS.toString();
	}

}