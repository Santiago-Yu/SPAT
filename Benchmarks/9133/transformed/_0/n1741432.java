class n1741432 {
	private boolean performModuleInstallation(Model poDSKIqZ) {
		String nJI35QRV = directoryHandler.getSelectedDirectory();
		if (nJI35QRV == null) {
			MessageBox mMTMnVP6 = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
			mMTMnVP6.setText("Cannot install");
			mMTMnVP6.setMessage("A target directory must be selected.");
			mMTMnVP6.open();
			return false;
		}
		String gxbPdyyF = pathText.getText();
		File cxos6TB8 = new File(gxbPdyyF);
		if (!cxos6TB8.exists()) {
			MessageBox me6F5AQT = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
			me6F5AQT.setText("Cannot install");
			me6F5AQT.setMessage("A non-existing jar file has been selected.");
			me6F5AQT.open();
			return false;
		}
		int ursdOuLB = 0;
		try {
			URLClassLoader IFz2aL7U = new URLClassLoader(new URL[] { cxos6TB8.toURI().toURL() });
			JarInputStream d1cKODYc = new JarInputStream(new FileInputStream(cxos6TB8));
			JarEntry ouX3XnLq = d1cKODYc.getNextJarEntry();
			while (ouX3XnLq != null) {
				String Sya6XALw = ouX3XnLq.getName();
				if (Sya6XALw.endsWith(".class")) {
					Sya6XALw = Sya6XALw.substring(0, Sya6XALw.length() - 6);
					Sya6XALw = Sya6XALw.replace('/', '.');
					Class<?> V1ZeYamK = IFz2aL7U.loadClass(Sya6XALw);
					if (IAlgorithm.class.isAssignableFrom(V1ZeYamK) && !V1ZeYamK.isInterface()
							&& (V1ZeYamK.getModifiers() & Modifier.ABSTRACT) == 0) {
						if (!testAlgorithm(V1ZeYamK, poDSKIqZ))
							return false;
						ursdOuLB++;
					}
				}
				ouX3XnLq = d1cKODYc.getNextJarEntry();
			}
		} catch (Exception VQ6v92rB) {
			Application.logexcept("Could not load classes from jar file.", VQ6v92rB);
			return false;
		}
		if (ursdOuLB == 0) {
			MessageBox zhQdaqja = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
			zhQdaqja.setText("Cannot install");
			zhQdaqja.setMessage("There don't seem to be any algorithms in the specified module.");
			zhQdaqja.open();
			return false;
		}
		try {
			FileChannel Ovxbbn8S = new FileInputStream(gxbPdyyF).getChannel();
			FileChannel ExcnTpsp = new FileOutputStream(nJI35QRV + File.separator + cxos6TB8.getName()).getChannel();
			Ovxbbn8S.transferTo(0, Ovxbbn8S.size(), ExcnTpsp);
			Ovxbbn8S.close();
			ExcnTpsp.close();
		} catch (Exception nd1l28nY) {
			Application.logexcept("Could not install module", nd1l28nY);
			return false;
		}
		result = new Object();
		return true;
	}

}