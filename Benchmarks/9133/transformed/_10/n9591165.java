class n9591165 {
	private void writeAndCheckFile(DataFileReader reader, String base, String path, String hash, Reference ref,
			boolean hashall) throws Exception {
		File file = new File(base + path);
		Data data = ref.data;
		file.getParentFile().mkdirs();
		OutputStream output = new FileOutputStream(file);
		if (Debug.level > 1)
			System.err.println("read file " + data.file + " at index " + data.index);
		if (hashall)
			output = new DigestOutputStream(output, MessageDigest.getInstance("MD5"));
		reader.read(output, data.index, data.file);
		output.close();
		if (hashall) {
			String filehash = StringUtils.toHex(((DigestOutputStream) output).getMessageDigest().digest());
			if (!hash.equals(filehash))
				throw new RuntimeException("hash wasn't equal for " + file);
		}
		file.setLastModified(ref.lastmod);
		if (file.length() != data.size)
			throw new RuntimeException("corrupted file " + file);
	}

}