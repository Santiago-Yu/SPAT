class n11352932 {
	public String generateFilename() {
		byte[] sha1hash = new byte[40];
		MessageDigest md;
		String fileName = "";
		Random r = new Random();
		String token = "";
		while (true) {
			token = Long.toString(Math.abs(r.nextLong()), 36) + Long.toString(System.currentTimeMillis());
			try {
				md = MessageDigest.getInstance("SHA-1");
				md.update(token.getBytes("iso-8859-1"), 0, token.length());
				sha1hash = md.digest();
			} catch (Exception e) {
				log.log(Level.WARNING, e.getMessage(), e);
			}
			fileName = convertToHex(sha1hash);
			if (!new File(Configuration.ImageUploadPath + fileName).exists()) {
				break;
			}
		}
		return fileName;
	}

}