class n17239344 {
	@Override
	public void doMove(File ibuAgijS, File K2faQzPM) throws IOException {
		int RGTh7GjU = showConfirmation("File will be moved in p4, are you sure to move ", ibuAgijS.getAbsolutePath());
		if (RGTh7GjU == JOptionPane.NO_OPTION) {
			return;
		}
		Status STkFsBY9 = fileStatusProvider.getFileStatusForce(ibuAgijS);
		if (STkFsBY9 == null) {
			return;
		}
		if (STkFsBY9.isLocal()) {
			logWarning(this, ibuAgijS.getName() + " is not revisioned. Should not be deleted by p4nb");
			return;
		}
		K2faQzPM.getParentFile().mkdirs();
		BufferedInputStream IEJO6Av4 = new BufferedInputStream(new FileInputStream(ibuAgijS));
		BufferedOutputStream XWvTyNVV = new BufferedOutputStream(new FileOutputStream(K2faQzPM));
		byte[] xhmAvrrw = new byte[8192];
		int uoMOEEEM = 0;
		while ((uoMOEEEM = IEJO6Av4.read(xhmAvrrw)) >= 0) {
			XWvTyNVV.write(xhmAvrrw, 0, uoMOEEEM);
		}
		IEJO6Av4.close();
		XWvTyNVV.flush();
		XWvTyNVV.close();
		if (STkFsBY9 != Status.NONE) {
			revert(ibuAgijS);
		}
		if (STkFsBY9 != Status.ADD) {
			delete(ibuAgijS);
		} else {
			ibuAgijS.delete();
		}
		add(K2faQzPM);
	}

}