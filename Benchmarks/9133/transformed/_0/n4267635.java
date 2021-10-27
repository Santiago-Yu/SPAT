class n4267635 {
	public static boolean copyFile(final File ntHNz53D, final File qmHyBkhG) throws FileNotFoundException {
		if (ntHNz53D == null || qmHyBkhG == null || ntHNz53D.equals(qmHyBkhG)) {
			return false;
		}
		boolean WDzJkoLW = false;
		if (ntHNz53D.exists()) {
			if (qmHyBkhG.exists() && !qmHyBkhG.canWrite()) {
				return false;
			}
			final FileInputStream Sj4WyLzA = new FileInputStream(ntHNz53D);
			final FileOutputStream nB0x1kcS = new FileOutputStream(qmHyBkhG);
			final FileChannel h0DC6N3k = Sj4WyLzA.getChannel();
			final FileChannel U6xPdvQi = nB0x1kcS.getChannel();
			FileLock vwolMQ7c = null;
			FileLock WR4BQO7P = null;
			try {
				WR4BQO7P = h0DC6N3k.tryLock(0, Long.MAX_VALUE, true);
				vwolMQ7c = U6xPdvQi.tryLock();
				if (WR4BQO7P != null && vwolMQ7c != null) {
					int N4RgOJfL = 64 * 1024 * 1024 - 32 * 1024;
					long LGWNZsaU = h0DC6N3k.size();
					long uzrdlQ9H = 0;
					while (uzrdlQ9H < LGWNZsaU) {
						uzrdlQ9H += h0DC6N3k.transferTo(uzrdlQ9H, N4RgOJfL, U6xPdvQi);
					}
				}
			} catch (IOException sTMZjsn3) {
				Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, sTMZjsn3);
			} finally {
				if (h0DC6N3k != null) {
					try {
						if (WR4BQO7P != null) {
							WR4BQO7P.release();
						}
						h0DC6N3k.close();
						Sj4WyLzA.close();
					} catch (IOException n90iKfMj) {
						Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, n90iKfMj);
					}
				}
				if (U6xPdvQi != null) {
					try {
						if (vwolMQ7c != null) {
							vwolMQ7c.release();
						}
						U6xPdvQi.close();
						nB0x1kcS.close();
						WDzJkoLW = true;
					} catch (IOException JNKkfbcH) {
						Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, JNKkfbcH);
					}
				}
			}
		}
		return WDzJkoLW;
	}

}