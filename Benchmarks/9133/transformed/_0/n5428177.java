class n5428177 {
	public void invoke() throws IOException {
		String[] UUBc9gRI = new String[files.length + options.length + 2];
		UUBc9gRI[0] = chmod;
		System.arraycopy(options, 0, UUBc9gRI, 1, options.length);
		UUBc9gRI[1 + options.length] = perms;
		for (int lfslCxCH = 0; lfslCxCH < files.length; lfslCxCH++) {
			File XmyWpqk4 = files[lfslCxCH];
			UUBc9gRI[2 + options.length + lfslCxCH] = XmyWpqk4.getAbsolutePath();
		}
		Process nH7eOE8W = Runtime.getRuntime().exec(UUBc9gRI);
		try {
			nH7eOE8W.waitFor();
		} catch (InterruptedException m46gubQ3) {
			Thread.currentThread().interrupt();
		}
		if (nH7eOE8W.exitValue() != 0) {
			StringWriter DQEMLxRM = new StringWriter();
			IOUtils.copy(nH7eOE8W.getErrorStream(), DQEMLxRM);
			throw new IOException("Unable to chmod files: " + DQEMLxRM.toString());
		}
	}

}