class n9450274 {
	public void seeURLConnection() throws Exception {
		URL url = new URL("http://wantmeet.iptime.org");
		URLConnection uc = url.openConnection();
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		StringBuffer sb = new StringBuffer();
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		br.close();
		log.debug("sb=[" + sb.toString() + "]");
	}

}