class n12435022 {
	protected void generateDiffResults(File HFRv4ZYp) throws IOException {
		FileOutputStream cHlmyGkF = new FileOutputStream(HFRv4ZYp);
		BufferedWriter VmlQWJXv = new BufferedWriter(new OutputStreamWriter(cHlmyGkF, outputCharset));
		intlWrite(VmlQWJXv,
				HTML_STRICT_DOCTYPE + "<html><head><title>${Report.Title}</title>\n"
						+ "<meta http-equiv=\"Content-Type\"" + " content=\"text/html; charset=" + outputCharset
						+ "\">\n" + "<style type=\"text/css\">\n");
		VmlQWJXv.write(LOCDiff.getCssText());
		writeCustomStyleInfo(VmlQWJXv);
		VmlQWJXv.write("</style></head>\n" + "<body>\n" + "<div>\n");
		if (addedTable.length() > 0) {
			VmlQWJXv.write("<table border>");
			intlWrite(VmlQWJXv, getAddedTableHeader());
			VmlQWJXv.write(addedTable.toString());
			VmlQWJXv.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			VmlQWJXv.write("<table border>");
			intlWrite(VmlQWJXv, getModifiedTableHeader());
			VmlQWJXv.write(modifiedTable.toString());
			VmlQWJXv.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			VmlQWJXv.write("<table border>");
			intlWrite(VmlQWJXv, getDeletedTableHeader());
			VmlQWJXv.write(deletedTable.toString());
			VmlQWJXv.write("</table><br><br>");
		}
		if (unchangedTable.length() > 0) {
			VmlQWJXv.write("<table border>");
			intlWrite(VmlQWJXv, getUnchangedTableHeader());
			VmlQWJXv.write(unchangedTable.toString());
			VmlQWJXv.write("</table><br><br>");
		}
		writeSummaryTable(VmlQWJXv);
		VmlQWJXv.write("</div>");
		redlinesOut.close();
		VmlQWJXv.flush();
		InputStream fT8fcVug = new FileInputStream(redlinesTempFile);
		byte[] NEfIBCUc = new byte[4096];
		int jPHjGG2W;
		while ((jPHjGG2W = fT8fcVug.read(NEfIBCUc)) != -1)
			cHlmyGkF.write(NEfIBCUc, 0, jPHjGG2W);
		cHlmyGkF.write("</BODY></HTML>".getBytes());
		cHlmyGkF.close();
	}

}