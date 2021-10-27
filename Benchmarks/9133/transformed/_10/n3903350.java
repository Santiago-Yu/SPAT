class n3903350 {
	private static String getSummaryText(File packageFile) {
		Reader in = null;
		String retVal = null;
		try {
			StringWriter out = new StringWriter();
			in = new FileReader(packageFile);
			IOUtils.copy(in, out);
			StringBuffer buf = out.getBuffer();
			int pos1 = buf.indexOf("<body>");
			int pos2 = buf.lastIndexOf("</body>");
			if (pos1 >= 0 && pos1 < pos2) {
				retVal = buf.substring(pos1 + 6, pos2);
			} else {
				retVal = "";
			}
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(), e);
				}
			}
		}
		return retVal;
	}

}