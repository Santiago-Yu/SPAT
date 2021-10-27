class n417620 {
	private void displayDiffResults() throws IOException {
		File Dfd4ZEBg = File.createTempFile("diff", ".htm");
		Dfd4ZEBg.deleteOnExit();
		FileOutputStream OQWIOlfD = new FileOutputStream(Dfd4ZEBg);
		BufferedWriter VS4cZBfY = new BufferedWriter(new OutputStreamWriter(OQWIOlfD));
		VS4cZBfY.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			VS4cZBfY.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			VS4cZBfY.write(addedTable.toString());
			VS4cZBfY.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			VS4cZBfY.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			VS4cZBfY.write(modifiedTable.toString());
			VS4cZBfY.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			VS4cZBfY.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			VS4cZBfY.write(deletedTable.toString());
			VS4cZBfY.write("</table><br><br>");
		}
		VS4cZBfY.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			VS4cZBfY.write("<tr><td>Base:&nbsp;</td><td>");
			VS4cZBfY.write(Long.toString(base));
			VS4cZBfY.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			VS4cZBfY.write(Long.toString(deleted));
			VS4cZBfY.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			VS4cZBfY.write(Long.toString(modified));
			VS4cZBfY.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			VS4cZBfY.write(Long.toString(added));
			VS4cZBfY.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			VS4cZBfY.write(Long.toString(added + modified));
			VS4cZBfY.write("</td></tr>\n");
		}
		VS4cZBfY.write("<tr><td>Total:&nbsp;</td><td>");
		VS4cZBfY.write(Long.toString(total));
		VS4cZBfY.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		VS4cZBfY.flush();
		InputStream Zr3JO3gm = new FileInputStream(redlinesTempFile);
		byte[] smfz2JhT = new byte[4096];
		int evdn0aW2;
		while ((evdn0aW2 = Zr3JO3gm.read(smfz2JhT)) != -1)
			OQWIOlfD.write(smfz2JhT, 0, evdn0aW2);
		OQWIOlfD.write("</BODY></HTML>".getBytes());
		OQWIOlfD.close();
		Browser.launch(Dfd4ZEBg.toURL().toString());
	}

}