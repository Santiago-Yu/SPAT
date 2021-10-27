class n4577358 {
	private static boolean isXmlApplicationFile(URL url) throws java.io.IOException {
		String firstLine;
		if (DEBUG) {
			System.out.println("Checking whether file is xml");
		}
		BufferedReader fileReader = null;
		try {
			fileReader = new BomStrippingInputStreamReader(url.openStream());
			firstLine = fileReader.readLine();
		} finally {
			if (fileReader != null)
				fileReader.close();
		}
		if (firstLine == null) {
			return false;
		}
		for (String startOfXml : STARTOFXMLAPPLICATIONFILES) {
			if (firstLine.length() >= startOfXml.length()
					&& firstLine.substring(0, startOfXml.length()).equals(startOfXml)) {
				if (DEBUG) {
					System.out.println("isXMLApplicationFile = true");
				}
				return true;
			}
		}
		if (DEBUG) {
			System.out.println("isXMLApplicationFile = false");
		}
		return false;
	}

}