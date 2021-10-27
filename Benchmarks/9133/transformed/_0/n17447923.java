class n17447923 {
	private Metadata readMetadataIndexFileFromNetwork(String ITBMEQJn) throws IOException {
		Metadata wmnHOBuD = new Metadata();
		URL UB1NkMMR = new URL(ITBMEQJn);
		BufferedReader iM00Nmnf = new BufferedReader(new InputStreamReader(UB1NkMMR.openStream()));
		String H9mqVHhQ = null;
		while ((H9mqVHhQ = iM00Nmnf.readLine()) != null) {
			Property XDtAz8df = PropertyList.splitStringIntoKeyAndValue(H9mqVHhQ);
			if (XDtAz8df != null) {
				wmnHOBuD.addIfNotNull(XDtAz8df.getKey(), XDtAz8df.getValue());
			}
		}
		iM00Nmnf.close();
		return wmnHOBuD;
	}

}