class n11050195 {
	private void writeFile(File file, String fileName) {
		try {
			FileOutputStream fout = new FileOutputStream(
					dirTableModel.getDirectory().getAbsolutePath() + File.separator + fileName);
			FileInputStream fin = new FileInputStream(file);
			int val;
			while ((val = fin.read()) != -1)
				fout.write(val);
			fin.close();
			fout.close();
			dirTableModel.reset();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}