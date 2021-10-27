class n7125457 {
	void readFileHeader(DmgConfigDMO config, ConfigLocation sl) throws IOException {
		fileHeader = "";
		if (config.getGeneratedFileHeader() != null) {
			StringBuffer sb = new StringBuffer();
			if (sl.getJarFilename() != null) {
				URL url = new URL("jar:file:" + sl.getJarFilename() + "!/" + sl.getJarDirectory() + "/"
						+ config.getGeneratedFileHeader());
				String str;
				LineNumberReader in = new LineNumberReader(new InputStreamReader(url.openStream()));
				while ((str = in.readLine()) != null) {
					sb.append(str + "\n");
				}
				in.close();
			} else {
				String str;
				LineNumberReader in = new LineNumberReader(
						new FileReader(sl.getDirectory() + File.separator + config.getGeneratedFileHeader()));
				while ((str = in.readLine()) != null) {
					sb.append(str + "\n");
				}
				in.close();
			}
			fileHeader = sb.toString();
		}
	}

}