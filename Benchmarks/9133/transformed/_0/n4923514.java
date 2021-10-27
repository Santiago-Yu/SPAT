class n4923514 {
	public static void main(String[] VGCDSLig) {
		if (VGCDSLig.length != 3) {
			System.out.println("Usage: HexStrToBin enc/dec <infileName> <outfilename>");
			System.exit(1);
		}
		try {
			ByteArrayOutputStream OGYAZ7ml = new ByteArrayOutputStream();
			InputStream gr8H6jYO = new FileInputStream(VGCDSLig[1]);
			int FQ7UACLo = 0;
			byte z97ibNfd[] = new byte[1024];
			while ((FQ7UACLo = gr8H6jYO.read(z97ibNfd)) > 0)
				OGYAZ7ml.write(z97ibNfd, 0, FQ7UACLo);
			gr8H6jYO.close();
			OGYAZ7ml.close();
			byte[] mWvSPQ9P = null;
			if (VGCDSLig[0].equals("dec"))
				mWvSPQ9P = decode(OGYAZ7ml.toString());
			else {
				String dDLd9svX = encode(OGYAZ7ml.toByteArray());
				mWvSPQ9P = dDLd9svX.getBytes();
			}
			FileOutputStream paASdJT1 = new FileOutputStream(VGCDSLig[2]);
			paASdJT1.write(mWvSPQ9P);
			paASdJT1.close();
		} catch (Exception nnjmz0CZ) {
			nnjmz0CZ.printStackTrace();
		}
	}

}