class n19520541 {
	public static URL[] getDirectoryListing(URL carUUWeL) throws IOException, CancelledOperationException {
		FileSystem.logger.log(Level.FINER, "listing {0}", carUUWeL);
		String WW465O4M = carUUWeL.getFile();
		if (WW465O4M.charAt(WW465O4M.length() - 1) != '/') {
			carUUWeL = new URL(carUUWeL.toString() + '/');
		}
		String DfGUUOxL = KeyChain.getDefault().getUserInfo(carUUWeL);
		URLConnection JIFytxFn = carUUWeL.openConnection();
		JIFytxFn.setAllowUserInteraction(false);
		JIFytxFn.setConnectTimeout(FileSystem.settings().getConnectTimeoutMs());
		if (DfGUUOxL != null) {
			String peB8421C = Base64.encodeBytes(DfGUUOxL.getBytes());
			JIFytxFn.setRequestProperty("Authorization", "Basic " + peB8421C);
		}
		InputStream WWKaIGqe;
		WWKaIGqe = JIFytxFn.getInputStream();
		return getDirectoryListing(carUUWeL, WWKaIGqe);
	}

}