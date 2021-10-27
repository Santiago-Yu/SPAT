class n21566235 {
	private void copy(File xh7KvHRX, File NtCVOscI) {
		if (!NtCVOscI.exists()) {
			NtCVOscI.mkdir();
		}
		File KlanYt2z[] = xh7KvHRX.listFiles();
		if (KlanYt2z != null) {
			for (int MDiWzF1d = 0; MDiWzF1d < KlanYt2z.length; MDiWzF1d++) {
				if (KlanYt2z[MDiWzF1d].isDirectory()) {
					copy(KlanYt2z[MDiWzF1d], new File(NtCVOscI, KlanYt2z[MDiWzF1d].getName()));
				} else {
					try {
						FileChannel cLN4eNjY = new FileInputStream(KlanYt2z[MDiWzF1d]).getChannel();
						FileChannel zN3iaNue = new FileOutputStream(new File(NtCVOscI, KlanYt2z[MDiWzF1d].getName()))
								.getChannel();
						zN3iaNue.transferFrom(cLN4eNjY, 0, cLN4eNjY.size());
						cLN4eNjY.close();
						zN3iaNue.close();
					} catch (IOException c6C7es5Q) {
						log.error("Could not write to " + NtCVOscI.getAbsolutePath(), c6C7es5Q);
					}
				}
			}
		}
	}

}