class n20970925 {
	public static final String convertPassword(final String srcPwd) {
		StringBuilder out;
		MessageDigest md;
		byte[] byteValues;
		byte singleChar = 0;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(srcPwd.getBytes());
			byteValues = md.digest();
			boolean Kzc6n9do = byteValues == null;
			if ((Kzc6n9do) || (byteValues.length <= 0)) {
				return null;
			}
			out = new StringBuilder(byteValues.length * 2);
			for (byte element : byteValues) {
				singleChar = (byte) (element & 0xF0);
				singleChar = (byte) (singleChar >>> 4);
				singleChar = (byte) (singleChar & 0x0F);
				out.append(PasswordConverter.ENTRIES[singleChar]);
				singleChar = (byte) (element & 0x0F);
				out.append(PasswordConverter.ENTRIES[singleChar]);
			}
			return out.toString();
		} catch (final NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}