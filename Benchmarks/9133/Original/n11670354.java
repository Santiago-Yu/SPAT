class n11670354{
    public ABIFile(URL url) throws FileFormatException, IOException {
        URLConnection connection = url.openConnection();
        int contentLength = connection.getContentLength();
        if (contentLength <= 0) throw new RuntimeException(url + " contained no content");
        byte[] content = new byte[contentLength];
        DataInputStream dis = new DataInputStream(connection.getInputStream());
        dis.readFully(content);
        dis.close();
        dis = new DataInputStream(new ByteArrayInputStream(content));
        if (!isABI(dis)) {
            throw new FileFormatException(url + " is not an ABI trace file");
        }
        char[] fwo = null;
        dis.reset();
        dis.skipBytes(18);
        int len = dis.readInt();
        dis.skipBytes(4);
        int off = dis.readInt();
        ABIRecord[] data = new ABIRecord[12];
        ABIRecord[] pbas = new ABIRecord[2];
        ABIRecord[] ploc = new ABIRecord[2];
        dis.reset();
        dis.skipBytes(off);
        for (; len > 0; len--) {
            ABIRecord rec = new ABIRecord(dis);
            if (rec.tag.equals("DATA")) {
                try {
                    data[rec.n - 1] = rec;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("ABI record contains erroneous n field");
                }
            } else if (rec.tag.equals("FWO_")) {
                fwo = ((String) rec.data).toCharArray();
            } else if (rec.tag.equals("PBAS")) {
                pbas[rec.n - 1] = rec;
            } else if (rec.tag.equals("PLOC")) {
                ploc[rec.n - 1] = rec;
            }
        }
        traceLength = data[8].len;
        sequenceLength = pbas[1].len;
        A = new short[traceLength];
        C = new short[traceLength];
        G = new short[traceLength];
        T = new short[traceLength];
        max = Short.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            dis.reset();
            dis.skipBytes(data[8 + i].off);
            short[] current = traceArray(fwo[i]);
            for (int j = 0; j < traceLength; j++) {
                current[j] = dis.readShort();
                if (current[j] > max) max = current[j];
            }
        }
        byte[] buf = new byte[sequenceLength];
        dis.reset();
        dis.skipBytes(pbas[1].off);
        dis.readFully(buf);
        sequence = new String(buf);
        centers = new short[sequenceLength];
        dis.reset();
        dis.skipBytes(ploc[1].off);
        for (int i = 0; i < sequenceLength; i++) centers[i] = dis.readShort();
    }

}