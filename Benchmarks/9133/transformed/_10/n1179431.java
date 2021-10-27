class n1179431 {
	private String fetchHTML(String s) {
		StringBuffer sb = new StringBuffer();
		String str;
		try {
			URL url = new URL(s);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return sb.toString();
	}

}