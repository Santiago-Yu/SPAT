class n421187 {
	private void displayDiffResults() throws IOException {
		File SciZsIF2 = File.createTempFile("diff", ".htm");
		SciZsIF2.deleteOnExit();
		FileOutputStream ICsuQkLx = new FileOutputStream(SciZsIF2);
		BufferedWriter CKiBywpm = new BufferedWriter(new OutputStreamWriter(ICsuQkLx));
		CKiBywpm.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			CKiBywpm.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			CKiBywpm.write(addedTable.toString());
			CKiBywpm.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			CKiBywpm.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			CKiBywpm.write(modifiedTable.toString());
			CKiBywpm.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			CKiBywpm.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			CKiBywpm.write(deletedTable.toString());
			CKiBywpm.write("</table><br><br>");
		}
		CKiBywpm.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			CKiBywpm.write("<tr><td>Base:&nbsp;</td><td>");
			CKiBywpm.write(Long.toString(base));
			CKiBywpm.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			CKiBywpm.write(Long.toString(deleted));
			CKiBywpm.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			CKiBywpm.write(Long.toString(modified));
			CKiBywpm.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			CKiBywpm.write(Long.toString(added));
			CKiBywpm.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			CKiBywpm.write(Long.toString(added + modified));
			CKiBywpm.write("</td></tr>\n");
		}
		CKiBywpm.write("<tr><td>Total:&nbsp;</td><td>");
		CKiBywpm.write(Long.toString(total));
		CKiBywpm.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		CKiBywpm.flush();
		InputStream V4uiETlM = new FileInputStream(redlinesTempFile);
		byte[] pHEQNpbl = new byte[4096];
		int IQ2Fou6j;
		while ((IQ2Fou6j = V4uiETlM.read(pHEQNpbl)) != -1)
			ICsuQkLx.write(pHEQNpbl, 0, IQ2Fou6j);
		ICsuQkLx.write("</BODY></HTML>".getBytes());
		ICsuQkLx.close();
		Browser.launch(SciZsIF2.toURL().toString());
	}

}