class n6081622 {
	public String encryptStringWithKey(String to_be_encrypted, String aKey) {
		char xdigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		String encrypted_value = "";
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException exc) {
			globalErrorDictionary.takeValueForKey(("Security package does not contain appropriate algorithm"),
					("Security package does not contain appropriate algorithm"));
			log.error("Security package does not contain appropriate algorithm");
			return encrypted_value;
		}
		if (to_be_encrypted != null) {
			byte fudge_constant[];
			byte digest[];
			byte fudgetoo_part[] = { (byte) xdigit[(int) (MSiteConfig.myrand() % 16)],
					(byte) xdigit[(int) (MSiteConfig.myrand() % 16)], (byte) xdigit[(int) (MSiteConfig.myrand() % 16)],
					(byte) xdigit[(int) (MSiteConfig.myrand() % 16)] };
			try {
				fudge_constant = ("X#@!").getBytes("UTF8");
			} catch (UnsupportedEncodingException uee) {
				fudge_constant = ("X#@!").getBytes();
			}
			if (aKey != null) {
				try {
					fudgetoo_part = aKey.getBytes("UTF8");
				} catch (UnsupportedEncodingException uee) {
					fudgetoo_part = aKey.getBytes();
				}
			}
			int i = 0;
			messageDigest.update(fudge_constant);
			try {
				messageDigest.update(to_be_encrypted.getBytes("UTF8"));
			} catch (UnsupportedEncodingException uee) {
				messageDigest.update(to_be_encrypted.getBytes());
			}
			messageDigest.update(fudgetoo_part);
			encrypted_value = new String(fudgetoo_part);
			digest = messageDigest.digest();
			for (i = 0; i < digest.length; i++) {
				char temp[] = new char[2];
				int mashed;
				if (digest[i] < 0) {
					mashed = 127 + (-1 * digest[i]);
				} else {
					mashed = digest[i];
				}
				temp[0] = xdigit[mashed / 16];
				temp[1] = xdigit[mashed % 16];
				encrypted_value = encrypted_value + (new String(temp));
			}
		}
		return encrypted_value;
	}

}