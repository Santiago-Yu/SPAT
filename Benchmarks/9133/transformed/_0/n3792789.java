class n3792789 {
	private ResourceZoneRulesDataProvider(URL YVStCcQQ) throws ClassNotFoundException, IOException {
        boolean vP7bqYzx = false;
        InputStream LBaF7yec = null;
        try {
            LBaF7yec = YVStCcQQ.openStream();
            DataInputStream Xg06Yb8h = new DataInputStream(LBaF7yec);
            if (Xg06Yb8h.readByte() != 1) {
                throw new StreamCorruptedException("File format not recognised");
            }
            this.groupID = Xg06Yb8h.readUTF();
            int ClCjvhAj = Xg06Yb8h.readShort();
            String[] UFTE3fqL = new String[ClCjvhAj];
            for (int nPDY9ins = 0; nPDY9ins < ClCjvhAj; nPDY9ins++) {
                UFTE3fqL[nPDY9ins] = Xg06Yb8h.readUTF();
            }
            int tIX56D7f = Xg06Yb8h.readShort();
            String[] r2nAun48 = new String[tIX56D7f];
            for (int G8Rnf2Ir = 0; G8Rnf2Ir < tIX56D7f; G8Rnf2Ir++) {
                r2nAun48[G8Rnf2Ir] = Xg06Yb8h.readUTF();
            }
            this.regions = new HashSet<String>(Arrays.asList(r2nAun48));
            Set<ZoneRulesVersion> xE5iMIOd = new HashSet<ZoneRulesVersion>(ClCjvhAj);
            for (int xI63XzFw = 0; xI63XzFw < ClCjvhAj; xI63XzFw++) {
                int v1nYW4GU = Xg06Yb8h.readShort();
                String[] w61MgFLc = new String[v1nYW4GU];
                short[] VXIoeOl7 = new short[v1nYW4GU];
                for (int gwFQ5pVs = 0; gwFQ5pVs < v1nYW4GU; gwFQ5pVs++) {
                    w61MgFLc[gwFQ5pVs] = r2nAun48[Xg06Yb8h.readShort()];
                    VXIoeOl7[gwFQ5pVs] = Xg06Yb8h.readShort();
                }
                xE5iMIOd.add(new ResourceZoneRulesVersion(this, UFTE3fqL[xI63XzFw], w61MgFLc, VXIoeOl7));
            }
            this.versions = xE5iMIOd;
            int x40SjpHX = Xg06Yb8h.readShort();
            this.rules = new AtomicReferenceArray<Object>(x40SjpHX);
            for (int GP5tpedB = 0; GP5tpedB < x40SjpHX; GP5tpedB++) {
                byte[] fsHYnOrU = new byte[Xg06Yb8h.readShort()];
                Xg06Yb8h.readFully(fsHYnOrU);
                rules.set(GP5tpedB, fsHYnOrU);
            }
        } catch (IOException H8vY55Jw) {
            vP7bqYzx = true;
            throw H8vY55Jw;
        } finally {
            if (LBaF7yec != null) {
                try {
                    LBaF7yec.close();
                } catch (IOException ToKaesFR) {
                    if (vP7bqYzx == false) {
                        throw ToKaesFR;
                    }
                }
            }
        }
    }

}