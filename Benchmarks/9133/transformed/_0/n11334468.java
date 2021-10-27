class n11334468 {
	public final int wordFrequency(String tz9ZvGhf) {
		String Py1pePlJ = webQuery.replaceFirst("WORDREPLACE", tz9ZvGhf);
		try {
			URL FtPPvMyl = new URL(Py1pePlJ);
			String LdW4gioP = FtPPvMyl.toString();
			BufferedReader qsCYUcH6 = new BufferedReader(new InputStreamReader(FtPPvMyl.openStream()));
			String eLA88nr9;
			while ((eLA88nr9 = qsCYUcH6.readLine()) != null) {
				if (eLA88nr9.matches(nrResultsPattern)) {
					int yN83QJTA = matchedLine(eLA88nr9);
					if (yN83QJTA >= 0) {
						return yN83QJTA;
					}
				}
			}
		} catch (MalformedURLException ProxU14U) {
			ProxU14U.printStackTrace();
		} catch (IOException bVBEvN7T) {
			bVBEvN7T.printStackTrace();
		}
		return 0;
	}

}