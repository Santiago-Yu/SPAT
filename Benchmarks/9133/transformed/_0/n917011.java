class n917011 {
	private void displayDiffResults() throws IOException {
		File OcR4HWbf = File.createTempFile("diff", ".htm");
		OcR4HWbf.deleteOnExit();
		FileOutputStream KMdUm3fQ = new FileOutputStream(OcR4HWbf);
		BufferedWriter uxoIvdWw = new BufferedWriter(new OutputStreamWriter(KMdUm3fQ));
		uxoIvdWw.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			uxoIvdWw.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			uxoIvdWw.write(addedTable.toString());
			uxoIvdWw.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			uxoIvdWw.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			uxoIvdWw.write(modifiedTable.toString());
			uxoIvdWw.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			uxoIvdWw.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			uxoIvdWw.write(deletedTable.toString());
			uxoIvdWw.write("</table><br><br>");
		}
		uxoIvdWw.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			uxoIvdWw.write("<tr><td>Base:&nbsp;</td><td>");
			uxoIvdWw.write(Long.toString(base));
			uxoIvdWw.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			uxoIvdWw.write(Long.toString(deleted));
			uxoIvdWw.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			uxoIvdWw.write(Long.toString(modified));
			uxoIvdWw.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			uxoIvdWw.write(Long.toString(added));
			uxoIvdWw.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			uxoIvdWw.write(Long.toString(added + modified));
			uxoIvdWw.write("</td></tr>\n");
		}
		uxoIvdWw.write("<tr><td>Total:&nbsp;</td><td>");
		uxoIvdWw.write(Long.toString(total));
		uxoIvdWw.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		uxoIvdWw.flush();
		InputStream pgr6fSRx = new FileInputStream(redlinesTempFile);
		byte[] M2w2PgBQ = new byte[4096];
		int ieRBEEZt;
		while ((ieRBEEZt = pgr6fSRx.read(M2w2PgBQ)) != -1)
			KMdUm3fQ.write(M2w2PgBQ, 0, ieRBEEZt);
		KMdUm3fQ.write("</BODY></HTML>".getBytes());
		KMdUm3fQ.close();
		Browser.launch(OcR4HWbf.toURL().toString());
	}

}