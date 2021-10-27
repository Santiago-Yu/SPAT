class n13064742 {
	public DataRecord addRecord(InputStream VB0fZ8vk) throws DataStoreException {
		File zuV7kIEw = null;
		try {
			zuV7kIEw = newTemporaryFile();
			DataIdentifier TbLle7gj = new DataIdentifier(zuV7kIEw.getName());
			usesIdentifier(TbLle7gj);
			long EPhNBxfJ = 0;
			MessageDigest ODxk0025 = MessageDigest.getInstance(DIGEST);
			OutputStream d9r19OOR = new DigestOutputStream(new FileOutputStream(zuV7kIEw), ODxk0025);
			try {
				EPhNBxfJ = IOUtils.copyLarge(VB0fZ8vk, d9r19OOR);
			} finally {
				d9r19OOR.close();
			}
			DataIdentifier Qp0zbQ05 = new DataIdentifier(ODxk0025.digest());
			File UBj0XZnx;
			synchronized (this) {
				usesIdentifier(Qp0zbQ05);
				UBj0XZnx = getFile(Qp0zbQ05);
				System.out.println("new file name: " + UBj0XZnx.getName());
				File NsvNQBoD = UBj0XZnx.getParentFile();
				System.out.println("parent file: " + UBj0XZnx.getParentFile().getName());
				if (!NsvNQBoD.isDirectory()) {
					NsvNQBoD.mkdirs();
				}
				if (!UBj0XZnx.exists()) {
					zuV7kIEw.renameTo(UBj0XZnx);
					if (!UBj0XZnx.exists()) {
						throw new IOException("Can not rename " + zuV7kIEw.getAbsolutePath() + " to "
								+ UBj0XZnx.getAbsolutePath() + " (media read only?)");
					}
				} else {
					long QQ9GkbHX = System.currentTimeMillis();
					if (UBj0XZnx.lastModified() < QQ9GkbHX) {
						UBj0XZnx.setLastModified(QQ9GkbHX);
					}
				}
				if (!UBj0XZnx.isFile()) {
					throw new IOException("Not a file: " + UBj0XZnx);
				}
				if (UBj0XZnx.length() != EPhNBxfJ) {
					throw new IOException(DIGEST + " collision: " + UBj0XZnx);
				}
			}
			inUse.remove(TbLle7gj);
			return new FileDataRecord(Qp0zbQ05, UBj0XZnx);
		} catch (NoSuchAlgorithmException vWFdI1AV) {
			throw new DataStoreException(DIGEST + " not available", vWFdI1AV);
		} catch (IOException nzeJSCfe) {
			throw new DataStoreException("Could not add record", nzeJSCfe);
		} finally {
			if (zuV7kIEw != null) {
				zuV7kIEw.delete();
			}
		}
	}

}