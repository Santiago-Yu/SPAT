class n6957384 {
	public static String sendGetData(URL url, Hashtable<String, String> data) throws IOException {
		StringBuilder outStringBuilder = new StringBuilder();
		if (data != null) {
			for (Entry<String, String> entry : data.entrySet()) {
				outStringBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
				outStringBuilder.append("=");
				outStringBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
				outStringBuilder.append("&");
			}
		}
		URL innerURL = new URL(url.toString() + "?" + outStringBuilder.toString());
		System.out.println("URL: " + innerURL);
		URLConnection urlConnection = innerURL.openConnection();
		urlConnection.connect();
		StringBuilder inStringBuilder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		Scanner inputScanner = new Scanner(urlConnection.getInputStream());
		for (; inputScanner.hasNext();) {
			inStringBuilder.append(inputScanner.next() + " ");
		}
		inputScanner.close();
		reader.close();
		return inStringBuilder.toString();
	}

}