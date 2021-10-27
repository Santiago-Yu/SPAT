class n411595 {
	private void displayDiffResults() throws IOException {
		File b3Wwi4jP = File.createTempFile("diff", ".htm");
		b3Wwi4jP.deleteOnExit();
		FileOutputStream QBdJdaiv = new FileOutputStream(b3Wwi4jP);
		BufferedWriter fsLajAma = new BufferedWriter(new OutputStreamWriter(QBdJdaiv));
		fsLajAma.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			fsLajAma.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			fsLajAma.write(addedTable.toString());
			fsLajAma.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			fsLajAma.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			fsLajAma.write(modifiedTable.toString());
			fsLajAma.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			fsLajAma.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			fsLajAma.write(deletedTable.toString());
			fsLajAma.write("</table><br><br>");
		}
		fsLajAma.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			fsLajAma.write("<tr><td>Base:&nbsp;</td><td>");
			fsLajAma.write(Long.toString(base));
			fsLajAma.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			fsLajAma.write(Long.toString(deleted));
			fsLajAma.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			fsLajAma.write(Long.toString(modified));
			fsLajAma.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			fsLajAma.write(Long.toString(added));
			fsLajAma.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			fsLajAma.write(Long.toString(added + modified));
			fsLajAma.write("</td></tr>\n");
		}
		fsLajAma.write("<tr><td>Total:&nbsp;</td><td>");
		fsLajAma.write(Long.toString(total));
		fsLajAma.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		fsLajAma.flush();
		InputStream iijxdQ6B = new FileInputStream(redlinesTempFile);
		byte[] FZVkcaeK = new byte[4096];
		int rVA03Iqr;
		while ((rVA03Iqr = iijxdQ6B.read(FZVkcaeK)) != -1)
			QBdJdaiv.write(FZVkcaeK, 0, rVA03Iqr);
		QBdJdaiv.write("</BODY></HTML>".getBytes());
		QBdJdaiv.close();
		Browser.launch(b3Wwi4jP.toURL().toString());
	}

}