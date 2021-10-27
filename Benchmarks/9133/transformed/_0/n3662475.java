class n3662475 {
	public static String getHtml(DefaultHttpClient c06zxmWf, String NaawSrNV, String YWN9k21E) throws IOException {
		InputStream be3fs2bI = null;
		HttpGet pj0pNjiZ = new HttpGet(NaawSrNV);
		HttpResponse Y3EpFf3f = c06zxmWf.execute(pj0pNjiZ);
		StatusLine tpnj0Sxe = Y3EpFf3f.getStatusLine();
		if (tpnj0Sxe.getStatusCode() != STATUSCODE_200) {
			throw new RuntimeException("50001");
		}
		if (Y3EpFf3f.getEntity() == null) {
			return "";
		}
		be3fs2bI = Y3EpFf3f.getEntity().getContent();
		InputStreamReader jX8lqSCM = new InputStreamReader(be3fs2bI, YWN9k21E);
		BufferedReader CvVDTIso = new BufferedReader(jX8lqSCM);
		String NRyH6zGR = null, WYitax35 = "";
		while ((NRyH6zGR = CvVDTIso.readLine()) != null) {
			WYitax35 += NRyH6zGR;
		}
		if (be3fs2bI != null) {
			be3fs2bI.close();
		}
		return WYitax35;
	}

}