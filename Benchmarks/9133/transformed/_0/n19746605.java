class n19746605 {
	private synchronized Frame insertFrame(int RMtJfHtR, File Kx04txUa, INSERT_TYPE LQ7PQqPH) throws IOException {
		if (Kx04txUa == null)
			throw new NullPointerException("Parameter 'source' is null");
		if (!Kx04txUa.exists())
			throw new IOException("File does not exist: " + Kx04txUa.getAbsolutePath());
		if (Kx04txUa.length() <= 0)
			throw new IOException("File is empty: " + Kx04txUa.getAbsolutePath());
		if (RMtJfHtR < 0)
			throw new IndexOutOfBoundsException("index < 0");
		if (RMtJfHtR >= frames_.size())
			throw new IndexOutOfBoundsException("index >= frames_.size()");
		File GyICX1Vg = new File(Settings.getPropertyString(ConstantKeys.project_dir), "tmp.jpg");
		switch (LQ7PQqPH) {
		case MOVE:
			if (Kx04txUa.getParentFile().compareTo(new File(Settings.getPropertyString(ConstantKeys.project_dir))) == 0
					&& Kx04txUa.getName().matches("img_[0-9]{5}\\.jpg")) {
				for (int iJafP7AY = 0; iJafP7AY < frames_.size(); iJafP7AY++) {
					Frame AAbRNXS0 = frames_.get(iJafP7AY);
					if (AAbRNXS0.getFile().compareTo(Kx04txUa) == 0) {
						frames_.remove(iJafP7AY);
						break;
					}
				}
			}
			Kx04txUa.renameTo(GyICX1Vg);
			break;
		case COPY:
			FileChannel BpFpRj5A = new FileInputStream(Kx04txUa).getChannel();
			FileChannel XxML7ZAu = new FileOutputStream(GyICX1Vg).getChannel();
			BpFpRj5A.transferTo(0, BpFpRj5A.size(), XxML7ZAu);
			if (BpFpRj5A != null)
				BpFpRj5A.close();
			if (XxML7ZAu != null)
				XxML7ZAu.close();
			break;
		}
		for (int UWjryQLi = frames_.size() - 1; UWjryQLi >= RMtJfHtR; UWjryQLi--) {
			Frame JJ5fTi0L = new Frame(
					new File(Settings.getPropertyString(ConstantKeys.project_dir), formatFileName(UWjryQLi)));
			frames_.get(UWjryQLi).moveTo(JJ5fTi0L);
			frames_.set(UWjryQLi, JJ5fTi0L);
		}
		File d6mHsabY = new File(Settings.getPropertyString(ConstantKeys.project_dir), formatFileName(RMtJfHtR));
		GyICX1Vg.renameTo(d6mHsabY);
		Frame AbYNK8ho = new Frame(d6mHsabY);
		AbYNK8ho.createThumbNail();
		frames_.set(RMtJfHtR, AbYNK8ho);
		return AbYNK8ho;
	}

}