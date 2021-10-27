class n392357 {
	private void displayDiffResults() throws IOException {
		File HuoJbVsF = File.createTempFile("diff", ".htm");
		HuoJbVsF.deleteOnExit();
		FileOutputStream NxnbPsG9 = new FileOutputStream(HuoJbVsF);
		BufferedWriter ljDsQKOf = new BufferedWriter(new OutputStreamWriter(NxnbPsG9));
		ljDsQKOf.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			ljDsQKOf.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			ljDsQKOf.write(addedTable.toString());
			ljDsQKOf.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			ljDsQKOf.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			ljDsQKOf.write(modifiedTable.toString());
			ljDsQKOf.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			ljDsQKOf.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			ljDsQKOf.write(deletedTable.toString());
			ljDsQKOf.write("</table><br><br>");
		}
		ljDsQKOf.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			ljDsQKOf.write("<tr><td>Base:&nbsp;</td><td>");
			ljDsQKOf.write(Long.toString(base));
			ljDsQKOf.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			ljDsQKOf.write(Long.toString(deleted));
			ljDsQKOf.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			ljDsQKOf.write(Long.toString(modified));
			ljDsQKOf.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			ljDsQKOf.write(Long.toString(added));
			ljDsQKOf.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			ljDsQKOf.write(Long.toString(added + modified));
			ljDsQKOf.write("</td></tr>\n");
		}
		ljDsQKOf.write("<tr><td>Total:&nbsp;</td><td>");
		ljDsQKOf.write(Long.toString(total));
		ljDsQKOf.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		ljDsQKOf.flush();
		InputStream i8qcNGDu = new FileInputStream(redlinesTempFile);
		byte[] QIpXUDKn = new byte[4096];
		int WXJS6s6B;
		while ((WXJS6s6B = i8qcNGDu.read(QIpXUDKn)) != -1)
			NxnbPsG9.write(QIpXUDKn, 0, WXJS6s6B);
		NxnbPsG9.write("</BODY></HTML>".getBytes());
		NxnbPsG9.close();
		Browser.launch(HuoJbVsF.toURL().toString());
	}

}