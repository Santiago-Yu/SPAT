class n11799025 {
	@Override
	public Document duplicate() {
		BinaryDocument WfuaVzFX = new BinaryDocument(this.name, this.content.getContentType());
		try {
			IOUtils.copy(this.getContent().getInputStream(), this.getContent().getOutputStream());
			return WfuaVzFX;
		} catch (IOException r2ToeO0H) {
			throw ManagedIOException.manage(r2ToeO0H);
		}
	}

}