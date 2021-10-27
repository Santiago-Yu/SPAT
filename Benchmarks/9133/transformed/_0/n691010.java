class n691010 {
	private void displayDiffResults() throws IOException {
		File CXNVNK3O = File.createTempFile("diff", ".htm");
		CXNVNK3O.deleteOnExit();
		FileOutputStream GLiudoEY = new FileOutputStream(CXNVNK3O);
		BufferedWriter Eke9648W = new BufferedWriter(new OutputStreamWriter(GLiudoEY));
		Eke9648W.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			Eke9648W.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			Eke9648W.write(addedTable.toString());
			Eke9648W.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			Eke9648W.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			Eke9648W.write(modifiedTable.toString());
			Eke9648W.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			Eke9648W.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			Eke9648W.write(deletedTable.toString());
			Eke9648W.write("</table><br><br>");
		}
		Eke9648W.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			Eke9648W.write("<tr><td>Base:&nbsp;</td><td>");
			Eke9648W.write(Long.toString(base));
			Eke9648W.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			Eke9648W.write(Long.toString(deleted));
			Eke9648W.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			Eke9648W.write(Long.toString(modified));
			Eke9648W.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			Eke9648W.write(Long.toString(added));
			Eke9648W.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			Eke9648W.write(Long.toString(added + modified));
			Eke9648W.write("</td></tr>\n");
		}
		Eke9648W.write("<tr><td>Total:&nbsp;</td><td>");
		Eke9648W.write(Long.toString(total));
		Eke9648W.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		Eke9648W.flush();
		InputStream PXjR5dzP = new FileInputStream(redlinesTempFile);
		byte[] DietBXsA = new byte[4096];
		int e3EtLyxE;
		while ((e3EtLyxE = PXjR5dzP.read(DietBXsA)) != -1)
			GLiudoEY.write(DietBXsA, 0, e3EtLyxE);
		GLiudoEY.write("</BODY></HTML>".getBytes());
		GLiudoEY.close();
		Browser.launch(CXNVNK3O.toURL().toString());
	}

}