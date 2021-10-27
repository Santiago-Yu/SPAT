class n7665877 {
	public SCFFile(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        byte[] content = new byte[connection.getContentLength()];
        DataInputStream dis = new DataInputStream(connection.getInputStream());
        dis.readFully(content);
        dis.close();
        dis = new DataInputStream(new ByteArrayInputStream(content));
        header = new SCFHeader(dis);
        if (!header.magicNumber.equals(".scf")) throw new RuntimeException(url + " is not an SCF file");
        A = new int[header.samples];
        C = new int[header.samples];
        G = new int[header.samples];
        T = new int[header.samples];
        max = Integer.MIN_VALUE;
        dis.reset();
        dis.skipBytes(header.samplesOffset);
        if (1 == header.sampleSize) {
            if (header.version < 3.00) {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedByte();
                    if (A[i] > max) max = A[i];
                    C[i] = dis.readUnsignedByte();
                    if (C[i] > max) max = C[i];
                    G[i] = dis.readUnsignedByte();
                    if (G[i] > max) max = G[i];
                    T[i] = dis.readUnsignedByte();
                    if (T[i] > max) max = T[i];
                }
            } else {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedByte();
                    if (A[i] > max) max = A[i];
                }
                for (int i = 0; i < header.samples; ++i) {
                    C[i] = dis.readUnsignedByte();
                    if (C[i] > max) max = C[i];
                }
                for (int i = 0; i < header.samples; ++i) {
                    G[i] = dis.readUnsignedByte();
                    if (G[i] > max) max = G[i];
                }
                for (int i = 0; i < header.samples; ++i) {
                    T[i] = dis.readUnsignedByte();
                    if (T[i] > max) max = T[i];
                }
            }
        } else if (2 == header.sampleSize) {
            if (header.version < 3.00) {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedShort();
                    if (A[i] > max) max = A[i];
                    C[i] = dis.readUnsignedShort();
                    if (C[i] > max) max = C[i];
                    G[i] = dis.readUnsignedShort();
                    if (G[i] > max) max = G[i];
                    T[i] = dis.readUnsignedShort();
                    if (T[i] > max) max = T[i];
                }
            } else {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedShort();
                    if (A[i] > max) max = A[i];
                }
                for (int i = 0; i < header.samples; ++i) {
                    C[i] = dis.readUnsignedShort();
                    if (C[i] > max) max = C[i];
                }
                for (int i = 0; i < header.samples; ++i) {
                    G[i] = dis.readUnsignedShort();
                    if (G[i] > max) max = G[i];
                }
                for (int i = 0; i < header.samples; ++i) {
                    T[i] = dis.readUnsignedShort();
                    if (T[i] > max) max = T[i];
                }
            }
        }
        centers = new int[header.bases];
        byte[] buf = new byte[header.bases];
        dis.reset();
        dis.skipBytes(header.basesOffset);
        if (header.version < 3.00) {
            for (int i = 0; i < header.bases; ++i) {
                centers[i] = dis.readInt();
                dis.skipBytes(4);
                buf[i] = dis.readByte();
                dis.skipBytes(3);
            }
        } else {
            for (int i = 0; i < header.bases; ++i) centers[i] = dis.readInt();
            dis.skipBytes(4 * header.bases);
            dis.readFully(buf);
        }
        sequence = new String(buf);
        dis.close();
    }

}