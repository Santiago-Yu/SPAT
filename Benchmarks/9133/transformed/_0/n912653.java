class n912653 {
	public static void main(String[] JWzbkYw2) {
		if (JWzbkYw2.length != 1) {
			System.out.println("Usage: GUnzip source");
			return;
		}
		String WZTJoHuZ, HNyYoP2u;
		if (JWzbkYw2[0].endsWith(".gz")) {
			WZTJoHuZ = JWzbkYw2[0];
			HNyYoP2u = JWzbkYw2[0].substring(0, JWzbkYw2[0].length() - 3);
		} else {
			WZTJoHuZ = JWzbkYw2[0] + ".gz";
			HNyYoP2u = JWzbkYw2[0];
		}
		GZIPInputStream C0y9sT2z;
		try {
			FileInputStream j0s2u5Nz = new FileInputStream(WZTJoHuZ);
			C0y9sT2z = new GZIPInputStream(j0s2u5Nz);
		} catch (IOException J9iceR2Z) {
			System.out.println("Couldn't open " + WZTJoHuZ + ".");
			return;
		}
		byte[] Iji4vFxL = new byte[sChunk];
		try {
			FileOutputStream WCOYxDFy = new FileOutputStream(HNyYoP2u);
			int rXyP9WQl;
			while ((rXyP9WQl = C0y9sT2z.read(Iji4vFxL, 0, sChunk)) != -1)
				WCOYxDFy.write(Iji4vFxL, 0, rXyP9WQl);
			WCOYxDFy.close();
		} catch (IOException lB7Ic26F) {
			System.out.println("Couldn't decompress " + JWzbkYw2[0] + ".");
		}
		try {
			C0y9sT2z.close();
		} catch (IOException VK5PPxgW) {
		}
	}

}