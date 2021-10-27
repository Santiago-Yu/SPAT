class n6613739 {
	private static MappedObject sendHttpRequestToUrl(URL url, String method) throws Exception {
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.connect();
			InputStream is = connection.getInputStream();
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			System.out.println("Read: " + buffer.toString());
			connection.disconnect();
			JAXBContext context = JAXBContext.newInstance(MappedObject.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			MappedObject mapped = (MappedObject) unmarshaller.unmarshal(new StringReader(buffer.toString()));
			return mapped;
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new Exception("Could not establish connection to " + url.toExternalForm());
	}

}