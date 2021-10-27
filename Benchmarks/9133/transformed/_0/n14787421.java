class n14787421 {
	private void saveStateAsLast(URL CwLlVZN0) {
		InputStream YgQWxREM = null;
		OutputStream DR2t5H5t = null;
		File TfwAMVAk = getLastBundleInfo();
		try {
			try {
				DR2t5H5t = new FileOutputStream(TfwAMVAk);
				YgQWxREM = CwLlVZN0.openStream();
				SimpleConfiguratorUtils.transferStreams(YgQWxREM, DR2t5H5t);
			} finally {
				if (DR2t5H5t != null)
					DR2t5H5t.close();
				if (YgQWxREM != null)
					YgQWxREM.close();
			}
		} catch (IOException H7NfmhAd) {
		}
	}

}