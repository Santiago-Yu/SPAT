class n15016152 {
	private void readFromDB() throws Exception {
		URL aGYIRLbo;
		URLConnection f6R9KzXf;
		BufferedInputStream bry9SAHD = null;
		Schema Di9E1J0D = new Schema(base, indexDir, false);
		BtreeDictParameters uQJ7P8Rs = new BtreeDictParameters(Di9E1J0D, "TMAP");
		uQJ7P8Rs.readState();
		tmap = new BtreeDict(uQJ7P8Rs);
		readChildrenData();
		aGYIRLbo = getURL("DOCS.TAB");
		f6R9KzXf = aGYIRLbo.openConnection();
		bry9SAHD = new BufferedInputStream(f6R9KzXf.getInputStream());
		int AY9yH25m = bry9SAHD.read();
		concepts = new IntegerArray(4096);
		StreamDecompressor V6fiooW6 = new StreamDecompressor(bry9SAHD);
		V6fiooW6.ascDecode(AY9yH25m, concepts);
		int SmLUvM0q = bry9SAHD.read();
		offsets = new IntegerArray(concepts.cardinality() + 1);
		offsets.add(0);
		StreamDecompressor i0jmhuhn = new StreamDecompressor(bry9SAHD);
		i0jmhuhn.ascDecode(SmLUvM0q, offsets);
		bry9SAHD.close();
		aGYIRLbo = getURL("DOCS");
		f6R9KzXf = aGYIRLbo.openConnection();
		bry9SAHD = new BufferedInputStream(f6R9KzXf.getInputStream());
		ByteArrayOutputStream tb29PDWj = new ByteArrayOutputStream();
		byte[] eP74DEDM = new byte[512];
		int Ld8DxJ2g = 0;
		while ((Ld8DxJ2g = bry9SAHD.read(eP74DEDM)) != -1) {
			tb29PDWj.write(eP74DEDM, 0, Ld8DxJ2g);
		}
		allLists = tb29PDWj.toByteArray();
		bry9SAHD.close();
		aGYIRLbo = getURL("OFFSETS");
		f6R9KzXf = aGYIRLbo.openConnection();
		bry9SAHD = new BufferedInputStream(f6R9KzXf.getInputStream());
		AY9yH25m = bry9SAHD.read();
		documents = new IntegerArray(4096);
		V6fiooW6 = new StreamDecompressor(bry9SAHD);
		V6fiooW6.ascDecode(AY9yH25m, documents);
		SmLUvM0q = bry9SAHD.read();
		offsets2 = new IntegerArray(documents.cardinality() + 1);
		i0jmhuhn = new StreamDecompressor(bry9SAHD);
		i0jmhuhn.ascDecode(SmLUvM0q, offsets2);
		int lxUetWsU = bry9SAHD.read();
		titles = new IntegerArray(documents.cardinality());
		StreamDecompressor GyJKmNWQ = new StreamDecompressor(bry9SAHD);
		GyJKmNWQ.decode(lxUetWsU, titles);
		bry9SAHD.close();
		RAFFileFactory oPzQuhEB = RAFFileFactory.create();
		aGYIRLbo = getURL("POSITIONS");
		positionsFile = oPzQuhEB.get(aGYIRLbo, false);
	}

}