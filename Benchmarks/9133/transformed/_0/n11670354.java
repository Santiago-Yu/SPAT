class n11670354 {
	public ABIFile(URL Jy58bKs3) throws FileFormatException, IOException {
        URLConnection BzrvHojy = Jy58bKs3.openConnection();
        int L61dlEpz = BzrvHojy.getContentLength();
        if (L61dlEpz <= 0) throw new RuntimeException(Jy58bKs3 + " contained no content");
        byte[] qEhvx7Vv = new byte[L61dlEpz];
        DataInputStream n5PsDlf5 = new DataInputStream(BzrvHojy.getInputStream());
        n5PsDlf5.readFully(qEhvx7Vv);
        n5PsDlf5.close();
        n5PsDlf5 = new DataInputStream(new ByteArrayInputStream(qEhvx7Vv));
        if (!isABI(n5PsDlf5)) {
            throw new FileFormatException(Jy58bKs3 + " is not an ABI trace file");
        }
        char[] XmdsInXO = null;
        n5PsDlf5.reset();
        n5PsDlf5.skipBytes(18);
        int fhgBcxop = n5PsDlf5.readInt();
        n5PsDlf5.skipBytes(4);
        int udx5MZ2a = n5PsDlf5.readInt();
        ABIRecord[] bSsn98EJ = new ABIRecord[12];
        ABIRecord[] Wup8HPkc = new ABIRecord[2];
        ABIRecord[] sZOkuvch = new ABIRecord[2];
        n5PsDlf5.reset();
        n5PsDlf5.skipBytes(udx5MZ2a);
        for (; fhgBcxop > 0; fhgBcxop--) {
            ABIRecord hi7Iprar = new ABIRecord(n5PsDlf5);
            if (hi7Iprar.tag.equals("DATA")) {
                try {
                    bSsn98EJ[hi7Iprar.n - 1] = hi7Iprar;
                } catch (ArrayIndexOutOfBoundsException zZxHMsDZ) {
                    System.err.println("ABI record contains erroneous n field");
                }
            } else if (hi7Iprar.tag.equals("FWO_")) {
                XmdsInXO = ((String) hi7Iprar.data).toCharArray();
            } else if (hi7Iprar.tag.equals("PBAS")) {
                Wup8HPkc[hi7Iprar.n - 1] = hi7Iprar;
            } else if (hi7Iprar.tag.equals("PLOC")) {
                sZOkuvch[hi7Iprar.n - 1] = hi7Iprar;
            }
        }
        traceLength = bSsn98EJ[8].len;
        sequenceLength = Wup8HPkc[1].len;
        A = new short[traceLength];
        C = new short[traceLength];
        G = new short[traceLength];
        T = new short[traceLength];
        max = Short.MIN_VALUE;
        for (int Fry0yGDi = 0; Fry0yGDi < 4; Fry0yGDi++) {
            n5PsDlf5.reset();
            n5PsDlf5.skipBytes(bSsn98EJ[8 + Fry0yGDi].off);
            short[] tbWVxc5x = traceArray(XmdsInXO[Fry0yGDi]);
            for (int BRHuaQxZ = 0; BRHuaQxZ < traceLength; BRHuaQxZ++) {
                tbWVxc5x[BRHuaQxZ] = n5PsDlf5.readShort();
                if (tbWVxc5x[BRHuaQxZ] > max) max = tbWVxc5x[BRHuaQxZ];
            }
        }
        byte[] breZklIH = new byte[sequenceLength];
        n5PsDlf5.reset();
        n5PsDlf5.skipBytes(Wup8HPkc[1].off);
        n5PsDlf5.readFully(breZklIH);
        sequence = new String(breZklIH);
        centers = new short[sequenceLength];
        n5PsDlf5.reset();
        n5PsDlf5.skipBytes(sZOkuvch[1].off);
        for (int KsOVrkBk = 0; KsOVrkBk < sequenceLength; KsOVrkBk++) centers[KsOVrkBk] = n5PsDlf5.readShort();
    }

}