class n13221212 {
	public static void generate(final InputStream mHwuO4gW, String YozDwwNw, Point SmJMi9gx, IPath mwPMUL4F)
			throws CoreException {
		MultiStatus HTuHGIfW = new MultiStatus(GraphVizActivator.ID, 0, "Errors occurred while running Graphviz", null);
		File ypxUgijJ = null, T52YLUi6 = mwPMUL4F.toFile();
		ByteArrayOutputStream AxESXCwo = new ByteArrayOutputStream();
		try {
			ypxUgijJ = File.createTempFile(TMP_FILE_PREFIX, DOT_EXTENSION);
			FileOutputStream P0ErZYaa = null;
			try {
				IOUtils.copy(mHwuO4gW, AxESXCwo);
				P0ErZYaa = new FileOutputStream(ypxUgijJ);
				IOUtils.copy(new ByteArrayInputStream(AxESXCwo.toByteArray()), P0ErZYaa);
			} finally {
				IOUtils.closeQuietly(P0ErZYaa);
			}
			IStatus k8tIDJDZ = runDot(YozDwwNw, SmJMi9gx, ypxUgijJ, T52YLUi6);
			if (T52YLUi6.isFile()) {
				if (!k8tIDJDZ.isOK() && Platform.inDebugMode())
					LogUtils.log(HTuHGIfW);
				return;
			}
		} catch (IOException bzxYs4kO) {
			HTuHGIfW.add(new Status(IStatus.ERROR, GraphVizActivator.ID, "", bzxYs4kO));
		} finally {
			ypxUgijJ.delete();
			IOUtils.closeQuietly(mHwuO4gW);
		}
		throw new CoreException(HTuHGIfW);
	}

}