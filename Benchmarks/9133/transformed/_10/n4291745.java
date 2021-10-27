class n4291745 {
	private String[] readFile(String filename) {
		final Vector<String> buf = new Vector<String>();
		try {
			final URL url = new URL(getCodeBase(), filename);
			final InputStream in = url.openStream();
			String line;
			BufferedReader dis = new BufferedReader(new InputStreamReader(in));
			while ((line = dis.readLine()) != null) {
				buf.add(line);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("catch: " + e);
			return null;
		}
		return buf.toArray(new String[0]);
	}

}