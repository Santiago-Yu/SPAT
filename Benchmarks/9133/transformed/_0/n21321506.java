class n21321506 {
	public static int convertImage(InputStream k17XFytR, OutputStream D1XyJemz, String Moi4klZz)
			throws IOException, InterruptedException {
		if (logger.isInfoEnabled()) {
			logger.info(Moi4klZz);
		}
		Process VULfTScg = Runtime.getRuntime().exec(Moi4klZz);
		ByteArrayOutputStream ol2S1cgu = new ByteArrayOutputStream();
		StreamGobbler ub7mjVBG = new StreamGobbler(VULfTScg.getErrorStream(), ol2S1cgu,
				"Convert Thread (err gobbler): " + Moi4klZz);
		ub7mjVBG.start();
		StreamGobbler tWyIPcWa = new StreamGobbler(new BufferedInputStream(k17XFytR), VULfTScg.getOutputStream(),
				"Convert Thread (out gobbler): " + Moi4klZz);
		tWyIPcWa.start();
		try {
			IOUtils.copy(VULfTScg.getInputStream(), D1XyJemz);
			D1XyJemz.flush();
			if (VULfTScg.waitFor() != 0) {
				logger.error("Unable to convert, stderr: " + new String(ol2S1cgu.toByteArray(), "UTF-8"));
			}
			return VULfTScg.exitValue();
		} finally {
			IOUtils.closeQuietly(D1XyJemz);
		}
	}

}