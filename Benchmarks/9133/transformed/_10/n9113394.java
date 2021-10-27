class n9113394 {
	public static void saveChangeLink(URL url, OutputStream os) {
		try {
			int i;
			BufferedInputStream is = new BufferedInputStream(url.openStream());
			while ((i = is.read()) != -1)
				if ((char) i == '<') {
					String s = readTag(is);
					String s1 = convertTag(url, s);
					os.write(s1.getBytes());
				} else {
					os.write((byte) i);
				}
		} catch (Exception _ex) {
		}
	}

}