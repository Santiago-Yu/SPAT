class n15178715 {
	public static void main(String[] khnjuQwK) throws IOException, DataFormatException {
		byte vCL4Bv9J[] = new byte[20000];
		if (khnjuQwK.length < 2) {
			System.out.println("too few arguments");
			System.exit(0);
		}
		String NWArFQuG = khnjuQwK[0];
		InputStream benSS5GQ = new FileInputStream(NWArFQuG);
		int XTnmmC2E = 0;
		for (int LL6WwIdB = 1; LL6WwIdB < khnjuQwK.length; LL6WwIdB++) {
			int se1c1EFb = Integer.parseInt(khnjuQwK[LL6WwIdB]);
			boolean CWolkxGg = se1c1EFb >= 0;
			if (se1c1EFb < 0) {
				se1c1EFb = -se1c1EFb;
			}
			OutputStream yhc87ghC = null;
			if (CWolkxGg) {
				XTnmmC2E++;
				yhc87ghC = new FileOutputStream(NWArFQuG + "." + XTnmmC2E + ".dat");
			}
			while (se1c1EFb > 0) {
				int g8zgAGBN = benSS5GQ.read(vCL4Bv9J, 0, Math.min(vCL4Bv9J.length, se1c1EFb));
				if (g8zgAGBN < 0) {
					break;
				}
				se1c1EFb -= g8zgAGBN;
				if (CWolkxGg) {
					yhc87ghC.write(vCL4Bv9J, 0, g8zgAGBN);
				}
			}
			if (CWolkxGg) {
				yhc87ghC.close();
			}
		}
		XTnmmC2E++;
		OutputStream yPIR4EqU = new FileOutputStream(NWArFQuG + "." + XTnmmC2E + ".dat");
		while (true) {
			int t5w6zx5l = benSS5GQ.read(vCL4Bv9J);
			if (t5w6zx5l < 0) {
				break;
			}
			yPIR4EqU.write(vCL4Bv9J, 0, t5w6zx5l);
		}
		yPIR4EqU.close();
		benSS5GQ.close();
	}

}