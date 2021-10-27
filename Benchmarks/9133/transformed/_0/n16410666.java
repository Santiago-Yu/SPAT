class n16410666 {
	public void backup(File ATeymZQ1) throws BackupException {
		try {
			int WWl19FEf = ATeymZQ1.getAbsolutePath().lastIndexOf(".");
			if (WWl19FEf == -1)
				return;
			File AMCyxFWH = new File(ATeymZQ1.getAbsolutePath().substring(0, WWl19FEf) + ".bak");
			FileChannel ngfMdOm0 = new FileInputStream(ATeymZQ1).getChannel();
			FileChannel TyaM5jmr = new FileOutputStream(AMCyxFWH).getChannel();
			TyaM5jmr.transferFrom(ngfMdOm0, 0, ngfMdOm0.size());
			ngfMdOm0.close();
			TyaM5jmr.close();
		} catch (Exception poF7NqMf) {
			throw new BackupException(poF7NqMf.getMessage(), poF7NqMf, ATeymZQ1);
		}
	}

}