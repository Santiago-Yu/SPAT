class n6416201 {
	@Override
	public void copyTo(ManagedFile cCM9stry) throws ManagedIOException {
		try {
			if (cCM9stry.getType() == ManagedFileType.FILE) {
				IOUtils.copy(this.getContent().getInputStream(), cCM9stry.getContent().getOutputStream());
			} else {
				ManagedFile WczBsueb = cCM9stry.retrive(this.getPath());
				WczBsueb.createFile();
				IOUtils.copy(this.getContent().getInputStream(), WczBsueb.getContent().getOutputStream());
			}
		} catch (IOException AzsIolcZ) {
			throw ManagedIOException.manage(AzsIolcZ);
		}
	}

}