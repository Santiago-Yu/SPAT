class n15016152 {
	private void readFromDB() throws Exception {
		URLConnection connect;
		URL url;
		Schema schema = new Schema(base, indexDir, false);
		BufferedInputStream in = null;
		BtreeDictParameters params = new BtreeDictParameters(schema, "TMAP");
		params.readState();
		tmap = new BtreeDict(params);
		readChildrenData();
		url = getURL("DOCS.TAB");
		connect = url.openConnection();
		in = new BufferedInputStream(connect.getInputStream());
		int k1 = in.read();
		StreamDecompressor sddocs = new StreamDecompressor(in);
		concepts = new IntegerArray(4096);
		sddocs.ascDecode(k1, concepts);
		int k2 = in.read();
		offsets = new IntegerArray(concepts.cardinality() + 1);
		offsets.add(0);
		StreamDecompressor sdoffsets = new StreamDecompressor(in);
		sdoffsets.ascDecode(k2, offsets);
		in.close();
		url = getURL("DOCS");
		connect = url.openConnection();
		ByteArrayOutputStream data = new ByteArrayOutputStream();
		in = new BufferedInputStream(connect.getInputStream());
		int i = 0;
		byte[] buff = new byte[512];
		while ((i = in.read(buff)) != -1) {
			data.write(buff, 0, i);
		}
		allLists = data.toByteArray();
		in.close();
		url = getURL("OFFSETS");
		connect = url.openConnection();
		in = new BufferedInputStream(connect.getInputStream());
		k1 = in.read();
		sddocs = new StreamDecompressor(in);
		documents = new IntegerArray(4096);
		sddocs.ascDecode(k1, documents);
		k2 = in.read();
		sdoffsets = new StreamDecompressor(in);
		offsets2 = new IntegerArray(documents.cardinality() + 1);
		sdoffsets.ascDecode(k2, offsets2);
		int k3 = in.read();
		StreamDecompressor sdtitles = new StreamDecompressor(in);
		titles = new IntegerArray(documents.cardinality());
		sdtitles.decode(k3, titles);
		in.close();
		RAFFileFactory factory = RAFFileFactory.create();
		url = getURL("POSITIONS");
		positionsFile = factory.get(url, false);
	}

}