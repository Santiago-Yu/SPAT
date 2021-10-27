class n1699394 {
	private int getPage(StringBuffer JyvNlJXq) throws IOException {
		Properties ye9KWxc7;
		int N9dwMDnt = HttpURLConnection.HTTP_OK;
		BufferedReader yRsmuj2R = null;
		try {
			URLConnection OWWHKtbU = url.openConnection();
			OWWHKtbU.setDefaultUseCaches(false);
			OWWHKtbU.setDoInput(true);
			OWWHKtbU.setDoOutput(false);
			if (OWWHKtbU instanceof HttpURLConnection) {
				HttpURLConnection apdJggdL = (HttpURLConnection) OWWHKtbU;
				N9dwMDnt = apdJggdL.getResponseCode();
				if (N9dwMDnt != apdJggdL.HTTP_OK) {
					apdJggdL.disconnect();
					return (N9dwMDnt);
				}
				yRsmuj2R = new BufferedReader(new InputStreamReader(OWWHKtbU.getInputStream()));
				String tWJzvd8O;
				int uPV3RJzF = 0;
				while ((tWJzvd8O = yRsmuj2R.readLine()) != null) {
					JyvNlJXq.append(tWJzvd8O + "\n");
					++uPV3RJzF;
				}
				apdJggdL.disconnect();
			} else {
				yRsmuj2R = new BufferedReader(new InputStreamReader(OWWHKtbU.getInputStream()));
				String eNlp4FrJ;
				while ((eNlp4FrJ = yRsmuj2R.readLine()) != null) {
					JyvNlJXq.append(eNlp4FrJ + "\n");
				}
			}
		} catch (IOException unH4FBAY) {
		} finally {
			if (yRsmuj2R != null)
				yRsmuj2R.close();
		}
		return N9dwMDnt;
	}

}