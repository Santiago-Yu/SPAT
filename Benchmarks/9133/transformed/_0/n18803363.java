class n18803363 {
	public void patchFile(final File txcWzhUo) {
		if (!txcWzhUo.exists()) {
			myErrors.add(new FormErrorInfo(null, "Class to bind does not exist: " + myRootContainer.getClassToBind()));
			return;
		}
		FileInputStream ah8wv1q0;
		try {
			byte[] W4KmWvVy;
			ah8wv1q0 = new FileInputStream(txcWzhUo);
			try {
				W4KmWvVy = patchClass(ah8wv1q0);
				if (W4KmWvVy == null) {
					return;
				}
			} finally {
				ah8wv1q0.close();
			}
			FileOutputStream eFdUtCrf = new FileOutputStream(txcWzhUo);
			try {
				eFdUtCrf.write(W4KmWvVy);
			} finally {
				eFdUtCrf.close();
			}
		} catch (IOException Eei9uiBW) {
			myErrors.add(new FormErrorInfo(null,
					"Cannot read or write class file " + txcWzhUo.getPath() + ": " + Eei9uiBW.toString()));
		}
	}

}