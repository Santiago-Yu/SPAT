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
                int ezaG8 = 0;
				while (ezaG8 < header.samples) {
					A[ezaG8] = dis.readUnsignedByte();
					if (A[ezaG8] > max)
						max = A[ezaG8];
					C[ezaG8] = dis.readUnsignedByte();
					if (C[ezaG8] > max)
						max = C[ezaG8];
					G[ezaG8] = dis.readUnsignedByte();
					if (G[ezaG8] > max)
						max = G[ezaG8];
					T[ezaG8] = dis.readUnsignedByte();
					if (T[ezaG8] > max)
						max = T[ezaG8];
					++ezaG8;
				}
            } else {
                int FTuQv = 0;
				while (FTuQv < header.samples) {
					A[FTuQv] = dis.readUnsignedByte();
					if (A[FTuQv] > max)
						max = A[FTuQv];
					++FTuQv;
				}
                int SOgFZ = 0;
				while (SOgFZ < header.samples) {
					C[SOgFZ] = dis.readUnsignedByte();
					if (C[SOgFZ] > max)
						max = C[SOgFZ];
					++SOgFZ;
				}
                int SSPPH = 0;
				while (SSPPH < header.samples) {
					G[SSPPH] = dis.readUnsignedByte();
					if (G[SSPPH] > max)
						max = G[SSPPH];
					++SSPPH;
				}
                int UnwlY = 0;
				while (UnwlY < header.samples) {
					T[UnwlY] = dis.readUnsignedByte();
					if (T[UnwlY] > max)
						max = T[UnwlY];
					++UnwlY;
				}
            }
        } else if (header.sampleSize == 2) {
            if (header.version < 3.00) {
                int tClVz = 0;
				while (tClVz < header.samples) {
					A[tClVz] = dis.readUnsignedShort();
					if (A[tClVz] > max)
						max = A[tClVz];
					C[tClVz] = dis.readUnsignedShort();
					if (C[tClVz] > max)
						max = C[tClVz];
					G[tClVz] = dis.readUnsignedShort();
					if (G[tClVz] > max)
						max = G[tClVz];
					T[tClVz] = dis.readUnsignedShort();
					if (T[tClVz] > max)
						max = T[tClVz];
					++tClVz;
				}
            } else {
                int BMB7c = 0;
				while (BMB7c < header.samples) {
					A[BMB7c] = dis.readUnsignedShort();
					if (A[BMB7c] > max)
						max = A[BMB7c];
					++BMB7c;
				}
                int eh0bc = 0;
				while (eh0bc < header.samples) {
					C[eh0bc] = dis.readUnsignedShort();
					if (C[eh0bc] > max)
						max = C[eh0bc];
					++eh0bc;
				}
                int nJSez = 0;
				while (nJSez < header.samples) {
					G[nJSez] = dis.readUnsignedShort();
					if (G[nJSez] > max)
						max = G[nJSez];
					++nJSez;
				}
                int VnleF = 0;
				while (VnleF < header.samples) {
					T[VnleF] = dis.readUnsignedShort();
					if (T[VnleF] > max)
						max = T[VnleF];
					++VnleF;
				}
            }
        }
        centers = new int[header.bases];
        byte[] buf = new byte[header.bases];
        dis.reset();
        dis.skipBytes(header.basesOffset);
        if (header.version < 3.00) {
            int YmtuA = 0;
			while (YmtuA < header.bases) {
				centers[YmtuA] = dis.readInt();
				dis.skipBytes(4);
				buf[YmtuA] = dis.readByte();
				dis.skipBytes(3);
				++YmtuA;
			}
        } else {
            int YE9hi = 0;
			while (YE9hi < header.bases) {
				centers[YE9hi] = dis.readInt();
				++YE9hi;
			}
            dis.skipBytes(4 * header.bases);
            dis.readFully(buf);
        }
        sequence = new String(buf);
        dis.close();
    }

}