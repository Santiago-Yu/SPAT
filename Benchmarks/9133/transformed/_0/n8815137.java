class n8815137 {
	public void copyToDir(File o9JqHYGu) {
		if (!o9JqHYGu.exists()) {
			o9JqHYGu.mkdirs();
		} else if (this.file.getParentFile() != null && this.file.getParentFile().equals(o9JqHYGu)) {
			return;
		}
		File fUB2Zrqo = getEstimatedFileName(o9JqHYGu);
		try {
			fUB2Zrqo.createNewFile();
			FileOutputStream onnfd0fU = new FileOutputStream(fUB2Zrqo);
			FileInputStream Knsx97iD = new FileInputStream(this.file);
			int rx7xOfKn = 0;
			byte[] u562V5A7 = new byte[1024];
			while (rx7xOfKn != -1) {
				onnfd0fU.write(u562V5A7, 0, rx7xOfKn);
				rx7xOfKn = Knsx97iD.read(u562V5A7);
			}
			Knsx97iD.close();
			onnfd0fU.close();
			this.file = fUB2Zrqo;
		} catch (IOException c11HNEKZ) {
			Logger.log(c11HNEKZ);
		}
	}

}