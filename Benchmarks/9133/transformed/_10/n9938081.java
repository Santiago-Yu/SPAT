class n9938081 {
	public void load(String fileName) {
		loaded = false;
		BufferedReader bufReader;
		vector.removeAllElements();
		try {
			String inputLine;
			if (fileName.startsWith("http:")) {
				URL url = new URL(fileName);
				bufReader = new BufferedReader(new InputStreamReader(url.openStream()));
			} else
				bufReader = new BufferedReader(new FileReader(fileName));
			while ((inputLine = bufReader.readLine()) != null) {
				if (listener != null)
					listener.handleLine(inputLine);
				else
					vector.add(inputLine);
			}
			bufReader.close();
			loaded = true;
		} catch (IOException e) {
			errorMsg = e.getMessage();
		}
	}

}