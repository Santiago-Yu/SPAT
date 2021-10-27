class n13821141 {
	public static String readUrlText(String urlString) throws IOException {
		URL url = new URL(urlString);
		StringBuilder buf = new StringBuilder();
		InputStream stream = url.openStream();
		BufferedReader in = null;
		try {
			String str;
			in = new BufferedReader(new InputStreamReader(stream));
			while ((str = in.readLine()) != null) {
				buf.append(str);
				buf.append(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			System.out.println("Error reading text from URL [" + url + "]: " + e.toString());
			throw e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("Error closing after reading text from URL [" + url + "]: " + e.toString());
				}
			}
		}
		return buf.toString();
	}

}