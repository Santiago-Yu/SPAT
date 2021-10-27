class n18935086 {
	private void copia(FileInputStream EAToOzms, FileOutputStream ZmhluC2Z) throws ErrorException {
		if (EAToOzms == null || ZmhluC2Z == null) {
			throw new ErrorException("Param null");
		}
		FileChannel I19paVew = EAToOzms.getChannel();
		FileChannel pD9kHMU6 = ZmhluC2Z.getChannel();
		try {
			I19paVew.transferTo(0, I19paVew.size(), pD9kHMU6);
			I19paVew.close();
			pD9kHMU6.close();
		} catch (IOException QHZKYgd4) {
			throw new ErrorException("Casino nella copia del file");
		}
	}

}