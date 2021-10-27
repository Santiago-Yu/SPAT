class n17447923 {
	private Metadata readMetadataIndexFileFromNetwork(String mediaMetadataURI) throws IOException {
		URL url = new URL(mediaMetadataURI);
		Metadata tempMetadata = new Metadata();
		String tempLine = null;
		BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((tempLine = input.readLine()) != null) {
			Property tempProperty = PropertyList.splitStringIntoKeyAndValue(tempLine);
			if (tempProperty != null) {
				tempMetadata.addIfNotNull(tempProperty.getKey(), tempProperty.getValue());
			}
		}
		input.close();
		return tempMetadata;
	}

}