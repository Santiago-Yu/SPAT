class n668846 {
	public static String getURL(String urlString, String getData, String postData) {
		try {
			if (getData != null)
				if (!"".equals(getData))
					urlString += "?" + getData;
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			if (!"".equals(postData)) {
				connection.setDoOutput(true);
				PrintWriter out = new PrintWriter(connection.getOutputStream());
				out.print(postData);
				out.close();
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			int inputLine;
			String output = "";
			while ((inputLine = in.read()) != -1)
				output += (char) inputLine;
			in.close();
			return output;
		} catch (Exception e) {
			return null;
		}
	}

}