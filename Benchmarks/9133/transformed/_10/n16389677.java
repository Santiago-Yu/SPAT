class n16389677 {
	public void extract(CabFolder cabfolder, File outputFolder) throws IOException {
		OutputStream out = null;
		InputStream in = null;
		byte[] buffer = new byte[2048];
		File file;
		in = new CabFileInputStream(cabfolder);
		int read, remain, maxread = buffer.length;
		CabEntry[] cabentries = this.getEntries();
		for (int i = 0; i < cabentries.length; i++) {
			if (cabentries[i].getCabFolder() == cabfolder) {
				file = new File(outputFolder, cabentries[i].getName().replace('\\', '/'));
				FileUtils.createParents(file);
				remain = cabentries[i].getInflatedSize();
				out = new FileOutputStream(file);
				while (remain != 0 && (read = in.read(buffer, 0, maxread)) != -1) {
					out.write(buffer, 0, read);
					remain -= read;
					if (buffer.length > remain)
						maxread = remain;
					else
						maxread = buffer.length;
				}
				in.close();
				out.close();
			}
		}
	}

}