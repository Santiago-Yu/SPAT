class n13680437 {
	public static void writeFromURL(String urlstr, String filename) throws Exception {
		URL url = new URL(urlstr);
		BufferedReader bf = null;
		InputStream in = url.openStream();
		StringBuffer sb = new StringBuffer();
		try {
			String s;
			bf = new BufferedReader(new InputStreamReader(in, "latin1"));
			while (true) {
				s = bf.readLine();
				if (s != null) {
					sb.append(s);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			bf.close();
		}
		writeRawBytes(sb.toString(), filename);
	}

}