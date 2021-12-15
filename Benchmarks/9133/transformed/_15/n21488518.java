class n21488518 {
	@Override
	public Resource createNew(String name, InputStream in, Long length, String contentType) throws IOException {
		File dest = new File(this.realFile, name);
		if (allowedClient) {
			if ((name != null && name.equals(".request")) || (name != null && name.equals(".tokens"))) {
				FileOutputStream out = null;
				try {
					out = new FileOutputStream(dest);
					IOUtils.copy(in, out);
				} finally {
					IOUtils.closeQuietly(out);
				}
				if ((name != null && name.equals(".request"))) {
					File request = new File(realFile.getAbsolutePath() + "/" + name);
					RequestManager.manageRequest(request, null, true);
					return new OverEncryptedFriendsFile(factory, folderPath + "/.response", allowedClient);
				}
				return new OverEncryptedFriendsFile(factory, folderPath + "/" + name, allowedClient);
			} else {
				return null;
			}
		} else {
			LOGGER.error("User isn't owner of this folder");
			return null;
		}
	}

}