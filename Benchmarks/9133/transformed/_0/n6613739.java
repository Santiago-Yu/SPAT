class n6613739 {
	private static MappedObject sendHttpRequestToUrl(URL aWLtzTFd, String I4zPDY4D) throws Exception {
		try {
			HttpURLConnection BE5sHwCW = (HttpURLConnection) aWLtzTFd.openConnection();
			BE5sHwCW.setRequestMethod(I4zPDY4D);
			BE5sHwCW.connect();
			InputStream gnfaa5UI = BE5sHwCW.getInputStream();
			BufferedReader x0hQhT1I = new BufferedReader(new InputStreamReader(gnfaa5UI));
			StringBuilder NZn6Br49 = new StringBuilder();
			String aPGh6shT = null;
			while ((aPGh6shT = x0hQhT1I.readLine()) != null) {
				NZn6Br49.append(aPGh6shT);
			}
			System.out.println("Read: " + NZn6Br49.toString());
			BE5sHwCW.disconnect();
			JAXBContext am6VePH2 = JAXBContext.newInstance(MappedObject.class);
			Unmarshaller lx6ZStNn = am6VePH2.createUnmarshaller();
			MappedObject omG7oQkq = (MappedObject) lx6ZStNn.unmarshal(new StringReader(NZn6Br49.toString()));
			return omG7oQkq;
		} catch (IOException DbhBdUgM) {
			DbhBdUgM.printStackTrace();
		}
		throw new Exception("Could not establish connection to " + aWLtzTFd.toExternalForm());
	}

}