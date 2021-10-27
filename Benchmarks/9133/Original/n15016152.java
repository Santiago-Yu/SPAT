class n15016152{
    private void readFromDB() throws Exception {
        URL url;
        URLConnection connect;
        BufferedInputStream in = null;
        Schema schema = new Schema(base, indexDir, false);
        BtreeDictParameters params = new BtreeDictParameters(schema, "TMAP");
        params.readState();
        tmap = new BtreeDict(params);
        readChildrenData();
        url = getURL("DOCS.TAB");
        connect = url.openConnection();
        in = new BufferedInputStream(connect.getInputStream());
        int k1 = in.read();
        concepts = new IntegerArray(4096);
        StreamDecompressor sddocs = new StreamDecompressor(in);
        sddocs.ascDecode(k1, concepts);
        int k2 = in.read();
        offsets = new IntegerArray(concepts.cardinality() + 1);
        offsets.add(0);
        StreamDecompressor sdoffsets = new StreamDecompressor(in);
        sdoffsets.ascDecode(k2, offsets);
        in.close();
        url = getURL("DOCS");
        connect = url.openConnection();
        in = new BufferedInputStream(connect.getInputStream());
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        byte[] buff = new byte[512];
        int i = 0;
        while ((i = in.read(buff)) != -1) {
            data.write(buff, 0, i);
        }
        allLists = data.toByteArray();
        in.close();
        url = getURL("OFFSETS");
        connect = url.openConnection();
        in = new BufferedInputStream(connect.getInputStream());
        k1 = in.read();
        documents = new IntegerArray(4096);
        sddocs = new StreamDecompressor(in);
        sddocs.ascDecode(k1, documents);
        k2 = in.read();
        offsets2 = new IntegerArray(documents.cardinality() + 1);
        sdoffsets = new StreamDecompressor(in);
        sdoffsets.ascDecode(k2, offsets2);
        int k3 = in.read();
        titles = new IntegerArray(documents.cardinality());
        StreamDecompressor sdtitles = new StreamDecompressor(in);
        sdtitles.decode(k3, titles);
        in.close();
        RAFFileFactory factory = RAFFileFactory.create();
        url = getURL("POSITIONS");
        positionsFile = factory.get(url, false);
    }

}