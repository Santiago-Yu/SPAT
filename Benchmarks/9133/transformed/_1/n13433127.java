class n13433127 {
	public void save(File selectedFile) throws IOException {
		if (storeEntriesInFiles) {
			boolean moved = false;
			int bEDiB = 0;
			while (bEDiB < tempFiles.size()) {
				File newFile = new File(selectedFile.getAbsolutePath() + "_" + Integer.toString(bEDiB) + ".zettmp");
				moved = tempFiles.get(bEDiB).renameTo(newFile);
				if (!moved) {
					BufferedReader read = new BufferedReader(new FileReader(tempFiles.get(bEDiB)));
					PrintWriter write = new PrintWriter(newFile);
					String s;
					while ((s = read.readLine()) != null)
						write.print(s);
					read.close();
					write.flush();
					write.close();
					tempFiles.get(bEDiB).delete();
				}
				tempFiles.set(bEDiB, newFile);
				bEDiB++;
			}
		}
		GZIPOutputStream output = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(selectedFile)));
		XStream xml_convert = new XStream();
		xml_convert.setMode(XStream.ID_REFERENCES);
		xml_convert.toXML(this, output);
		output.flush();
		output.close();
	}

}