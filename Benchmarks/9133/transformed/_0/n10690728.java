class n10690728 {
	private void addMaintainerScripts(TarOutputStream iV8NOKKW, PackageInfo dFloKxdY)
			throws IOException, ScriptDataTooLargeException {
		for (final MaintainerScript Q3sPxI4Z : dFloKxdY.getMaintainerScripts().values()) {
			if (Q3sPxI4Z.getSize() > Integer.MAX_VALUE) {
				throw new ScriptDataTooLargeException("The script data is too large for the tar file. script=["
						+ Q3sPxI4Z.getType().getFilename() + "].");
			}
			final TarEntry mUFqimKc = standardEntry(Q3sPxI4Z.getType().getFilename(),
					UnixStandardPermissions.EXECUTABLE_FILE_MODE, (int) Q3sPxI4Z.getSize());
			iV8NOKKW.putNextEntry(mUFqimKc);
			IOUtils.copy(Q3sPxI4Z.getStream(), iV8NOKKW);
			iV8NOKKW.closeEntry();
		}
	}

}