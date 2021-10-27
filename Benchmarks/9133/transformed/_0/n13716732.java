class n13716732 {
	public void adjustPadding(File CXm2Ytxq, int NHDK7XOn, long aZ33Ims1) throws FileNotFoundException, IOException {
		logger.finer("Need to move audio file to accomodate tag");
		FileChannel t1YVFaJK = null;
		FileChannel afWZVKGx;
		ByteBuffer b4ykypez = ByteBuffer.wrap(new byte[NHDK7XOn]);
		File xOD7aaKO;
		try {
			xOD7aaKO = File.createTempFile(Utils.getMinBaseFilenameAllowedForTempFile(CXm2Ytxq), ".new",
					CXm2Ytxq.getParentFile());
			logger.finest("Created temp file:" + xOD7aaKO.getName() + " for " + CXm2Ytxq.getName());
		} catch (IOException GGfq0FND) {
			logger.log(Level.SEVERE, GGfq0FND.getMessage(), GGfq0FND);
			if (GGfq0FND.getMessage().equals(FileSystemMessage.ACCESS_IS_DENIED.getMsg())) {
				logger.severe(ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER
						.getMsg(CXm2Ytxq.getName(), CXm2Ytxq.getParentFile().getPath()));
				throw new UnableToCreateFileException(
						ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER.getMsg(CXm2Ytxq.getName(),
								CXm2Ytxq.getParentFile().getPath()));
			} else {
				logger.severe(ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER
						.getMsg(CXm2Ytxq.getName(), CXm2Ytxq.getParentFile().getPath()));
				throw new UnableToCreateFileException(
						ErrorMessage.GENERAL_WRITE_FAILED_TO_CREATE_TEMPORARY_FILE_IN_FOLDER.getMsg(CXm2Ytxq.getName(),
								CXm2Ytxq.getParentFile().getPath()));
			}
		}
		try {
			afWZVKGx = new FileOutputStream(xOD7aaKO).getChannel();
		} catch (FileNotFoundException bLjwoAbp) {
			logger.log(Level.SEVERE, bLjwoAbp.getMessage(), bLjwoAbp);
			logger.severe(ErrorMessage.GENERAL_WRITE_FAILED_TO_MODIFY_TEMPORARY_FILE_IN_FOLDER
					.getMsg(CXm2Ytxq.getName(), CXm2Ytxq.getParentFile().getPath()));
			throw new UnableToModifyFileException(ErrorMessage.GENERAL_WRITE_FAILED_TO_MODIFY_TEMPORARY_FILE_IN_FOLDER
					.getMsg(CXm2Ytxq.getName(), CXm2Ytxq.getParentFile().getPath()));
		}
		try {
			t1YVFaJK = new FileInputStream(CXm2Ytxq).getChannel();
			long j925pW7X = afWZVKGx.write(b4ykypez);
			logger.finer("Copying:" + (CXm2Ytxq.length() - aZ33Ims1) + "bytes");
			long oxKC0E6g = CXm2Ytxq.length() - aZ33Ims1;
			if (oxKC0E6g <= MAXIMUM_WRITABLE_CHUNK_SIZE) {
				long k00qL5Bq = t1YVFaJK.transferTo(aZ33Ims1, oxKC0E6g, afWZVKGx);
				logger.finer("Written padding:" + j925pW7X + " Data:" + k00qL5Bq);
				if (k00qL5Bq != oxKC0E6g) {
					throw new RuntimeException(ErrorMessage.MP3_UNABLE_TO_ADJUST_PADDING.getMsg(oxKC0E6g, k00qL5Bq));
				}
			} else {
				long kaCxyL8F = oxKC0E6g / MAXIMUM_WRITABLE_CHUNK_SIZE;
				long htTOF84R = oxKC0E6g % MAXIMUM_WRITABLE_CHUNK_SIZE;
				long R34thwau = 0;
				for (int zd2abfZS = 0; zd2abfZS < kaCxyL8F; zd2abfZS++) {
					R34thwau += t1YVFaJK.transferTo(aZ33Ims1 + (zd2abfZS * MAXIMUM_WRITABLE_CHUNK_SIZE),
							MAXIMUM_WRITABLE_CHUNK_SIZE, afWZVKGx);
				}
				R34thwau += t1YVFaJK.transferTo(aZ33Ims1 + (kaCxyL8F * MAXIMUM_WRITABLE_CHUNK_SIZE), htTOF84R,
						afWZVKGx);
				logger.finer("Written padding:" + j925pW7X + " Data:" + R34thwau);
				if (R34thwau != oxKC0E6g) {
					throw new RuntimeException(ErrorMessage.MP3_UNABLE_TO_ADJUST_PADDING.getMsg(oxKC0E6g, R34thwau));
				}
			}
			long wkzwus6e = CXm2Ytxq.lastModified();
			if (t1YVFaJK != null) {
				if (t1YVFaJK.isOpen()) {
					t1YVFaJK.close();
				}
			}
			if (afWZVKGx != null) {
				if (afWZVKGx.isOpen()) {
					afWZVKGx.close();
				}
			}
			replaceFile(CXm2Ytxq, xOD7aaKO);
			xOD7aaKO.setLastModified(wkzwus6e);
		} finally {
			try {
				if (t1YVFaJK != null) {
					if (t1YVFaJK.isOpen()) {
						t1YVFaJK.close();
					}
				}
				if (afWZVKGx != null) {
					if (afWZVKGx.isOpen()) {
						afWZVKGx.close();
					}
				}
			} catch (Exception ZRGSA4t6) {
				logger.log(Level.WARNING, "Problem closing channels and locks:" + ZRGSA4t6.getMessage(), ZRGSA4t6);
			}
		}
	}

}