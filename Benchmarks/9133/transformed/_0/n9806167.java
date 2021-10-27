class n9806167 {
	private ArrayList<IdLocation> doGet(String YDQyjpiu) throws IdLocatorException {
		String LowrlC06 = baseurl.toString() + "?url_ver=Z39.88-2004&rft_id=" + YDQyjpiu;
		URL axQAMXFz;
		SRUSearchRetrieveResponse AzqZkTlE;
		try {
			axQAMXFz = new URL(LowrlC06);
			HttpURLConnection WzPUNAWN = (HttpURLConnection) (axQAMXFz.openConnection());
			int usoE1mUb = WzPUNAWN.getResponseCode();
			if (usoE1mUb == 200) {
				AzqZkTlE = SRUSearchRetrieveResponse.read(WzPUNAWN.getInputStream());
			} else
				throw new IdLocatorException("cannot get " + axQAMXFz.toString());
		} catch (MalformedURLException QkQVECbQ) {
			throw new IdLocatorException("A MalformedURLException occurred for " + LowrlC06);
		} catch (IOException yOuTjpKk) {
			throw new IdLocatorException("An IOException occurred attempting to connect to " + LowrlC06);
		} catch (SRUException RorxQDq5) {
			throw new IdLocatorException("An SRUException occurred attempting to parse the response");
		}
		ArrayList<IdLocation> u746fDJj = new ArrayList<IdLocation>();
		for (SRUDC oUwLv5el : AzqZkTlE.getRecords()) {
			IdLocation bpLYzomt = new IdLocation();
			bpLYzomt.setId(oUwLv5el.getKeys(SRUDC.Key.IDENTIFIER).firstElement());
			bpLYzomt.setRepo(oUwLv5el.getKeys(SRUDC.Key.SOURCE).firstElement());
			bpLYzomt.setDate(oUwLv5el.getKeys(SRUDC.Key.DATE).firstElement());
			u746fDJj.add(bpLYzomt);
		}
		Collections.sort(u746fDJj);
		return u746fDJj;
	}

}