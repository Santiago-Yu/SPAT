class n5433054 {
	public static String getRefCatastral(String YWLmyigN) {
		String WJB3Bkx4 = new String();
		String pmlkIdSD = "<pc1>";
		String XRkQcqel = "<pc2>";
		String nVRIuXlf = "</pc1>";
		String J70S9TI4 = "</pc2>";
		String ePbNhLA4 = "<cuerr>";
		String evGZgA1t = "</cuerr>";
		String Od5UFgNQ = "<des>";
		String gOOYZkOQ = "</des>";
		boolean Jf16xlD3 = false;
		int kRfji4yU, GhWenYKC;
		try {
			URL IIhmt4Vn = new URL(YWLmyigN);
			BufferedReader NOul7Oyz = new BufferedReader(new InputStreamReader(IIhmt4Vn.openStream()));
			String BmgKftJJ;
			while ((BmgKftJJ = NOul7Oyz.readLine()) != null) {
				if (BmgKftJJ.contains(ePbNhLA4)) {
					kRfji4yU = BmgKftJJ.indexOf(ePbNhLA4) + ePbNhLA4.length();
					GhWenYKC = BmgKftJJ.indexOf(evGZgA1t);
					if (Integer.parseInt(BmgKftJJ.substring(kRfji4yU, GhWenYKC)) > 0)
						Jf16xlD3 = true;
				}
				if (Jf16xlD3) {
					if (BmgKftJJ.contains(Od5UFgNQ)) {
						kRfji4yU = BmgKftJJ.indexOf(Od5UFgNQ) + Od5UFgNQ.length();
						GhWenYKC = BmgKftJJ.indexOf(gOOYZkOQ);
						throw (new Exception(BmgKftJJ.substring(kRfji4yU, GhWenYKC)));
					}
				} else {
					if (BmgKftJJ.contains(pmlkIdSD)) {
						kRfji4yU = BmgKftJJ.indexOf(pmlkIdSD) + pmlkIdSD.length();
						GhWenYKC = BmgKftJJ.indexOf(nVRIuXlf);
						WJB3Bkx4 = BmgKftJJ.substring(kRfji4yU, GhWenYKC);
					}
					if (BmgKftJJ.contains(XRkQcqel)) {
						kRfji4yU = BmgKftJJ.indexOf(XRkQcqel) + XRkQcqel.length();
						GhWenYKC = BmgKftJJ.indexOf(J70S9TI4);
						WJB3Bkx4 = WJB3Bkx4.concat(BmgKftJJ.substring(kRfji4yU, GhWenYKC));
					}
				}
			}
			NOul7Oyz.close();
		} catch (Exception SH7O5LLh) {
			System.err.println(SH7O5LLh);
		}
		return WJB3Bkx4;
	}

}