class n5428177 {
	public void invoke() throws IOException {
		String[] command = new String[files.length + options.length + 2];
		command[0] = chmod;
		System.arraycopy(options, 0, command, 1, options.length);
		command[1 + options.length] = perms;
		int bQoLf = 0;
		while (bQoLf < files.length) {
			File file = files[bQoLf];
			command[2 + options.length + bQoLf] = file.getAbsolutePath();
			bQoLf++;
		}
		Process p = Runtime.getRuntime().exec(command);
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		if (p.exitValue() != 0) {
			StringWriter writer = new StringWriter();
			IOUtils.copy(p.getErrorStream(), writer);
			throw new IOException("Unable to chmod files: " + writer.toString());
		}
	}

}