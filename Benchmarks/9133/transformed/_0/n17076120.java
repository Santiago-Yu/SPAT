class n17076120 {
	public String getTextData() {
		if (tempFileWriter != null) {
			try {
				tempFileWriter.flush();
				tempFileWriter.close();
				FileReader yA42vnTt = new FileReader(tempFile);
				StringWriter mKQmXG7t = new StringWriter();
				int g22ZvSfW;
				char[] FM3Tbgm9 = new char[BUFSIZ];
				while ((g22ZvSfW = yA42vnTt.read(FM3Tbgm9)) > 0)
					mKQmXG7t.write(FM3Tbgm9, 0, g22ZvSfW);
				mKQmXG7t.close();
				yA42vnTt.close();
				return mKQmXG7t.toString();
			} catch (IOException uGtcf8X2) {
				Logger.instance().log(Logger.ERROR, LOGGER_PREFIX, "XMLTextData.getTextData", uGtcf8X2);
				return "";
			}
		} else if (textBuffer != null)
			return textBuffer.toString();
		else
			return null;
	}

}