class n921317 {
	private void displayDiffResults() throws IOException {
		File Juxiuq7b = File.createTempFile("diff", ".htm");
		Juxiuq7b.deleteOnExit();
		FileOutputStream KzHXzoom = new FileOutputStream(Juxiuq7b);
		BufferedWriter HcRLF2jM = new BufferedWriter(new OutputStreamWriter(KzHXzoom));
		HcRLF2jM.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			HcRLF2jM.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			HcRLF2jM.write(addedTable.toString());
			HcRLF2jM.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			HcRLF2jM.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			HcRLF2jM.write(modifiedTable.toString());
			HcRLF2jM.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			HcRLF2jM.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			HcRLF2jM.write(deletedTable.toString());
			HcRLF2jM.write("</table><br><br>");
		}
		HcRLF2jM.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			HcRLF2jM.write("<tr><td>Base:&nbsp;</td><td>");
			HcRLF2jM.write(Long.toString(base));
			HcRLF2jM.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			HcRLF2jM.write(Long.toString(deleted));
			HcRLF2jM.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			HcRLF2jM.write(Long.toString(modified));
			HcRLF2jM.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			HcRLF2jM.write(Long.toString(added));
			HcRLF2jM.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			HcRLF2jM.write(Long.toString(added + modified));
			HcRLF2jM.write("</td></tr>\n");
		}
		HcRLF2jM.write("<tr><td>Total:&nbsp;</td><td>");
		HcRLF2jM.write(Long.toString(total));
		HcRLF2jM.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		HcRLF2jM.flush();
		InputStream cvuaMGyJ = new FileInputStream(redlinesTempFile);
		byte[] UhSGlYto = new byte[4096];
		int ClbqwUOR;
		while ((ClbqwUOR = cvuaMGyJ.read(UhSGlYto)) != -1)
			KzHXzoom.write(UhSGlYto, 0, ClbqwUOR);
		KzHXzoom.write("</BODY></HTML>".getBytes());
		KzHXzoom.close();
		Browser.launch(Juxiuq7b.toURL().toString());
	}

}