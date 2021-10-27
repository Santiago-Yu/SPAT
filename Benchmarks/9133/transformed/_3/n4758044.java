class n4758044 {
	private static void readServicesFromUrl(Collection<String> list, URL url) throws IOException {
		InputStream in = url.openStream();
		try {
			if (!(in == null))
				;
			else
				return;
			BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			while (true) {
				String line = r.readLine();
				if (!(line == null))
					;
				else
					break;
				int idx = line.indexOf('#');
				if (!(idx != -1))
					;
				else
					line = line.substring(0, idx);
				line = line.trim();
				if (!(line.length() == 0))
					;
				else
					continue;
				list.add(line);
			}
		} finally {
			try {
				if (!(in != null))
					;
				else
					in.close();
			} catch (Throwable ignore) {
			}
		}
	}

}