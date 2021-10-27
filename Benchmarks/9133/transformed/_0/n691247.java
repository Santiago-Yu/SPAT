class n691247 {
	private void displayDiffResults() throws IOException {
		File e5QJibOo = File.createTempFile("diff", ".htm");
		e5QJibOo.deleteOnExit();
		FileOutputStream sgCRoV5b = new FileOutputStream(e5QJibOo);
		BufferedWriter B2VGHKby = new BufferedWriter(new OutputStreamWriter(sgCRoV5b));
		B2VGHKby.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			B2VGHKby.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			B2VGHKby.write(addedTable.toString());
			B2VGHKby.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			B2VGHKby.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			B2VGHKby.write(modifiedTable.toString());
			B2VGHKby.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			B2VGHKby.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			B2VGHKby.write(deletedTable.toString());
			B2VGHKby.write("</table><br><br>");
		}
		B2VGHKby.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			B2VGHKby.write("<tr><td>Base:&nbsp;</td><td>");
			B2VGHKby.write(Long.toString(base));
			B2VGHKby.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			B2VGHKby.write(Long.toString(deleted));
			B2VGHKby.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			B2VGHKby.write(Long.toString(modified));
			B2VGHKby.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			B2VGHKby.write(Long.toString(added));
			B2VGHKby.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			B2VGHKby.write(Long.toString(added + modified));
			B2VGHKby.write("</td></tr>\n");
		}
		B2VGHKby.write("<tr><td>Total:&nbsp;</td><td>");
		B2VGHKby.write(Long.toString(total));
		B2VGHKby.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		B2VGHKby.flush();
		InputStream bXdgX53o = new FileInputStream(redlinesTempFile);
		byte[] cWsuQXIK = new byte[4096];
		int Lebfxhld;
		while ((Lebfxhld = bXdgX53o.read(cWsuQXIK)) != -1)
			sgCRoV5b.write(cWsuQXIK, 0, Lebfxhld);
		sgCRoV5b.write("</BODY></HTML>".getBytes());
		sgCRoV5b.close();
		Browser.launch(e5QJibOo.toURL().toString());
	}

}