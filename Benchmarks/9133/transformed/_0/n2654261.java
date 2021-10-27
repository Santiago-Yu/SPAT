class n2654261 {
	public char check(String kIAKbzy0) {
		if (captchaRandom.equals("null")) {
			return 's';
		}
		if (captchaRandom.equals("used")) {
			return 'm';
		}
		String MLHWevkT = secret + captchaRandom;
		if (!alphabet.equals(ALPHABET_DEFAULT) || letters != LETTERS_DEFAULT) {
			MLHWevkT += ":" + alphabet + ":" + letters;
		}
		MessageDigest fRnN2S15;
		byte[] Kk518B3P = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		try {
			fRnN2S15 = MessageDigest.getInstance("MD5");
			fRnN2S15.update(MLHWevkT.getBytes());
			Kk518B3P = fRnN2S15.digest();
		} catch (NoSuchAlgorithmException D09MmFaH) {
		}
		String tDScyu9l = "";
		int ejyXzVS7;
		for (int hM21va8N = 0; hM21va8N < letters; hM21va8N++) {
			ejyXzVS7 = (Kk518B3P[hM21va8N] + 256) % 256 % alphabet.length();
			tDScyu9l += alphabet.substring(ejyXzVS7, ejyXzVS7 + 1);
		}
		if (!kIAKbzy0.equals(tDScyu9l)) {
			return 'w';
		} else {
			captchaRandom = "used";
			return 't';
		}
	}

}