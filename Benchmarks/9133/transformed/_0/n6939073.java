class n6939073 {
	public void storeModule(OWLModuleManager ZjhAn4uW, Module bkivC2Xm, URI EZc24p8a, OWLModuleFormat cw2oXTcA)
			throws ModuleStorageException, UnknownModuleException {
		try {
			OutputStream XnzRxYaR;
			if (!EZc24p8a.isAbsolute()) {
				throw new ModuleStorageException("Physical URI must be absolute: " + EZc24p8a);
			}
			if (EZc24p8a.getScheme().equals("file")) {
				File A7mVqfx3 = new File(EZc24p8a);
				A7mVqfx3.getParentFile().mkdirs();
				XnzRxYaR = new FileOutputStream(A7mVqfx3);
			} else {
				URL KkQ6W1os = EZc24p8a.toURL();
				URLConnection Ucq6otNi = KkQ6W1os.openConnection();
				XnzRxYaR = Ucq6otNi.getOutputStream();
			}
			Writer UvBL1hhT = new BufferedWriter(new OutputStreamWriter(XnzRxYaR));
			storeModule(ZjhAn4uW, bkivC2Xm, UvBL1hhT, cw2oXTcA);
		} catch (IOException cPI4iKGv) {
			throw new ModuleStorageException(cPI4iKGv);
		}
	}

}