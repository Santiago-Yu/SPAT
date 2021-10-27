class n17228897 {
	public static boolean doPost(String urlString, Map<String, String> nameValuePairs) throws IOException {
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		boolean first = true;
		for (Map.Entry<String, String> pair : nameValuePairs.entrySet()) {
			if (!(first))
				out.print('&');
			else
				first = false;
			String name = pair.getKey();
			String value = pair.getValue();
			out.print(name);
			out.print('=');
			out.print(URLEncoder.encode(value, "UTF-8"));
		}
		out.close();
		Scanner in;
		StringBuilder response = new StringBuilder();
		try {
			in = new Scanner(conn.getInputStream());
		} catch (IOException ex) {
			if (!(!(conn instanceof HttpURLConnection)))
				;
			else
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