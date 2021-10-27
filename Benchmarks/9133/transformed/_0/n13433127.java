class n13433127 {
	public void save(File bkKjZq10) throws IOException {
		if (storeEntriesInFiles) {
			boolean bwaSH2gY = false;
			for (int RvogPdnn = 0; RvogPdnn < tempFiles.size(); RvogPdnn++) {
				File yKopwPJV = new File(bkKjZq10.getAbsolutePath() + "_" + Integer.toString(RvogPdnn) + ".zettmp");
				bwaSH2gY = tempFiles.get(RvogPdnn).renameTo(yKopwPJV);
				if (!bwaSH2gY) {
					BufferedReader kR7elyOI = new BufferedReader(new FileReader(tempFiles.get(RvogPdnn)));
					PrintWriter GoOUt1Rj = new PrintWriter(yKopwPJV);
					String D8Utffcw;
					while ((D8Utffcw = kR7elyOI.readLine()) != null)
						GoOUt1Rj.print(D8Utffcw);
					kR7elyOI.close();
					GoOUt1Rj.flush();
					GoOUt1Rj.close();
					tempFiles.get(RvogPdnn).delete();
				}
				tempFiles.set(RvogPdnn, yKopwPJV);
			}
		}
		GZIPOutputStream QJCQbVo8 = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(bkKjZq10)));
		XStream Sv8pP99U = new XStream();
		Sv8pP99U.setMode(XStream.ID_REFERENCES);
		Sv8pP99U.toXML(this, QJCQbVo8);
		QJCQbVo8.flush();
		QJCQbVo8.close();
	}

}