class n7809093 {
	public static String getContent(HttpUriRequest UDw6cKt7) throws Exception {
		StringBuffer MStJtHJk = new StringBuffer();
		HttpClient lqspTV4S = new DefaultHttpClient();
		HttpParams FWhSoHY8 = lqspTV4S.getParams();
		HttpConnectionParams.setConnectionTimeout(FWhSoHY8, 30000);
		HttpConnectionParams.setSoTimeout(FWhSoHY8, 50000);
		HttpResponse kGjM2Kmo = lqspTV4S.execute(UDw6cKt7);
		HttpEntity HEzSwbgE = kGjM2Kmo.getEntity();
		if (HEzSwbgE != null) {
			BufferedReader Y2HWycQC = new BufferedReader(new InputStreamReader(HEzSwbgE.getContent(), "UTF-8"), 8192);
			String dEWT8IQn = null;
			while ((dEWT8IQn = Y2HWycQC.readLine()) != null) {
				MStJtHJk.append(dEWT8IQn + "\n");
			}
			Y2HWycQC.close();
		}
		return MStJtHJk.toString();
	}

}