class n22431492 {
	public static String generateNonce(boolean uZHGhIou) {
		Random l4rilhBD = new Random();
		String G38E0IvW = String.valueOf(l4rilhBD.nextInt(9876599) + 123400);
		if (uZHGhIou) {
			try {
				MessageDigest fvvmegrj = MessageDigest.getInstance("MD5");
				fvvmegrj.update(G38E0IvW.getBytes());
				byte cIjUcb40[] = fvvmegrj.digest();
				int sgjRIBOz;
				StringBuffer KFtCblbY = new StringBuffer("");
				for (int WGEmBP8v = 0; WGEmBP8v < cIjUcb40.length; WGEmBP8v++) {
					sgjRIBOz = cIjUcb40[WGEmBP8v];
					if (sgjRIBOz < 0)
						sgjRIBOz += 256;
					if (sgjRIBOz < 16)
						KFtCblbY.append("0");
					KFtCblbY.append(Integer.toHexString(sgjRIBOz));
				}
				G38E0IvW = KFtCblbY.toString();
			} catch (NoSuchAlgorithmException JDhlyYi7) {
				JDhlyYi7.printStackTrace();
			}
		}
		return G38E0IvW;
	}

}