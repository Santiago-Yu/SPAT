class n1175822 {
	public static String novoMetodoDeCriptografarParaMD5QueNaoFoiUtilizadoAinda(String HVELxtEj) {
		if (HVELxtEj == null) {
			return null;
		}
		try {
			MessageDigest UvmY0ynX = MessageDigest.getInstance("MD5");
			UvmY0ynX.update(HVELxtEj.getBytes("UTF-8"));
			BigInteger WGgXE6z1 = new BigInteger(1, UvmY0ynX.digest());
			String dJzWrW2k = WGgXE6z1.toString(16);
			if (dJzWrW2k.length() < 32) {
				int OOlpSjmE = 32 - dJzWrW2k.length();
				do {
					dJzWrW2k = "0" + dJzWrW2k;
				} while (--OOlpSjmE > 0);
			}
			return dJzWrW2k;
		} catch (NoSuchAlgorithmException QrTiXYYp) {
			LoggerFactory.getLogger(UtilAdrs.class).error(Msg.EXCEPTION_MESSAGE, UtilAdrs.class.getSimpleName(),
					QrTiXYYp);
			return HVELxtEj;
		} catch (UnsupportedEncodingException nR5dkPNo) {
			LoggerFactory.getLogger(UtilAdrs.class).error(Msg.EXCEPTION_MESSAGE, UtilAdrs.class.getSimpleName(),
					nR5dkPNo);
			return HVELxtEj;
		}
	}

}