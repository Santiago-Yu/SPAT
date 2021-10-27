class n529639 {
	private void displayDiffResults() throws IOException {
		File ejZOS1wH = File.createTempFile("diff", ".htm");
		ejZOS1wH.deleteOnExit();
		FileOutputStream ZRgVY0JQ = new FileOutputStream(ejZOS1wH);
		BufferedWriter PEy0SMWa = new BufferedWriter(new OutputStreamWriter(ZRgVY0JQ));
		PEy0SMWa.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			PEy0SMWa.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			PEy0SMWa.write(addedTable.toString());
			PEy0SMWa.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			PEy0SMWa.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			PEy0SMWa.write(modifiedTable.toString());
			PEy0SMWa.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			PEy0SMWa.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			PEy0SMWa.write(deletedTable.toString());
			PEy0SMWa.write("</table><br><br>");
		}
		PEy0SMWa.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			PEy0SMWa.write("<tr><td>Base:&nbsp;</td><td>");
			PEy0SMWa.write(Long.toString(base));
			PEy0SMWa.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			PEy0SMWa.write(Long.toString(deleted));
			PEy0SMWa.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			PEy0SMWa.write(Long.toString(modified));
			PEy0SMWa.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			PEy0SMWa.write(Long.toString(added));
			PEy0SMWa.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			PEy0SMWa.write(Long.toString(added + modified));
			PEy0SMWa.write("</td></tr>\n");
		}
		PEy0SMWa.write("<tr><td>Total:&nbsp;</td><td>");
		PEy0SMWa.write(Long.toString(total));
		PEy0SMWa.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		PEy0SMWa.flush();
		InputStream mxs7alKw = new FileInputStream(redlinesTempFile);
		byte[] F6lU2GQ8 = new byte[4096];
		int aOFih92M;
		while ((aOFih92M = mxs7alKw.read(F6lU2GQ8)) != -1)
			ZRgVY0JQ.write(F6lU2GQ8, 0, aOFih92M);
		ZRgVY0JQ.write("</BODY></HTML>".getBytes());
		ZRgVY0JQ.close();
		Browser.launch(ejZOS1wH.toURL().toString());
	}

}