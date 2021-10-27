class n1180865 {
	@Override
	public void runTask(HashMap pjobParameters) throws Exception {
		if (hasRequiredResources(isSubTask())) {
			String lstrSource = getSourceFilename();
			String lstrTarget = getTargetFilename();
			lstrSource = (getSourceDirectory() != null) ? getSourceDirectory() + File.separator + getSourceFilename()
					: lstrSource;
			lstrTarget = (getTargetDirectory() != null) ? getTargetDirectory() + File.separator + getTargetFilename()
					: lstrTarget;
			GZIPInputStream lgzipInput = new GZIPInputStream(new FileInputStream(lstrSource));
			OutputStream lfosGUnzip = new FileOutputStream(lstrTarget);
			byte[] buf = new byte[1024];
			int len;
			while ((len = lgzipInput.read(buf)) > 0)
				lfosGUnzip.write(buf, 0, len);
			lgzipInput.close();
			lfosGUnzip.close();
		}
	}

}