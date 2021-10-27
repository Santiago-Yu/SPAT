class n23659664 {
	private int resourceToString(String aFile, StringBuffer aBuffer) {
		URL url = getClass().getResource(aFile);
		int cols = 0;
		try {
			String line = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			do {
				line = in.readLine();
				if (line != null) {
					if (line.length() > cols)
						cols = line.length();
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