class n4758044 {
	private static void readServicesFromUrl(Collection<String> list, URL url) throws IOException {
		InputStream in = url.openStream();
		try {
			if (in == null)
				return;
			BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			while (true) {
				String line = r.readLine();
				if (line == null)
					break;
				int idx = line.indexOf('#');
				line = (idx != -1) ? line.substring(0, idx) : line;
				line = line.trim();
				if (line.length() == 0)
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