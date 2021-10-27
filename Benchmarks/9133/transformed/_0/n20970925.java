class n20970925 {
	public static final String convertPassword(final String Jm56dNYG) {
		StringBuilder VQrJZwBy;
		MessageDigest bVr32f1b;
		byte[] N8Tcmzmf;
		byte wdLIjnzs = 0;
		try {
			bVr32f1b = MessageDigest.getInstance("MD5");
			bVr32f1b.update(Jm56dNYG.getBytes());
			N8Tcmzmf = bVr32f1b.digest();
			if ((N8Tcmzmf == null) || (N8Tcmzmf.length <= 0)) {
				return null;
			}
			VQrJZwBy = new StringBuilder(N8Tcmzmf.length * 2);
			for (byte da6qlwSn : N8Tcmzmf) {
				wdLIjnzs = (byte) (da6qlwSn & 0xF0);
				wdLIjnzs = (byte) (wdLIjnzs >>> 4);
				wdLIjnzs = (byte) (wdLIjnzs & 0x0F);
				VQrJZwBy.append(PasswordConverter.ENTRIES[wdLIjnzs]);
				wdLIjnzs = (byte) (da6qlwSn & 0x0F);
				VQrJZwBy.append(PasswordConverter.ENTRIES[wdLIjnzs]);
			}
			return VQrJZwBy.toString();
		} catch (final NoSuchAlgorithmException HDQ7v7Gn) {
			HDQ7v7Gn.printStackTrace();
			return null;
		}
	}

}