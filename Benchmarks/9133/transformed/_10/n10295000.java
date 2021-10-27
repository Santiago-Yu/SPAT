class n10295000 {
	public static String getByUrl(String urlStr, String para) {
		StringBuffer html = new StringBuffer("");
		URL url;
		try {
			url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");
			out.write(para);
			out.flush();
			out.close();
			System.out.println("para:" + para);
			InputStream is = url.openStream();
			String line = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			line = br.readLine();
			while (line != null) {
				html.append(line + "\n");
				line = br.readLine();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html.toString();
	}

}