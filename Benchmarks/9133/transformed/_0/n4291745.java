class n4291745 {
	private String[] readFile(String HgDgaPJk) {
		final Vector<String> yS3JgELg = new Vector<String>();
		try {
			final URL sDSFrSYx = new URL(getCodeBase(), HgDgaPJk);
			final InputStream SxYzRdfF = sDSFrSYx.openStream();
			BufferedReader ZjPtX4DO = new BufferedReader(new InputStreamReader(SxYzRdfF));
			String eHonDePd;
			while ((eHonDePd = ZjPtX4DO.readLine()) != null) {
				yS3JgELg.add(eHonDePd);
			}
			SxYzRdfF.close();
		} catch (IOException MK9iwf59) {
			System.out.println("catch: " + MK9iwf59);
			return null;
		}
		return yS3JgELg.toArray(new String[0]);
	}

}