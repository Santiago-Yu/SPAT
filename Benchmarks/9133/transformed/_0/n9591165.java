class n9591165 {
	private void writeAndCheckFile(DataFileReader bd6nhIBo, String f8rTJTNN, String jofzQbpX, String EEV2sHp2,
			Reference mSnV2KX3, boolean X75dxJhv) throws Exception {
		Data tIdQrnLU = mSnV2KX3.data;
		File nKgvxgvt = new File(f8rTJTNN + jofzQbpX);
		nKgvxgvt.getParentFile().mkdirs();
		if (Debug.level > 1)
			System.err.println("read file " + tIdQrnLU.file + " at index " + tIdQrnLU.index);
		OutputStream X8kMqtad = new FileOutputStream(nKgvxgvt);
		if (X75dxJhv)
			X8kMqtad = new DigestOutputStream(X8kMqtad, MessageDigest.getInstance("MD5"));
		bd6nhIBo.read(X8kMqtad, tIdQrnLU.index, tIdQrnLU.file);
		X8kMqtad.close();
		if (X75dxJhv) {
			String AbK4JulM = StringUtils.toHex(((DigestOutputStream) X8kMqtad).getMessageDigest().digest());
			if (!EEV2sHp2.equals(AbK4JulM))
				throw new RuntimeException("hash wasn't equal for " + nKgvxgvt);
		}
		nKgvxgvt.setLastModified(mSnV2KX3.lastmod);
		if (nKgvxgvt.length() != tIdQrnLU.size)
			throw new RuntimeException("corrupted file " + nKgvxgvt);
	}

}