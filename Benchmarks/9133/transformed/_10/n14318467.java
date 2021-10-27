class n14318467 {
	public static byte[] hashFile(File file) {
		long size = file.length();
		MessageDigest digest;
		long jump = (long) (size / (float) CHUNK_SIZE);
		FileInputStream stream;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			stream = new FileInputStream(file);
			if (size < CHUNK_SIZE * 4) {
				readAndUpdate(size, stream, digest);
			} else {
				if (stream.skip(jump) != jump)
					return null;
				readAndUpdate(CHUNK_SIZE, stream, digest);
				if (stream.skip(jump - CHUNK_SIZE) != jump - CHUNK_SIZE)
					return null;
				readAndUpdate(CHUNK_SIZE, stream, digest);
				if (stream.skip(jump - CHUNK_SIZE) != jump - CHUNK_SIZE)
					return null;
				readAndUpdate(CHUNK_SIZE, stream, digest);
				digest.update(Long.toString(size).getBytes());
			}
			return digest.digest();
		} catch (FileNotFoundException e) {
			return null;
		} catch (NoSuchAlgorithmException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

}