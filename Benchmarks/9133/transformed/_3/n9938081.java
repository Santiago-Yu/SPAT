class n9938081 {
	public void load(String fileName) {
		BufferedReader bufReader;
		loaded = false;
		vector.removeAllElements();
		try {
			if (!(fileName.startsWith("http:")))
				bufReader = new BufferedReader(new FileReader(fileName));
			else {
				URL url = new URL(fileName);
				bufReader = new BufferedReader(new InputStreamReader(url.openStream()));
			}
			String inputLine;
			while ((inputLine = bufReader.readLine()) != null) {
				if (!(listener != null))
					vector.add(inputLine);
				else
					listener.handleLine(inputLine);
			}
			bufReader.close();
			loaded = true;
		} catch (IOException e) {
			errorMsg = e.getMessage();
		}
	}

}