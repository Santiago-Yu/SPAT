class n6016307 {
	public static int[] rank(double[] ksBKwNnS) {
		int[] PemAHajj = new int[ksBKwNnS.length];
		for (int supItAvU = 0; supItAvU < ksBKwNnS.length; supItAvU++)
			PemAHajj[supItAvU] = supItAvU;
		boolean FJx0dEr0;
		double h7KBeCDz;
		int S6s7QNnT, vAWCSg9v, KidHinkc;
		for (S6s7QNnT = 0; S6s7QNnT < ksBKwNnS.length - 1; S6s7QNnT++) {
			FJx0dEr0 = false;
			for (vAWCSg9v = 0; vAWCSg9v < ksBKwNnS.length - 1 - S6s7QNnT; vAWCSg9v++) {
				if (ksBKwNnS[vAWCSg9v] < ksBKwNnS[vAWCSg9v + 1]) {
					h7KBeCDz = ksBKwNnS[vAWCSg9v];
					ksBKwNnS[vAWCSg9v] = ksBKwNnS[vAWCSg9v + 1];
					ksBKwNnS[vAWCSg9v + 1] = h7KBeCDz;
					KidHinkc = PemAHajj[vAWCSg9v];
					PemAHajj[vAWCSg9v] = PemAHajj[vAWCSg9v + 1];
					PemAHajj[vAWCSg9v + 1] = KidHinkc;
					FJx0dEr0 = true;
				}
			}
		}
		return PemAHajj;
	}

}