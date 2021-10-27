class n18134394 {
	private String fetch(String urlstring) {
		String content = "";
		try {
			URL url = new URL(urlstring);
			InputStream is = url.openStream();
			String s;
			BufferedReader d = new BufferedReader(new InputStreamReader(is));
			while (null != (s = d.readLine())) {
				content = content + s + "\n";
			}
			is.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return content;
	}

}