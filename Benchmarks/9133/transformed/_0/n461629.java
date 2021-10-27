class n461629 {
	private void displayDiffResults() throws IOException {
		File BiSBe4be = File.createTempFile("diff", ".htm");
		BiSBe4be.deleteOnExit();
		FileOutputStream NCSyvPBI = new FileOutputStream(BiSBe4be);
		BufferedWriter cPjNoiOc = new BufferedWriter(new OutputStreamWriter(NCSyvPBI));
		cPjNoiOc.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			cPjNoiOc.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			cPjNoiOc.write(addedTable.toString());
			cPjNoiOc.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			cPjNoiOc.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			cPjNoiOc.write(modifiedTable.toString());
			cPjNoiOc.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			cPjNoiOc.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			cPjNoiOc.write(deletedTable.toString());
			cPjNoiOc.write("</table><br><br>");
		}
		cPjNoiOc.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			cPjNoiOc.write("<tr><td>Base:&nbsp;</td><td>");
			cPjNoiOc.write(Long.toString(base));
			cPjNoiOc.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			cPjNoiOc.write(Long.toString(deleted));
			cPjNoiOc.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			cPjNoiOc.write(Long.toString(modified));
			cPjNoiOc.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			cPjNoiOc.write(Long.toString(added));
			cPjNoiOc.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			cPjNoiOc.write(Long.toString(added + modified));
			cPjNoiOc.write("</td></tr>\n");
		}
		cPjNoiOc.write("<tr><td>Total:&nbsp;</td><td>");
		cPjNoiOc.write(Long.toString(total));
		cPjNoiOc.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		cPjNoiOc.flush();
		InputStream A8O7DUu9 = new FileInputStream(redlinesTempFile);
		byte[] g0AVUnQt = new byte[4096];
		int p9L1ItMq;
		while ((p9L1ItMq = A8O7DUu9.read(g0AVUnQt)) != -1)
			NCSyvPBI.write(g0AVUnQt, 0, p9L1ItMq);
		NCSyvPBI.write("</BODY></HTML>".getBytes());
		NCSyvPBI.close();
		Browser.launch(BiSBe4be.toURL().toString());
	}

}