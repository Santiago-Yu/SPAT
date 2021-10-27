class n3525047 {
	public static String read(URL url) throws Exception {
		boolean cached = false;
		String filename = Integer.toString(url.toString().hashCode());
		File dir = new File(Config.CACHE_PATH);
		for (File file : dir.listFiles()) {
			if (!file.isFile())
				continue;
			if (file.getName().equals(filename)) {
				cached = true;
				filename = file.getName();
				break;
			}
		}
		File file = new File(Config.CACHE_PATH, filename);
		if (Config.USE_CACHE && cached)
			return read(file);
		System.out.println(">> CACHE HIT FAILED.");
		InputStream in = null;
		try {
			in = url.openStream();
		} catch (Exception e) {
			System.out.println(">> OPEN STREAM FAILED: " + url.toString());
			return null;
		}
		String content = read(in);
		save(file, content);
		return content;
	}

}