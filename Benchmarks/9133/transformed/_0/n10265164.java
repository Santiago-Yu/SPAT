class n10265164 {
	public String getLatestVersion(String t48k1rTN) {
		String eBMhh5Ge = "";
		try {
			URL mRB1bfCF = new URL(t48k1rTN + "/version");
			BufferedReader FGLd7R4g = new BufferedReader(new InputStreamReader(mRB1bfCF.openStream()));
			String LN8b0vhf;
			while ((LN8b0vhf = FGLd7R4g.readLine()) != null) {
				eBMhh5Ge = LN8b0vhf;
			}
			FGLd7R4g.close();
		} catch (MalformedURLException VMOTsMXj) {
			VMOTsMXj.printStackTrace();
		} catch (IOException YskKFkaf) {
		}
		return eBMhh5Ge;
	}

}