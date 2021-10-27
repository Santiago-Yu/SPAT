class n14288802 {
	static Object read(String path, String encoding, boolean return_string) throws IOException {
		InputStream in;
		if (path.startsWith("classpath:")) {
			path = path.substring("classpath:".length());
			URL url = Estimate.class.getClassLoader().getResource(path);
			if (url == null) {
				throw new IllegalArgumentException("Not found " + path + " in classpath.");
			}
			System.out.println("read content from:" + url.getFile());
			in = url.openStream();
		} else {
			File f = new File(path);
			if (!f.exists()) {
				throw new IllegalArgumentException("Not found " + path + " in system.");
			}
			System.out.println("read content from:" + f.getAbsolutePath());
			in = new FileInputStream(f);
		}
		Reader re;
		re = (encoding != null) ? new InputStreamReader(in, encoding) : new InputStreamReader(in);
		if (!return_string) {
			return re;
		}
		char[] chs = new char[1024];
		int count;
		StringBuffer content = new StringBuffer();
		while ((count = re.read(chs)) != -1) {
			content.append(chs, 0, count);
		}
		re.close();
		return content.toString();
	}

}