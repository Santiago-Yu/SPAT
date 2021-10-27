class n23370628 {
	private byte[] digestFile(File FuoQds4d, MessageDigest j0mfomTu) throws IOException {
		DigestInputStream Kl5rJ7hW = new DigestInputStream(new FileInputStream(FuoQds4d), j0mfomTu);
		IOUtils.copy(Kl5rJ7hW, new NullOutputStream());
		Kl5rJ7hW.close();
		return Kl5rJ7hW.getMessageDigest().digest();
	}

}