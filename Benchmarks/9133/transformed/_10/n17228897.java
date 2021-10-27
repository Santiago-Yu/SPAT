class n17228897 {
	public static boolean doPost(String urlString, Map<String, String> nameValuePairs) throws IOException {
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		boolean first = true;
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		for (Map.Entry<String, String> pair : nameValuePairs.entrySet()) {
			if (first)
				first = false;
			else
				out.print('&');
			String name = pair.getKey();
			String value = pair.getValue();
			out.print(name);
			out.print('=');
			out.print(URLEncoder.encode(value, "UTF-8"));
		}
		out.close();
		StringBuilder response = new StringBuilder();
		Scanner in;
		try {
			in = new Scanner(conn.getInputStream());
		} catch (IOException ex) {
			if (!(conn instanceof HttpURLConnection))
				throw ex;
			InputStream err = ((HttpURLConnection) conn).getErrorStream();
			in = new Scanner(err);
		}
		while (in.hasNextLine()) {
			response.append(in.nextLine());
			response.append("\n");
		}
		in.close();
		return true;
	}

}