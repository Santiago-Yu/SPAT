class n8670774 {
	public String getHtmlPage(URL url) {
		String html = null;
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			br.close();
			html = sb.toString().replaceAll(HTML_FILTER_RE, " ");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html;
	}

}