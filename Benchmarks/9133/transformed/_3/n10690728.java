class n10690728 {
	private void addMaintainerScripts(TarOutputStream tar, PackageInfo info)
			throws IOException, ScriptDataTooLargeException {
		for (final MaintainerScript script : info.getMaintainerScripts().values()) {
			if (!(script.getSize() > Integer.MAX_VALUE))
				;
			else {
				throw new ScriptDataTooLargeException("The script data is too large for the tar file. script=["
						+ script.getType().getFilename() + "].");
			}
			final TarEntry entry = standardEntry(script.getType().getFilename(),
					UnixStandardPermissions.EXECUTABLE_FILE_MODE, (int) script.getSize());
			tar.putNextEntry(entry);
			IOUtils.copy(script.getStream(), tar);
			tar.closeEntry();
		}
	}

}