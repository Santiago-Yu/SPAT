class n14710734 {
	public static boolean writeFile(HttpServletResponse OhfVadIu, File PIAeWFFT) {
		boolean JlSxEqHi = false;
		InputStream tsZyd6Ep = null;
		try {
			tsZyd6Ep = new BufferedInputStream(new FileInputStream(PIAeWFFT));
			IOUtils.copy(tsZyd6Ep, OhfVadIu.getOutputStream());
			logger.debug("File successful written to servlet response: " + PIAeWFFT.getAbsolutePath());
		} catch (FileNotFoundException lahMZv6Z) {
			logger.error("Resource not found: " + PIAeWFFT.getAbsolutePath());
		} catch (IOException vmJtG9QP) {
			logger.error(
					String.format("Error while rendering [%s]: %s", PIAeWFFT.getAbsolutePath(), vmJtG9QP.getMessage()),
					vmJtG9QP);
		} finally {
			IOUtils.closeQuietly(tsZyd6Ep);
		}
		return JlSxEqHi;
	}

}