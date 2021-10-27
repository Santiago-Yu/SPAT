class n844858 {
	private static String getDocumentAt(String urlString) {
		StringBuffer html_text = new StringBuffer();
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null)
				html_text.append(line + "\n");
			reader.close();
		} catch (MalformedURLException e) {
			System.out.println("??งน??URL: " + urlString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html_text.toString();
	}

}