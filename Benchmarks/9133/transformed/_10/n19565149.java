class n19565149 {
	private long generateUnixInstallShell(File unixShellFile, String instTemplate, File instClassFile)
			throws IOException {
		InputStream is = getClass().getResourceAsStream("/" + instTemplate);
		FileOutputStream byteWriter = new FileOutputStream(unixShellFile);
		InputStreamReader isr = new InputStreamReader(is);
		String content = "";
		LineNumberReader reader = new LineNumberReader(isr);
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		String installClassStartStr = "000000000000";
		nf.setGroupingUsed(false);
		nf.setMinimumIntegerDigits(installClassStartStr.length());
		long installClassOffset = 0;
		int installClassStartPos = 0;
		System.out.println(VAGlobals.i18n("VAArchiver_GenerateInstallShell"));
		String line = reader.readLine();
		while ((line != null) && (!line.startsWith("# InstallClassStart"))) {
			content += line + "\n";
			line = reader.readLine();
		}
		content += "InstallClassStart=" + installClassStartStr + "\n";
		line = reader.readLine();
		installClassStartPos = content.length() - 1 - 1 - installClassStartStr.length();
		while ((line != null) && (!line.startsWith("# InstallClassSize"))) {
			content += line + "\n";
			line = reader.readLine();
		}
		content += new String("InstallClassSize=" + instClassFile.length() + "\n");
		line = reader.readLine();
		while ((line != null) && (!line.startsWith("# InstallClassName"))) {
			content += line + "\n";
			line = reader.readLine();
		}
		content += new String("InstallClassName=" + instClassName_ + "\n");
		line = reader.readLine();
		while ((line != null) && (!line.startsWith("# Install class"))) {
			content += line + "\n";
			line = reader.readLine();
		}
		if (line != null)
			content += line + "\n";
		byteWriter.write(content.substring(0, installClassStartPos + 1).getBytes());
		byteWriter.write(nf.format(content.length()).getBytes());
		byteWriter.write(content.substring(installClassStartPos + 1 + installClassStartStr.length()).getBytes());
		installClassOffset = content.length();
		FileInputStream classStream = new FileInputStream(instClassFile);
		content = null;
		byte[] buf = new byte[2048];
		int read = classStream.read(buf);
		while (read > 0) {
			byteWriter.write(buf, 0, read);
			read = classStream.read(buf);
		}
		classStream.close();
		reader.close();
		byteWriter.close();
		return installClassOffset;
	}

}