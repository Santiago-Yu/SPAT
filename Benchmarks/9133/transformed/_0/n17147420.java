class n17147420 {
	public final String latestVersion() {
		String oYlzbVDh = "";
		try {
			URL GnmIl0Iv = new URL(Constants.officialSite + ":80/LatestVersion");
			BufferedReader SdfvdUga = new BufferedReader(new InputStreamReader(GnmIl0Iv.openStream()));
			String jSFXjz0Z;
			while ((jSFXjz0Z = SdfvdUga.readLine()) != null) {
				oYlzbVDh = jSFXjz0Z;
			}
			SdfvdUga.close();
		} catch (MalformedURLException UZU6z7s9) {
		} catch (IOException VbmUmUNq) {
		}
		return oYlzbVDh;
	}

}