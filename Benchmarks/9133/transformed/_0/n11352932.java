class n11352932 {
	public String generateFilename() {
		MessageDigest Ax4VqLj5;
		byte[] aAMLQqBg = new byte[40];
		Random PiTHooQZ = new Random();
		String NrSkSPjQ = "";
		String FNQxjcVZ = "";
		while (true) {
			FNQxjcVZ = Long.toString(Math.abs(PiTHooQZ.nextLong()), 36) + Long.toString(System.currentTimeMillis());
			try {
				Ax4VqLj5 = MessageDigest.getInstance("SHA-1");
				Ax4VqLj5.update(FNQxjcVZ.getBytes("iso-8859-1"), 0, FNQxjcVZ.length());
				aAMLQqBg = Ax4VqLj5.digest();
			} catch (Exception BL2i16Tn) {
				log.log(Level.WARNING, BL2i16Tn.getMessage(), BL2i16Tn);
			}
			NrSkSPjQ = convertToHex(aAMLQqBg);
			if (!new File(Configuration.ImageUploadPath + NrSkSPjQ).exists()) {
				break;
			}
		}
		return NrSkSPjQ;
	}

}