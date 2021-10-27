class n7665877 {
	public SCFFile(URL dvVQAwGc) throws IOException {
        URLConnection dz3M7k0A = dvVQAwGc.openConnection();
        byte[] Vx7EmhVL = new byte[dz3M7k0A.getContentLength()];
        DataInputStream rNM30OKB = new DataInputStream(dz3M7k0A.getInputStream());
        rNM30OKB.readFully(Vx7EmhVL);
        rNM30OKB.close();
        rNM30OKB = new DataInputStream(new ByteArrayInputStream(Vx7EmhVL));
        header = new SCFHeader(rNM30OKB);
        if (!header.magicNumber.equals(".scf")) throw new RuntimeException(dvVQAwGc + " is not an SCF file");
        A = new int[header.samples];
        C = new int[header.samples];
        G = new int[header.samples];
        T = new int[header.samples];
        max = Integer.MIN_VALUE;
        rNM30OKB.reset();
        rNM30OKB.skipBytes(header.samplesOffset);
        if (header.sampleSize == 1) {
            if (header.version < 3.00) {
                for (int BI8r2ZUK = 0; BI8r2ZUK < header.samples; ++BI8r2ZUK) {
                    A[BI8r2ZUK] = rNM30OKB.readUnsignedByte();
                    if (A[BI8r2ZUK] > max) max = A[BI8r2ZUK];
                    C[BI8r2ZUK] = rNM30OKB.readUnsignedByte();
                    if (C[BI8r2ZUK] > max) max = C[BI8r2ZUK];
                    G[BI8r2ZUK] = rNM30OKB.readUnsignedByte();
                    if (G[BI8r2ZUK] > max) max = G[BI8r2ZUK];
                    T[BI8r2ZUK] = rNM30OKB.readUnsignedByte();
                    if (T[BI8r2ZUK] > max) max = T[BI8r2ZUK];
                }
            } else {
                for (int S2a7e8Gr = 0; S2a7e8Gr < header.samples; ++S2a7e8Gr) {
                    A[S2a7e8Gr] = rNM30OKB.readUnsignedByte();
                    if (A[S2a7e8Gr] > max) max = A[S2a7e8Gr];
                }
                for (int BVnahCoM = 0; BVnahCoM < header.samples; ++BVnahCoM) {
                    C[BVnahCoM] = rNM30OKB.readUnsignedByte();
                    if (C[BVnahCoM] > max) max = C[BVnahCoM];
                }
                for (int dmYrmiND = 0; dmYrmiND < header.samples; ++dmYrmiND) {
                    G[dmYrmiND] = rNM30OKB.readUnsignedByte();
                    if (G[dmYrmiND] > max) max = G[dmYrmiND];
                }
                for (int UfNFaRYP = 0; UfNFaRYP < header.samples; ++UfNFaRYP) {
                    T[UfNFaRYP] = rNM30OKB.readUnsignedByte();
                    if (T[UfNFaRYP] > max) max = T[UfNFaRYP];
                }
            }
        } else if (header.sampleSize == 2) {
            if (header.version < 3.00) {
                for (int GaX3L5l6 = 0; GaX3L5l6 < header.samples; ++GaX3L5l6) {
                    A[GaX3L5l6] = rNM30OKB.readUnsignedShort();
                    if (A[GaX3L5l6] > max) max = A[GaX3L5l6];
                    C[GaX3L5l6] = rNM30OKB.readUnsignedShort();
                    if (C[GaX3L5l6] > max) max = C[GaX3L5l6];
                    G[GaX3L5l6] = rNM30OKB.readUnsignedShort();
                    if (G[GaX3L5l6] > max) max = G[GaX3L5l6];
                    T[GaX3L5l6] = rNM30OKB.readUnsignedShort();
                    if (T[GaX3L5l6] > max) max = T[GaX3L5l6];
                }
            } else {
                for (int ql8gBZkS = 0; ql8gBZkS < header.samples; ++ql8gBZkS) {
                    A[ql8gBZkS] = rNM30OKB.readUnsignedShort();
                    if (A[ql8gBZkS] > max) max = A[ql8gBZkS];
                }
                for (int IsiPpL8Z = 0; IsiPpL8Z < header.samples; ++IsiPpL8Z) {
                    C[IsiPpL8Z] = rNM30OKB.readUnsignedShort();
                    if (C[IsiPpL8Z] > max) max = C[IsiPpL8Z];
                }
                for (int lCIpl7du = 0; lCIpl7du < header.samples; ++lCIpl7du) {
                    G[lCIpl7du] = rNM30OKB.readUnsignedShort();
                    if (G[lCIpl7du] > max) max = G[lCIpl7du];
                }
                for (int mnHHYg5A = 0; mnHHYg5A < header.samples; ++mnHHYg5A) {
                    T[mnHHYg5A] = rNM30OKB.readUnsignedShort();
                    if (T[mnHHYg5A] > max) max = T[mnHHYg5A];
                }
            }
        }
        centers = new int[header.bases];
        byte[] PKIaIME6 = new byte[header.bases];
        rNM30OKB.reset();
        rNM30OKB.skipBytes(header.basesOffset);
        if (header.version < 3.00) {
            for (int vhfatfMS = 0; vhfatfMS < header.bases; ++vhfatfMS) {
                centers[vhfatfMS] = rNM30OKB.readInt();
                rNM30OKB.skipBytes(4);
                PKIaIME6[vhfatfMS] = rNM30OKB.readByte();
                rNM30OKB.skipBytes(3);
            }
        } else {
            for (int o3XLuBik = 0; o3XLuBik < header.bases; ++o3XLuBik) centers[o3XLuBik] = rNM30OKB.readInt();
            rNM30OKB.skipBytes(4 * header.bases);
            rNM30OKB.readFully(PKIaIME6);
        }
        sequence = new String(PKIaIME6);
        rNM30OKB.close();
    }

}