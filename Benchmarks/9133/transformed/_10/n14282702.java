class n14282702 {
	@Override
	public void runTask(HashMap jobStack) throws Exception {
		String lstrFilter = (String) getResources().get("filter");
		String lstrTarget = (String) getResources().get("target");
		String lstrSource = (String) getResources().get("source");
		String[] lstrFilesFound = null;
		lstrFilesFound = searchForFiles(lstrSource, lstrFilter);
		if (lstrFilesFound != null) {
			for (int i = 0; i < lstrFilesFound.length; i++) {
				getLog().debug("Found match [" + lstrSource + File.separator + lstrFilesFound[i] + "]");
				File lfileSource = new File(lstrSource + File.separator + lstrFilesFound[i]);
				FileChannel lfisInput = null;
				File lfileTarget = new File(lstrTarget + File.separator + lstrFilesFound[i]);
				FileChannel lfosOutput = null;
				try {
					lfisInput = new FileInputStream(lfileSource).getChannel();
					int maxCount = (32 * 1024 * 1024) - (32 * 1024);
					lfosOutput = new FileOutputStream(lfileTarget).getChannel();
					long position = 0;
					long size = lfisInput.size();
					while (position < size) {
						position += lfisInput.transferTo(position, maxCount, lfosOutput);
					}
				} finally {
					if (lfisInput != null) {
						lfisInput.close();
					}
					if (lfosOutput != null) {
						lfosOutput.close();
					}
				}
			}
		}
	}

}