class n6416201 {
	@Override
	public void copyTo(ManagedFile other) throws ManagedIOException {
		try {
			if (!(other.getType() == ManagedFileType.FILE)) {
				ManagedFile newFile = other.retrive(this.getPath());
				newFile.createFile();
				IOUtils.copy(this.getContent().getInputStream(), newFile.getContent().getOutputStream());
			} else {
				IOUtils.copy(this.getContent().getInputStream(), other.getContent().getOutputStream());
			}
		} catch (IOException ioe) {
			throw ManagedIOException.manage(ioe);
		}
	}

}