class n489386 {
	private void displayDiffResults() throws IOException {
		File oSeLJwpn = File.createTempFile("diff", ".htm");
		oSeLJwpn.deleteOnExit();
		FileOutputStream x1V84DKf = new FileOutputStream(oSeLJwpn);
		BufferedWriter oRBcYoo8 = new BufferedWriter(new OutputStreamWriter(x1V84DKf));
		oRBcYoo8.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			oRBcYoo8.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			oRBcYoo8.write(addedTable.toString());
			oRBcYoo8.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			oRBcYoo8.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			oRBcYoo8.write(modifiedTable.toString());
			oRBcYoo8.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			oRBcYoo8.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			oRBcYoo8.write(deletedTable.toString());
			oRBcYoo8.write("</table><br><br>");
		}
		oRBcYoo8.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			oRBcYoo8.write("<tr><td>Base:&nbsp;</td><td>");
			oRBcYoo8.write(Long.toString(base));
			oRBcYoo8.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			oRBcYoo8.write(Long.toString(deleted));
			oRBcYoo8.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			oRBcYoo8.write(Long.toString(modified));
			oRBcYoo8.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			oRBcYoo8.write(Long.toString(added));
			oRBcYoo8.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			oRBcYoo8.write(Long.toString(added + modified));
			oRBcYoo8.write("</td></tr>\n");
		}
		oRBcYoo8.write("<tr><td>Total:&nbsp;</td><td>");
		oRBcYoo8.write(Long.toString(total));
		oRBcYoo8.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		oRBcYoo8.flush();
		InputStream RAYNfXWi = new FileInputStream(redlinesTempFile);
		byte[] r5DwlwNA = new byte[4096];
		int lp4ER3A2;
		while ((lp4ER3A2 = RAYNfXWi.read(r5DwlwNA)) != -1)
			x1V84DKf.write(r5DwlwNA, 0, lp4ER3A2);
		x1V84DKf.write("</BODY></HTML>".getBytes());
		x1V84DKf.close();
		Browser.launch(oSeLJwpn.toURL().toString());
	}

}