class n1769771 {
	private void copyFile(File UDHmt8OP, File kcn8CKH2) throws IOException {
		FileChannel EyeCVGEq = new FileInputStream(UDHmt8OP).getChannel();
		FileChannel lObNwdc9 = new FileOutputStream(kcn8CKH2).getChannel();
		try {
			EyeCVGEq.transferTo(0, EyeCVGEq.size(), lObNwdc9);
		} catch (IOException KFxzyChe) {
			throw KFxzyChe;
		} finally {
			if (EyeCVGEq != null)
				EyeCVGEq.close();
			if (lObNwdc9 != null)
				lObNwdc9.close();
		}
	}

}