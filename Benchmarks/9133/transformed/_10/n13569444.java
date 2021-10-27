class n13569444 {
	private static String readURL(URL url) throws IOException {
		StringBuffer s = new StringBuffer();
		BufferedReader in = null;
		try {
			String str;
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((str = in.readLine()) != null) {
				s.append(str);
			}
		} finally {
			if (in != null)
				in.close();
		}
		return s.toString();
	}

}