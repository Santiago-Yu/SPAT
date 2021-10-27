class n5723876 {
	public static final String calculate(File nVMyRraU) {
		MessageDigest gzhrYTVE;
		BufferedReader Ws5WbHJj;
		StringBuffer nnuJTUBy = new StringBuffer("");
		try {
			Ws5WbHJj = new BufferedReader(new FileReader(nVMyRraU));
			gzhrYTVE = MessageDigest.getInstance("SHA");
			String u2ABmsC3 = "";
			while ((u2ABmsC3 = Ws5WbHJj.readLine()) != null)
				nnuJTUBy.append(u2ABmsC3);
			gzhrYTVE.update(nnuJTUBy.toString().getBytes());
			byte[] jSmbeahs = gzhrYTVE.digest();
			String up8985S5 = "";
			for (byte uIH9DU5e : jSmbeahs)
				up8985S5 += String.format("%h", uIH9DU5e & 0xFF);
			return up8985S5;
		} catch (Exception fb6Gvfah) {
			fb6Gvfah.printStackTrace();
			return "";
		}
	}

}