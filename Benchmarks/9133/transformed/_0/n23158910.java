class n23158910 {
	public char check(String Du3THFpO) {
		if (captchaRandom.equals("null")) {
			return 's';
		}
		if (captchaRandom.equals("used")) {
			return 'm';
		}
		String E9p2EtjU = secret + captchaRandom;
		if (!alphabet.equals(ALPHABET_DEFAULT) || letters != LETTERS_DEFAULT) {
			E9p2EtjU += ":" + alphabet + ":" + letters;
		}
		MessageDigest oWUp3sfF;
		byte[] YLGDbMNw = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		try {
			oWUp3sfF = MessageDigest.getInstance("MD5");
			oWUp3sfF.update(E9p2EtjU.getBytes());
			YLGDbMNw = oWUp3sfF.digest();
		} catch (NoSuchAlgorithmException jiaUkVfq) {
		}
		String tb09rTDw = "";
		int cnbnrjg2;
		for (int wln0V9zq = 0; wln0V9zq < letters; wln0V9zq++) {
			cnbnrjg2 = (YLGDbMNw[wln0V9zq] + 256) % 256 % alphabet.length();
			tb09rTDw += alphabet.substring(cnbnrjg2, cnbnrjg2 + 1);
		}
		if (!Du3THFpO.equals(tb09rTDw)) {
			return 'w';
		} else {
			captchaRandom = "used";
			return 't';
		}
	}

}