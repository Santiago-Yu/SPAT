class n19746603 {
	private synchronized Frame addFrame(INSERT_TYPE cbQ8bIRw, File kdqkVuDS) throws IOException {
		if (kdqkVuDS == null)
			throw new NullPointerException("Parameter 'source' is null");
		if (!kdqkVuDS.exists())
			throw new IOException("File does not exist: " + kdqkVuDS.getAbsolutePath());
		if (kdqkVuDS.length() <= 0)
			throw new IOException("File is empty: " + kdqkVuDS.getAbsolutePath());
		File XThdcB9X = new File(Settings.getPropertyString(ConstantKeys.project_dir), formatFileName(frames_.size()));
		if (XThdcB9X.compareTo(kdqkVuDS) != 0) {
			switch (cbQ8bIRw) {
			case MOVE:
				kdqkVuDS.renameTo(XThdcB9X);
				break;
			case COPY:
				FileChannel spEDlDfB = new FileInputStream(kdqkVuDS).getChannel();
				FileChannel Qqbjs3oL = new FileOutputStream(XThdcB9X).getChannel();
				spEDlDfB.transferTo(0, spEDlDfB.size(), Qqbjs3oL);
				if (spEDlDfB != null)
					spEDlDfB.close();
				if (Qqbjs3oL != null)
					Qqbjs3oL.close();
				break;
			}
		}
		Frame ImkW1LPh = new Frame(XThdcB9X);
		ImkW1LPh.createThumbNail();
		frames_.add(ImkW1LPh);
		return ImkW1LPh;
	}

}