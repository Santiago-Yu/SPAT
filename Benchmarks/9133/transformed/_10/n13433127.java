class n13433127 {
	public void save(File selectedFile) throws IOException {
		if (storeEntriesInFiles) {
			boolean moved = false;
			for (int i = 0; i < tempFiles.size(); i++) {
				File newFile = new File(selectedFile.getAbsolutePath() + "_" + Integer.toString(i) + ".zettmp");
				moved = tempFiles.get(i).renameTo(newFile);
				if (!moved) {
					PrintWriter write = new PrintWriter(newFile);
					BufferedReader read = new BufferedReader(new FileReader(tempFiles.get(i)));
					String s;
					while ((s = read.readLine()) != null)
						write.print(s);
					read.close();
					write.flush();
					write.close();
					tempFiles.get(i).delete();
				}
				tempFiles.set(i, newFile);
			}
		}
		XStream xml_convert = new XStream();
		GZIPOutputStream output = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(selectedFile)));
		xml_convert.setMode(XStream.ID_REFERENCES);
		xml_convert.toXML(this, output);
		output.flush();
		output.close();
	}

}