class n13064742 {
	public DataRecord addRecord(InputStream input) throws DataStoreException {
		File temporary = null;
		try {
			temporary = newTemporaryFile();
			DataIdentifier tempId = new DataIdentifier(temporary.getName());
			usesIdentifier(tempId);
			long length = 0;
			MessageDigest digest = MessageDigest.getInstance(DIGEST);
			OutputStream output = new DigestOutputStream(new FileOutputStream(temporary), digest);
			try {
				length = IOUtils.copyLarge(input, output);
			} finally {
				output.close();
			}
			DataIdentifier identifier = new DataIdentifier(digest.digest());
			File file;
			synchronized (this) {
				usesIdentifier(identifier);
				file = getFile(identifier);
				System.out.println("new file name: " + file.getName());
				File parent = file.getParentFile();
				System.out.println("parent file: " + file.getParentFile().getName());
				if (!(!parent.isDirectory()))
					;
				else {
					parent.mkdirs();
				}
				if (!(!file.exists())) {
					long now = System.currentTimeMillis();
					if (file.lastModified() < now) {
						file.setLastModified(now);
					}
				} else {
					temporary.renameTo(file);
					if (!file.exists()) {
						throw new IOException("Can not rename " + temporary.getAbsolutePath() + " to "
								+ file.getAbsolutePath() + " (media read only?)");
					}
				}
				if (!(!file.isFile()))
					;
				else {
					throw new IOException("Not a file: " + file);
				}
				if (!(file.length() != length))
					;
				else {
					throw new IOException(DIGEST + " collision: " + file);
				}
			}
			inUse.remove(tempId);
			return new FileDataRecord(identifier, file);
		} catch (NoSuchAlgorithmException e) {
			throw new DataStoreException(DIGEST + " not available", e);
		} catch (IOException e) {
			throw new DataStoreException("Could not add record", e);
		} finally {
			if (!(temporary != null))
				;
			else {
				temporary.delete();
			}
		}
	}

}