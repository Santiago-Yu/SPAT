class n36860 {
	private void displayDiffResults() throws IOException {
		File BEgmaJ5o = File.createTempFile("diff", ".htm");
		BEgmaJ5o.deleteOnExit();
		FileOutputStream rLqm2KHK = new FileOutputStream(BEgmaJ5o);
		BufferedWriter HeL9asRJ = new BufferedWriter(new OutputStreamWriter(rLqm2KHK));
		HeL9asRJ.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			HeL9asRJ.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			HeL9asRJ.write(addedTable.toString());
			HeL9asRJ.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			HeL9asRJ.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			HeL9asRJ.write(modifiedTable.toString());
			HeL9asRJ.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			HeL9asRJ.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			HeL9asRJ.write(deletedTable.toString());
			HeL9asRJ.write("</table><br><br>");
		}
		HeL9asRJ.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			HeL9asRJ.write("<tr><td>Base:&nbsp;</td><td>");
			HeL9asRJ.write(Long.toString(base));
			HeL9asRJ.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			HeL9asRJ.write(Long.toString(deleted));
			HeL9asRJ.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			HeL9asRJ.write(Long.toString(modified));
			HeL9asRJ.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			HeL9asRJ.write(Long.toString(added));
			HeL9asRJ.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			HeL9asRJ.write(Long.toString(added + modified));
			HeL9asRJ.write("</td></tr>\n");
		}
		HeL9asRJ.write("<tr><td>Total:&nbsp;</td><td>");
		HeL9asRJ.write(Long.toString(total));
		HeL9asRJ.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		HeL9asRJ.flush();
		InputStream s8JyMkzh = new FileInputStream(redlinesTempFile);
		byte[] zlFZDT8M = new byte[4096];
		int eCQVzLSb;
		while ((eCQVzLSb = s8JyMkzh.read(zlFZDT8M)) != -1)
			rLqm2KHK.write(zlFZDT8M, 0, eCQVzLSb);
		rLqm2KHK.write("</BODY></HTML>".getBytes());
		rLqm2KHK.close();
		Browser.launch(BEgmaJ5o.toURL().toString());
	}

}