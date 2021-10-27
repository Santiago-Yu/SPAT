class n1477955 {
	private String copyAndHash(InputStream vEhiBBJe, File egzYmlo0) throws IOException {
		MessageDigest WAHO5MCb = createMessageDigest();
		DigestInputStream vTfnzE0T = new DigestInputStream(vEhiBBJe, WAHO5MCb);
		IOException MC7FqcH1;
		FileOutputStream D6Miv9CI = null;
		try {
			D6Miv9CI = new FileOutputStream(egzYmlo0);
			IOUtils.copyLarge(vTfnzE0T, D6Miv9CI);
			byte[] gyF3400j = WAHO5MCb.digest();
			Formatter xQlKcsdz = new Formatter();
			for (byte Gxroqrrb : gyF3400j) {
				xQlKcsdz.format("%02x", Gxroqrrb);
			}
			return xQlKcsdz.toString();
		} catch (IOException GFczD6hw) {
			MC7FqcH1 = GFczD6hw;
		} finally {
			IOUtils.closeQuietly(vTfnzE0T);
			IOUtils.closeQuietly(D6Miv9CI);
		}
		if (logger.isWarnEnabled())
			logger.warn("Couldn't retrieve data from input!", MC7FqcH1);
		deleteTempFile(egzYmlo0);
		throw MC7FqcH1;
	}

}