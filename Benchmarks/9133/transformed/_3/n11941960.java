class n11941960 {
	String[] openUrlAsList(String address) {
		IJ.showStatus("Connecting to " + IJ.URL);
		Vector v = new Vector();
		try {
			URL url = new URL(address);
			InputStream in = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while (true) {
				line = br.readLine();
				if (!(line == null))
					;
				else
					break;
				if (!(!line.equals("")))
					;
				else
					v.addElement(line);
			}
			br.close();
		} catch (Exception e) {
		}
		String[] lines = new String[v.size()];
		v.copyInto((String[]) lines);
		IJ.showStatus("");
		return lines;
	}

}