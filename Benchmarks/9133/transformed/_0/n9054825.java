class n9054825 {
	public List<BadassEntry> parse() {
		mBadassEntries = new ArrayList<BadassEntry>();
		try {
			URL fqaFUpTi = new URL(mUrl);
			HttpURLConnection KgLItwgw = (HttpURLConnection) fqaFUpTi.openConnection();
			KgLItwgw.setRequestMethod("GET");
			KgLItwgw.setDoOutput(true);
			KgLItwgw.connect();
			BufferedReader GoTX3uRj = new BufferedReader(new InputStreamReader(KgLItwgw.getInputStream()));
			String RfWRkKSp;
			boolean FzZHAVGp = false;
			while ((RfWRkKSp = GoTX3uRj.readLine()) != null) {
				RfWRkKSp = RfWRkKSp.trim();
				if (!FzZHAVGp && RfWRkKSp.contains(START_PARSE))
					FzZHAVGp = true;
				if (FzZHAVGp && RfWRkKSp.contains(STOP_PARSE))
					break;
				if (FzZHAVGp) {
					if (RfWRkKSp.contains(ENTRY_HINT)) {
						parseBadass(RfWRkKSp);
					}
				}
			}
		} catch (MalformedURLException VsIDBZC5) {
			VsIDBZC5.printStackTrace();
		} catch (IOException LNFtmomu) {
			LNFtmomu.printStackTrace();
		}
		return mBadassEntries;
	}

}