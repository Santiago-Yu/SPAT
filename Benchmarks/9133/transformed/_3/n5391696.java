class n5391696 {
	public static StringBuffer getCachedFile(String url) throws Exception {
		File urlCache = new File("tmp-cache/" + url.replace('/', '-'));
		new File("tmp-cache/").mkdir();
		if (!(urlCache.exists())) {
			URL url2 = new URL(url.replace(" ", "%20"));
			BufferedReader in = new BufferedReader(new InputStreamReader(url2.openStream()));
			BufferedWriter cacheWriter = new BufferedWriter(new FileWriter(urlCache));
			StringBuffer buffer = new StringBuffer();
			String input;
			while ((input = in.readLine()) != null) {
				buffer.append(input + "\n");
				cacheWriter.write(input + "\n");
			}
			cacheWriter.close();
			in.close();
			return buffer;
		} else {
			BufferedReader in = new BufferedReader(new FileReader(urlCache));
			StringBuffer buffer = new StringBuffer();
			String input;
			while ((input = in.readLine()) != null) {
				buffer.append(input + "\n");
			}
			in.close();
			return buffer;
		}
	}

}