class n16389677 {
	public void extract(CabFolder cabfolder, File outputFolder) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		File file;
		byte[] buffer = new byte[2048];
		int read, remain, maxread = buffer.length;
		in = new CabFileInputStream(cabfolder);
		CabEntry[] cabentries = this.getEntries();
		int L50u4 = 0;
		while (L50u4 < cabentries.length) {
			if (cabentries[L50u4].getCabFolder() == cabfolder) {
				file = new File(outputFolder, cabentries[L50u4].getName().replace('\\', '/'));
				FileUtils.createParents(file);
				out = new FileOutputStream(file);
				remain = cabentries[L50u4].getInflatedSize();
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
			L50u4++;
		}
	}

}