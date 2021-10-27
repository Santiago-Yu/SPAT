class n3436001 {
	public static void copyFile(File in, File out) {
		if (!in.exists() || !in.canRead()) {
			LOGGER.warn("Can't copy file : " + in);
			return;
		}
		if (!out.getParentFile().exists()) {
			if (!out.getParentFile().mkdirs()) {
				LOGGER.info("Didn't create parent directories : " + out.getParentFile().getAbsolutePath());
			}
		}
		if (!out.exists()) {
			try {
				out.createNewFile();
			} catch (IOException e) {
				LOGGER.error("Exception creating new file : " + out.getAbsolutePath(), e);
			}
		}
		LOGGER.debug("Copying file : " + in + ", to : " + out);
		FileChannel outChannel = null;
		FileChannel inChannel = null;
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(in);
			fileOutputStream = new FileOutputStream(out);
			inChannel = fileInputStream.getChannel();
			outChannel = fileOutputStream.getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (Exception e) {
			LOGGER.error("Exception copying file : " + in + ", to : " + out, e);
		} finally {
			close(fileInputStream);
			close(fileOutputStream);
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (Exception e) {
					LOGGER.error("Exception closing input channel : ", e);
				}
			}
			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (Exception e) {
					LOGGER.error("Exception closing output channel : ", e);
				}
			}
		}
	}

}