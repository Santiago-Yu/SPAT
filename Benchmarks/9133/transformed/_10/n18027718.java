class n18027718 {
	public byte[] read(IFile input) {
		InputStream contents = null;
		try {
			contents = input.getContents();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(contents, baos);
			return baos.toByteArray();
		} catch (IOException e) {
			Activator.logUnexpected(null, e);
		} catch (CoreException e) {
			Activator.logUnexpected(null, e);
		} finally {
			IOUtils.closeQuietly(contents);
		}
		return null;
	}

}