class n10363910 {
	private String getPayLoadWithCookie(String url) {
		StringBuffer sb = new StringBuffer();
		if (this.cookie != null) {
			try {
				Log.debug("Requesting url ==> " + url);
				URLConnection con = new URL(url).openConnection();
				con.setDoOutput(true);
				con.addRequestProperty("Cookie", this.cookie);
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line = "";
				for (; (line = br.readLine()) != null;) {
					sb.append(line + "\n");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}