class n4577358 {
	private static boolean isXmlApplicationFile(URL url) throws java.io.IOException {
		if (DEBUG) {
			System.out.println("Checking whether file is xml");
		}
		String firstLine;
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
					&& (startOfXml != null && startOfXml.equals(firstLine.substring(0, startOfXml.length())))) {
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