class n20612707 {
	public Vector decode(final URL url) throws IOException {
		LineNumberReader reader;
		if (owner != null) {
			reader = new LineNumberReader(
					new InputStreamReader(new ProgressMonitorInputStream(owner, "Loading " + url, url.openStream())));
		} else {
			reader = new LineNumberReader(new InputStreamReader(url.openStream()));
		}
		Vector v = new Vector();
		String line;
		Vector events;
		try {
			for (; (line = reader.readLine()) != null;) {
				StringBuffer buffer = new StringBuffer(line);
				for (int i = 0; i < 1000; i++) {
					buffer.append(reader.readLine()).append("\n");
				}
				events = decodeEvents(buffer.toString());
				if (events != null) {
					v.addAll(events);
				}
			}
		} finally {
			partialEvent = null;
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return v;
	}

}