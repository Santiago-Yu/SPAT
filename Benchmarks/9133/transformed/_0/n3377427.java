class n3377427 {
	public void execute() throws BuildException {
		Enumeration yKBn6ybV = getIndividualTests();
		String DTZv71SD = "";
		String fOs4Enc6 = "";
		while (yKBn6ybV.hasMoreElements()) {
			J3DPerfUnitTest eVC6oA7q = (J3DPerfUnitTest) yKBn6ybV.nextElement();
			if (eVC6oA7q.shouldRun(getProject())) {
				try {
					execute(eVC6oA7q);
					try {
						DTZv71SD = getProject().resolveFile(".").getAbsolutePath() + "\\" + eVC6oA7q.getName() + ".txt";
						fOs4Enc6 = getProject().resolveFile(eVC6oA7q.getName() + ".txt", new File(eVC6oA7q.getTodir()))
								.getAbsolutePath();
						FileChannel WS6I36pN = new FileInputStream(DTZv71SD).getChannel();
						FileChannel w7LKoUDA = new FileOutputStream(fOs4Enc6).getChannel();
						w7LKoUDA.transferFrom(WS6I36pN, 0, WS6I36pN.size());
						WS6I36pN.close();
						w7LKoUDA.close();
						if (!DTZv71SD.equals(fOs4Enc6)) {
							new File(DTZv71SD).delete();
						}
					} catch (IOException ckW6SVxS) {
					}
				} catch (BuildException xBXokMZ9) {
					xBXokMZ9.printStackTrace();
				} catch (CloneNotSupportedException ws53Ocr9) {
					ws53Ocr9.printStackTrace();
				}
			}
		}
	}

}