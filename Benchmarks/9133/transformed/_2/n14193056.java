class n14193056 {
	public static String readFromURL(String url_) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(url_);
			System.setProperty("http.agent", "");
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			connection.setDoInput(true);
			InputStream inStream = connection.getInputStream();
			BufferedReader input = new BufferedReader(new InputStreamReader(inStream, "utf8"));
			String line = "";
			for (; (line = input.readLine()) != null;) {
				buffer.append(line + "\n");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return buffer.toString();
	}

}