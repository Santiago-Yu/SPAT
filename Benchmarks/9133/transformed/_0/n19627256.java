class n19627256 {
	public void compile(Project oQEZDnkZ) throws ProjectCompilerException {
		List<Resource> n1EIxkG6 = oQEZDnkZ.getModel().getResource();
		for (Resource v3madysw : n1EIxkG6) {
			try {
				IOUtils.copy(srcDir.getRelative(v3madysw.getLocation()).getInputStream(),
						outDir.getRelative(v3madysw.getLocation()).getOutputStream());
			} catch (IOException wisLpdQt) {
				throw new ProjectCompilerException("Resource cannot be copied. Compilation failed", wisLpdQt);
			}
		}
	}

}