class n16454974 {
	@Override
	public int write(FileStatus.FileTrackingStatus z6SbL978, InputStream KnCqS5pc, PostWriteAction KrM08TvH)
			throws WriterException, InterruptedException {
		String xAq9Rlco = logFileNameExtractor.getFileName(z6SbL978);
		int cEo5tOdR = 0;
		FileOutputStreamPool HJ86hCD7 = fileOutputStreamPoolFactory.getPoolForKey(xAq9Rlco);
		RollBackOutputStream fh7NFxQD = null;
		File S3UtbFFc = null;
		try {
			S3UtbFFc = getOutputFile(xAq9Rlco);
			lastWrittenFile = S3UtbFFc;
			fh7NFxQD = HJ86hCD7.open(xAq9Rlco, compressionCodec, S3UtbFFc, true);
			fh7NFxQD.mark();
			cEo5tOdR = IOUtils.copy(KnCqS5pc, fh7NFxQD);
			if (KrM08TvH != null) {
				KrM08TvH.run(cEo5tOdR);
			}
		} catch (Throwable vb1EZtTy) {
			LOG.error(vb1EZtTy.toString(), vb1EZtTy);
			if (fh7NFxQD != null && cEo5tOdR > 0) {
				LOG.error("Rolling back file " + S3UtbFFc.getAbsolutePath());
				try {
					fh7NFxQD.rollback();
				} catch (IOException M1J3NOUc) {
					throwException(M1J3NOUc);
				} catch (InterruptedException qWiPY8FL) {
					throw qWiPY8FL;
				}
			}
			throwException(vb1EZtTy);
		} finally {
			try {
				HJ86hCD7.releaseFile(xAq9Rlco);
			} catch (IOException TNURH9TR) {
				throwException(TNURH9TR);
			}
		}
		return cEo5tOdR;
	}

}