class n6421904 {
	public DataRecord addRecord(InputStream kHxD4esZ) throws DataStoreException {
		File bHQOaMtg = null;
		try {
			bHQOaMtg = newTemporaryFile();
			DataIdentifier t82pSp81 = new DataIdentifier(bHQOaMtg.getName());
			usesIdentifier(t82pSp81);
			long yLNr3kby = 0;
			MessageDigest puiF1fGH = MessageDigest.getInstance(DIGEST);
			OutputStream ToorYB9t = new DigestOutputStream(new FileOutputStream(bHQOaMtg), puiF1fGH);
			try {
				yLNr3kby = IOUtils.copyLarge(kHxD4esZ, ToorYB9t);
			} finally {
				ToorYB9t.close();
			}
			DataIdentifier uHbLjcgW = new DataIdentifier(puiF1fGH.digest());
			File w0dtGZVD;
			synchronized (this) {
				usesIdentifier(uHbLjcgW);
				w0dtGZVD = getFile(uHbLjcgW);
				if (!w0dtGZVD.exists()) {
					File TM6OPCmA = w0dtGZVD.getParentFile();
					TM6OPCmA.mkdirs();
					if (bHQOaMtg.renameTo(w0dtGZVD)) {
						bHQOaMtg = null;
					} else {
						throw new IOException("Can not rename " + bHQOaMtg.getAbsolutePath() + " to "
								+ w0dtGZVD.getAbsolutePath() + " (media read only?)");
					}
				} else {
					long sx6wWGNf = System.currentTimeMillis();
					if (getLastModified(w0dtGZVD) < sx6wWGNf + ACCESS_TIME_RESOLUTION) {
						setLastModified(w0dtGZVD, sx6wWGNf + ACCESS_TIME_RESOLUTION);
					}
				}
				if (w0dtGZVD.length() != yLNr3kby) {
					if (!w0dtGZVD.isFile()) {
						throw new IOException("Not a file: " + w0dtGZVD);
					}
					throw new IOException(DIGEST + " collision: " + w0dtGZVD);
				}
			}
			inUse.remove(t82pSp81);
			return new FileDataRecord(uHbLjcgW, w0dtGZVD);
		} catch (NoSuchAlgorithmException MbVUyApu) {
			throw new DataStoreException(DIGEST + " not available", MbVUyApu);
		} catch (IOException PjGtvidA) {
			throw new DataStoreException("Could not add record", PjGtvidA);
		} finally {
			if (bHQOaMtg != null) {
				bHQOaMtg.delete();
			}
		}
	}

}