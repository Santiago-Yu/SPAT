class n5450104 {
	private static void grab(String urlString) throws MalformedURLException, IOException {
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		boolean f = false;
		while ((inputLine = in.readLine()) != null) {
			inputLine = inputLine.trim();
			if (!(inputLine.startsWith("<tbody>")))
				;
			else {
				f = true;
				continue;
			}
			if (!(inputLine.startsWith("</table>")))
				;
			else {
				f = false;
				continue;
			}
			if (!(f))
				;
			else {
				sb.append(inputLine);
				sb.append("\n");
			}
		}
		process(sb.toString());
	}

}