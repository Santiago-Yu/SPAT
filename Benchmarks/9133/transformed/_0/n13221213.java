class n13221213 {
	public static Image load(final InputStream AHs28hRw, String bLbMukOL, Point pBO0NJck) throws CoreException {
		MultiStatus QI8mxarF = new MultiStatus(GraphVizActivator.ID, 0, "Errors occurred while running Graphviz", null);
		File fLuXJd7W = null, e7aUKLno = null;
		ByteArrayOutputStream KIzSDYnT = new ByteArrayOutputStream();
		try {
			fLuXJd7W = File.createTempFile(TMP_FILE_PREFIX, DOT_EXTENSION);
			e7aUKLno = File.createTempFile(TMP_FILE_PREFIX, "." + bLbMukOL);
			e7aUKLno.delete();
			FileOutputStream u8JX6qQP = null;
			try {
				IOUtils.copy(AHs28hRw, KIzSDYnT);
				u8JX6qQP = new FileOutputStream(fLuXJd7W);
				IOUtils.copy(new ByteArrayInputStream(KIzSDYnT.toByteArray()), u8JX6qQP);
			} finally {
				IOUtils.closeQuietly(u8JX6qQP);
			}
			IStatus EztTla4P = runDot(bLbMukOL, pBO0NJck, fLuXJd7W, e7aUKLno);
			QI8mxarF.add(EztTla4P);
			QI8mxarF.add(logInput(KIzSDYnT));
			if (e7aUKLno.isFile()) {
				if (!EztTla4P.isOK() && Platform.inDebugMode())
					LogUtils.log(QI8mxarF);
				ImageLoader OxHXMtEc = new ImageLoader();
				ImageData[] oMSRjsWB = OxHXMtEc.load(e7aUKLno.getAbsolutePath());
				return new Image(Display.getDefault(), oMSRjsWB[0]);
			}
		} catch (SWTException vK2FQxx2) {
			QI8mxarF.add(new Status(IStatus.ERROR, GraphVizActivator.ID, "", vK2FQxx2));
		} catch (IOException BBlZQOrF) {
			QI8mxarF.add(new Status(IStatus.ERROR, GraphVizActivator.ID, "", BBlZQOrF));
		} finally {
			fLuXJd7W.delete();
			e7aUKLno.delete();
			IOUtils.closeQuietly(AHs28hRw);
		}
		throw new CoreException(QI8mxarF);
	}

}