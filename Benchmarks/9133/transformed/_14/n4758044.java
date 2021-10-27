class n4758044 {
	private static void readServicesFromUrl(Collection<String> list, URL url) throws IOException {
		InputStream in = url.openStream();
		try {
			if (null == in)
				return;
			BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			while (true) {
				String line = r.readLine();
				if (null == line)
					break;
				int idx = line.indexOf('#');
				if (idx != -1)
					line = line.substring(0, idx);
				line = line.trim();
				if (0 == line.length())
					continue;
				list.add(line);
			}
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Throwable ignore) {
			}
		}
	}

}