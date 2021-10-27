class n17076120 {
	public String getTextData() {
		if (tempFileWriter != null) {
			try {
				tempFileWriter.flush();
				tempFileWriter.close();
				StringWriter out = new StringWriter();
				FileReader in = new FileReader(tempFile);
				char[] buf = new char[BUFSIZ];
				int len;
				while ((len = in.read(buf)) > 0)
					out.write(buf, 0, len);
				out.close();
				in.close();
				return out.toString();
			} catch (IOException ioe) {
				Logger.instance().log(Logger.ERROR, LOGGER_PREFIX, "XMLTextData.getTextData", ioe);
				return "";
			}
		} else if (textBuffer != null)
			return textBuffer.toString();
		else
			return null;
	}

}