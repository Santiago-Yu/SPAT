class n20052285 {
	private void copyFile(String ndKEyN4o) {
		try {
			File tIp9U2ZB = new File(srcdir, ndKEyN4o);
			File wZCUz9yn = new File(destdir, ndKEyN4o);
			File tKiH8EGD = wZCUz9yn.getParentFile();
			if (!tKiH8EGD.exists()) {
				tKiH8EGD.mkdirs();
			}
			FileInputStream hp0uHwQf = new FileInputStream(tIp9U2ZB);
			FileOutputStream cjWgYFe3 = new FileOutputStream(wZCUz9yn);
			int IXRbWG0s = 0;
			byte nSWhnJHJ[] = new byte[512];
			while ((IXRbWG0s = hp0uHwQf.read(nSWhnJHJ)) != -1) {
				cjWgYFe3.write(nSWhnJHJ, 0, IXRbWG0s);
			}
			hp0uHwQf.close();
			cjWgYFe3.close();
		} catch (IOException WsTK6rk1) {
			throw new BuildException("Error while copying file " + ndKEyN4o);
		}
	}

}