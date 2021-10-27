class n9450274 {
	public void seeURLConnection() throws Exception {
		URL FTC1ZSIO = new URL("http://wantmeet.iptime.org");
		URLConnection vGICZjtx = FTC1ZSIO.openConnection();
		BufferedReader HkRMVmRI = new BufferedReader(new InputStreamReader(vGICZjtx.getInputStream()));
		String b6nDyEgf = null;
		StringBuffer PgpgF5cw = new StringBuffer();
		while ((b6nDyEgf = HkRMVmRI.readLine()) != null) {
			PgpgF5cw.append(b6nDyEgf);
		}
		HkRMVmRI.close();
		log.debug("sb=[" + PgpgF5cw.toString() + "]");
	}

}