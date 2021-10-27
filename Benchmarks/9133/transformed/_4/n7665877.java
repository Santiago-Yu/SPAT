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
        if (header.sampleSize == 1) {
            if (header.version < 3.00) {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedByte();
                    max = (A[i] > max) ? A[i] : max;
                    C[i] = dis.readUnsignedByte();
                    max = (C[i] > max) ? C[i] : max;
                    G[i] = dis.readUnsignedByte();
                    max = (G[i] > max) ? G[i] : max;
                    T[i] = dis.readUnsignedByte();
                    max = (T[i] > max) ? T[i] : max;
                }
            } else {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedByte();
                    max = (A[i] > max) ? A[i] : max;
                }
                for (int i = 0; i < header.samples; ++i) {
                    C[i] = dis.readUnsignedByte();
                    max = (C[i] > max) ? C[i] : max;
                }
                for (int i = 0; i < header.samples; ++i) {
                    G[i] = dis.readUnsignedByte();
                    max = (G[i] > max) ? G[i] : max;
                }
                for (int i = 0; i < header.samples; ++i) {
                    T[i] = dis.readUnsignedByte();
                    max = (T[i] > max) ? T[i] : max;
                }
            }
        } else if (header.sampleSize == 2) {
            if (header.version < 3.00) {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedShort();
                    max = (A[i] > max) ? A[i] : max;
                    C[i] = dis.readUnsignedShort();
                    max = (C[i] > max) ? C[i] : max;
                    G[i] = dis.readUnsignedShort();
                    max = (G[i] > max) ? G[i] : max;
                    T[i] = dis.readUnsignedShort();
                    max = (T[i] > max) ? T[i] : max;
                }
            } else {
                for (int i = 0; i < header.samples; ++i) {
                    A[i] = dis.readUnsignedShort();
                    max = (A[i] > max) ? A[i] : max;
                }
                for (int i = 0; i < header.samples; ++i) {
                    C[i] = dis.readUnsignedShort();
                    max = (C[i] > max) ? C[i] : max;
                }
                for (int i = 0; i < header.samples; ++i) {
                    G[i] = dis.readUnsignedShort();
                    max = (G[i] > max) ? G[i] : max;
                }
                for (int i = 0; i < header.samples; ++i) {
                    T[i] = dis.readUnsignedShort();
                    max = (T[i] > max) ? T[i] : max;
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