class n190292 {
	private static void main(String[] ohnN56xk) {
		try {
			File TjcrCCOo = new File("test.txt");
			if (TjcrCCOo.exists()) {
				throw new IOException(TjcrCCOo + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader byWwh5xf;
			char[] rXRxnkdk = new char[0x1000];
			int BNtcmYDp;
			int qTjkS31w;
			FileOutputStream X4LZL9Pr = new FileOutputStream(TjcrCCOo);
			for (int i0jwwFXX = 0x00; i0jwwFXX < 0x100; i0jwwFXX++) {
				X4LZL9Pr.write(i0jwwFXX);
			}
			X4LZL9Pr.close();
			byWwh5xf = new StraightStreamReader(new FileInputStream(TjcrCCOo));
			for (int Xis5uRKD = 0x00; Xis5uRKD < 0x100; Xis5uRKD++) {
				BNtcmYDp = byWwh5xf.read();
				if (BNtcmYDp != Xis5uRKD) {
					System.err.println("Error: " + Xis5uRKD + " read as " + BNtcmYDp);
				}
			}
			byWwh5xf.close();
			byWwh5xf = new StraightStreamReader(new FileInputStream(TjcrCCOo));
			qTjkS31w = byWwh5xf.read(rXRxnkdk);
			if (qTjkS31w != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(qTjkS31w));
			}
			for (int E1ctAXOf = 0x00; E1ctAXOf < qTjkS31w; E1ctAXOf++) {
				if (rXRxnkdk[E1ctAXOf] != E1ctAXOf) {
					System.err.println("Error: 0x" + E1ctAXOf + " read as 0x" + rXRxnkdk[E1ctAXOf]);
				}
			}
			byWwh5xf.close();
			byWwh5xf = new StraightStreamReader(new FileInputStream(TjcrCCOo));
			qTjkS31w = 0;
			while (qTjkS31w <= 0x100 && (BNtcmYDp = byWwh5xf.read(rXRxnkdk, qTjkS31w, 0x100 - qTjkS31w)) > 0) {
				qTjkS31w += BNtcmYDp;
			}
			if (qTjkS31w != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(qTjkS31w));
			}
			for (int uQX4511T = 0x00; uQX4511T < qTjkS31w; uQX4511T++) {
				if (rXRxnkdk[uQX4511T] != uQX4511T) {
					System.err.println("Error: 0x" + uQX4511T + " read as 0x" + rXRxnkdk[uQX4511T]);
				}
			}
			byWwh5xf.close();
			byWwh5xf = new StraightStreamReader(new FileInputStream(TjcrCCOo));
			qTjkS31w = 0;
			while (qTjkS31w <= 0x100 && (BNtcmYDp = byWwh5xf.read(rXRxnkdk, qTjkS31w + 0x123, 0x100 - qTjkS31w)) > 0) {
				qTjkS31w += BNtcmYDp;
			}
			if (qTjkS31w != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(qTjkS31w));
			}
			for (int YhD6VRLs = 0x00; YhD6VRLs < qTjkS31w; YhD6VRLs++) {
				if (rXRxnkdk[YhD6VRLs + 0x123] != YhD6VRLs) {
					System.err.println("Error: 0x" + YhD6VRLs + " read as 0x" + rXRxnkdk[YhD6VRLs + 0x123]);
				}
			}
			byWwh5xf.close();
			byWwh5xf = new StraightStreamReader(new FileInputStream(TjcrCCOo));
			qTjkS31w = 0;
			while (qTjkS31w <= 0x100 && (BNtcmYDp = byWwh5xf.read(rXRxnkdk, qTjkS31w + 0x123, 7)) > 0) {
				qTjkS31w += BNtcmYDp;
			}
			if (qTjkS31w != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(qTjkS31w));
			}
			for (int jL33Bqhc = 0x00; jL33Bqhc < qTjkS31w; jL33Bqhc++) {
				if (rXRxnkdk[jL33Bqhc + 0x123] != jL33Bqhc) {
					System.err.println("Error: 0x" + jL33Bqhc + " read as 0x" + rXRxnkdk[jL33Bqhc + 0x123]);
				}
			}
			byWwh5xf.close();
			TjcrCCOo.delete();
		} catch (IOException eOI2h71I) {
			System.err.println(eOI2h71I.getMessage());
		}
	}

}