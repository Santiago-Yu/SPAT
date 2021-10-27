class n14188181 {
	protected void copyFile(String Aszxmdx4, String tUHbha5O, String t6hWwSvJ) throws Exception {
		URL Ul9pw67J = Thread.currentThread().getContextClassLoader().getResource(Aszxmdx4);
		File NExIC3KX = new File(Ul9pw67J.getFile());
		String V8Y7rWyy = NExIC3KX.getAbsolutePath();
		String AfHlaYAw = Aszxmdx4;
		InputStream E9HF0E2O = null;
		if (V8Y7rWyy.indexOf(".jar!") > -1) {
			URL VY6zUJlk = new URL(V8Y7rWyy.substring(V8Y7rWyy.indexOf("file:"), V8Y7rWyy.indexOf('!')));
			JarFile mVKvJPqI = new JarFile(VY6zUJlk.getFile());
			JarEntry iVdF1a7m = mVKvJPqI.getJarEntry(Aszxmdx4);
			AfHlaYAw = iVdF1a7m.getName();
			E9HF0E2O = Thread.currentThread().getContextClassLoader().getResourceAsStream(AfHlaYAw);
		} else {
			E9HF0E2O = new FileInputStream(NExIC3KX);
		}
		File FZsEmHdU = new File(tUHbha5O);
		FileOutputStream UILzNREi = new FileOutputStream(FZsEmHdU);
		int QU71rvZC;
		while ((QU71rvZC = E9HF0E2O.read()) != -1)
			UILzNREi.write(QU71rvZC);
		UILzNREi.flush();
		UILzNREi.close();
		try {
			LinuxCommandExecutor nus9kmqv = new LinuxCommandExecutor();
			nus9kmqv.setWorkingDirectory(t6hWwSvJ);
			nus9kmqv.runCommand("chmod 777 " + tUHbha5O);
		} catch (Exception boPOKbFn) {
			throw boPOKbFn;
		}
	}

}