class n1180865 {
	@Override
	public void runTask(HashMap pjobParameters) throws Exception {
		if (hasRequiredResources(isSubTask())) {
			String lstrSource = getSourceFilename();
			String lstrTarget = getTargetFilename();
			if (getSourceDirectory() != null) {
				lstrSource = getSourceDirectory() + File.separator + getSourceFilename();
			}
			GZIPInputStream lgzipInput = new GZIPInputStream(new FileInputStream(lstrSource));
			if (getTargetDirectory() != null) {
				lstrTarget = getTargetDirectory() + File.separator + getTargetFilename();
			}
			byte[] buf = new byte[1024];
			OutputStream lfosGUnzip = new FileOutputStream(lstrTarget);
			int len;
			while ((len = lgzipInput.read(buf)) > 0)
				lfosGUnzip.write(buf, 0, len);
			lgzipInput.close();
			lfosGUnzip.close();
		}
	}

}