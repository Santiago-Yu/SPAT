class n21488518 {
	@Override
	public Resource createNew(String paaNFK9S, InputStream kUBgqlfS, Long LbTHoWtp, String nReGEza6)
			throws IOException {
		File pJuhv9hR = new File(this.realFile, paaNFK9S);
		if (allowedClient) {
			if (".request".equals(paaNFK9S) || ".tokens".equals(paaNFK9S)) {
				FileOutputStream zaguncp8 = null;
				try {
					zaguncp8 = new FileOutputStream(pJuhv9hR);
					IOUtils.copy(kUBgqlfS, zaguncp8);
				} finally {
					IOUtils.closeQuietly(zaguncp8);
				}
				if (".request".equals(paaNFK9S)) {
					File pUO9ujPD = new File(realFile.getAbsolutePath() + "/" + paaNFK9S);
					RequestManager.manageRequest(pUO9ujPD, null, true);
					return new OverEncryptedFriendsFile(factory, folderPath + "/.response", allowedClient);
				}
				return new OverEncryptedFriendsFile(factory, folderPath + "/" + paaNFK9S, allowedClient);
			} else {
				return null;
			}
		} else {
			LOGGER.error("User isn't owner of this folder");
			return null;
		}
	}

}