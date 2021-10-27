class n15016151{
    private void readChildrenData() throws Exception {
        URL url;
        URLConnection connect;
        BufferedInputStream in;
        try {
            url = getURL("CHILDREN.TAB");
            connect = url.openConnection();
            InputStream ois = connect.getInputStream();
            if (ois == null) {
                concepts3 = new IntegerArray(1);
                return;
            }
            in = new BufferedInputStream(ois);
            int k1 = in.read();
            concepts3 = new IntegerArray(4096);
            StreamDecompressor sddocs = new StreamDecompressor(in);
            sddocs.ascDecode(k1, concepts3);
            int k2 = in.read();
            offsets3 = new IntegerArray(concepts3.cardinality() + 1);
            offsets3.add(0);
            StreamDecompressor sdoffsets = new StreamDecompressor(in);
            sdoffsets.ascDecode(k2, offsets3);
            in.close();
            url = getURL("CHILDREN");
            connect = url.openConnection();
            ois = connect.getInputStream();
            if (ois == null) {
                concepts3 = new IntegerArray(1);
                return;
            }
            in = new BufferedInputStream(ois);
            int length = connect.getContentLength();
            allChildren = new byte[length];
            in.read(allChildren);
            in.close();
        } catch (MalformedURLException e) {
            concepts3 = new IntegerArray(1);
        } catch (FileNotFoundException e2) {
            concepts3 = new IntegerArray(1);
        } catch (IOException e2) {
            concepts3 = new IntegerArray(1);
        }
    }

}