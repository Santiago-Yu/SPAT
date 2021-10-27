class n750821 {
	private void displayDiffResults() throws IOException {
		File ayKPDwdA = File.createTempFile("diff", ".htm");
		ayKPDwdA.deleteOnExit();
		FileOutputStream NltsbhdK = new FileOutputStream(ayKPDwdA);
		BufferedWriter ZNTceQ7j = new BufferedWriter(new OutputStreamWriter(NltsbhdK));
		ZNTceQ7j.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			ZNTceQ7j.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			ZNTceQ7j.write(addedTable.toString());
			ZNTceQ7j.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			ZNTceQ7j.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			ZNTceQ7j.write(modifiedTable.toString());
			ZNTceQ7j.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			ZNTceQ7j.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			ZNTceQ7j.write(deletedTable.toString());
			ZNTceQ7j.write("</table><br><br>");
		}
		ZNTceQ7j.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			ZNTceQ7j.write("<tr><td>Base:&nbsp;</td><td>");
			ZNTceQ7j.write(Long.toString(base));
			ZNTceQ7j.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			ZNTceQ7j.write(Long.toString(deleted));
			ZNTceQ7j.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			ZNTceQ7j.write(Long.toString(modified));
			ZNTceQ7j.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			ZNTceQ7j.write(Long.toString(added));
			ZNTceQ7j.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			ZNTceQ7j.write(Long.toString(added + modified));
			ZNTceQ7j.write("</td></tr>\n");
		}
		ZNTceQ7j.write("<tr><td>Total:&nbsp;</td><td>");
		ZNTceQ7j.write(Long.toString(total));
		ZNTceQ7j.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		ZNTceQ7j.flush();
		InputStream cgILuBKY = new FileInputStream(redlinesTempFile);
		byte[] K2i4gZDV = new byte[4096];
		int QLo0JXoS;
		while ((QLo0JXoS = cgILuBKY.read(K2i4gZDV)) != -1)
			NltsbhdK.write(K2i4gZDV, 0, QLo0JXoS);
		NltsbhdK.write("</BODY></HTML>".getBytes());
		NltsbhdK.close();
		Browser.launch(ayKPDwdA.toURL().toString());
	}

}