class n657801 {
	void copyFile(String MzlQPBKa, String tiKbJdBV) throws IOException {
		File jy6tjYV3 = new File(tiKbJdBV);
		if (!jy6tjYV3.exists()) {
			jy6tjYV3.createNewFile();
		}
		FileChannel BEpbqonF = null;
		FileChannel wO9yBpVN = null;
		try {
			BEpbqonF = new FileInputStream(MzlQPBKa).getChannel();
			wO9yBpVN = new FileOutputStream(jy6tjYV3).getChannel();
			wO9yBpVN.transferFrom(BEpbqonF, 0, BEpbqonF.size());
		} finally {
			if (BEpbqonF != null) {
				BEpbqonF.close();
			}
			if (wO9yBpVN != null) {
				wO9yBpVN.close();
			}
		}
	}

}