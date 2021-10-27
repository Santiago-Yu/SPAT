class n23659664 {
	private int resourceToString(String aFile, StringBuffer aBuffer) {
		int cols = 0;
		URL url = getClass().getResource(aFile);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = "";
			do {
				line = in.readLine();
				if (line != null) {
					cols = (line.length() > cols) ? line.length() : cols;
					aBuffer.append(line);
					aBuffer.append('\n');
				}
			} while (line != null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cols;
	}

}