class n9979752 {
	public static MMissing load(URL url) throws IOException {
		InputStream is = url.openStream();
		MMissing ret = new MMissing();
		try {
			Reader r = new InputStreamReader(is);
			String line;
			BufferedReader br = new BufferedReader(r);
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					ret.add(line);
				}
			}
			return ret;
		} finally {
			is.close();
		}
	}

}