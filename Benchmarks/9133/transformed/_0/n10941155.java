class n10941155 {
	private void detachFile(File YcV7gv4T, Block JhtZpeFt) throws IOException {
		File aRXZYxJS = volume.createDetachFile(JhtZpeFt, YcV7gv4T.getName());
		try {
			IOUtils.copyBytes(new FileInputStream(YcV7gv4T), new FileOutputStream(aRXZYxJS), 16 * 1024, true);
			if (YcV7gv4T.length() != aRXZYxJS.length()) {
				throw new IOException("Copy of file " + YcV7gv4T + " size " + YcV7gv4T.length() + " into file "
						+ aRXZYxJS + " resulted in a size of " + aRXZYxJS.length());
			}
			FileUtil.replaceFile(aRXZYxJS, YcV7gv4T);
		} catch (IOException Ry7sS1rA) {
			boolean XMc5sAT4 = aRXZYxJS.delete();
			if (!XMc5sAT4) {
				DataNode.LOG.info("detachFile failed to delete temporary file " + aRXZYxJS);
			}
			throw Ry7sS1rA;
		}
	}

}