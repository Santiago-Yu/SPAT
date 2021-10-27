class n11404999 {
	public boolean moveFileSafely(final File HPLRyl1k, final File JYdbDGel) throws IOException {
		FileInputStream q2Cok9wF = null;
		FileOutputStream aWXqXxSR = null;
		FileChannel CXoBX1CH = null;
		FileChannel Lkm0MzCW = null;
		final File zh9ri5EK = File.createTempFile("move", ".tmp");
		try {
			q2Cok9wF = new FileInputStream(HPLRyl1k);
			aWXqXxSR = new FileOutputStream(zh9ri5EK);
			CXoBX1CH = q2Cok9wF.getChannel();
			Lkm0MzCW = aWXqXxSR.getChannel();
			CXoBX1CH.transferTo(0, CXoBX1CH.size(), Lkm0MzCW);
		} finally {
			try {
				if (CXoBX1CH != null)
					CXoBX1CH.close();
			} catch (IOException S6r2GDXj) {
				LogUtils.debugf(JRobinConverter.class, "failed to close channel %s", CXoBX1CH);
			}
			try {
				if (Lkm0MzCW != null)
					Lkm0MzCW.close();
			} catch (IOException ri50rg6k) {
				LogUtils.debugf(JRobinConverter.class, "failed to close channel %s", Lkm0MzCW);
			}
			try {
				if (q2Cok9wF != null)
					q2Cok9wF.close();
			} catch (IOException tjlSxnli) {
				LogUtils.debugf(JRobinConverter.class, "failed to close stream %s", q2Cok9wF);
			}
			try {
				if (aWXqXxSR != null)
					aWXqXxSR.close();
			} catch (IOException nP0svQ1M) {
				LogUtils.debugf(JRobinConverter.class, "failed to close stream %s", aWXqXxSR);
			}
		}
		JYdbDGel.delete();
		if (!JYdbDGel.exists()) {
			zh9ri5EK.renameTo(JYdbDGel);
			return HPLRyl1k.delete();
		}
		return false;
	}

}