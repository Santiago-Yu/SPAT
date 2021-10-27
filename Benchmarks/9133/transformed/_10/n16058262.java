class n16058262 {
	public static boolean copyFile(final File src, final File dest, long extent, final boolean overwrite)
			throws FileNotFoundException, IOException {
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.fine("Copying file " + src + " to " + dest + " extent " + extent + " exists " + dest.exists());
		}
		boolean result = false;
		FileInputStream fis = null;
		if (dest.exists()) {
			if (overwrite) {
				dest.delete();
				LOGGER.finer(dest.getAbsolutePath() + " removed before copy.");
			} else {
				return result;
			}
		}
		FileChannel fcin = null;
		FileOutputStream fos = null;
		FileChannel fcout = null;
		try {
			fos = new FileOutputStream(dest);
			fis = new FileInputStream(src);
			fcin = fis.getChannel();
			fcout = fos.getChannel();
			if (extent < 0) {
				extent = fcin.size();
			}
			long trans = fcin.transferTo(0, extent, fcout);
			if (trans < extent) {
				result = false;
			}
			result = true;
		} catch (IOException e) {
			String message = "Copying " + src.getAbsolutePath() + " to " + dest.getAbsolutePath() + " with extent "
					+ extent + " got IOE: " + e.getMessage();
			if (e.getMessage().equals("Invalid argument")) {
				LOGGER.severe("Failed copy, trying workaround: " + message);
				workaroundCopyFile(src, dest);
			} else {
				IOException newE = new IOException(message);
				newE.setStackTrace(e.getStackTrace());
				throw newE;
			}
		} finally {
			if (fcin != null) {
				fcin.close();
			}
			if (fcout != null) {
				fcout.close();
			}
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
		return result;
	}

}