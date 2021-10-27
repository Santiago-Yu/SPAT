class n373792 {
	private void displayDiffResults() throws IOException {
		File VWLzMUdb = File.createTempFile("diff", ".htm");
		VWLzMUdb.deleteOnExit();
		FileOutputStream SD73os0w = new FileOutputStream(VWLzMUdb);
		BufferedWriter roTCT8EM = new BufferedWriter(new OutputStreamWriter(SD73os0w));
		roTCT8EM.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			roTCT8EM.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			roTCT8EM.write(addedTable.toString());
			roTCT8EM.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			roTCT8EM.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			roTCT8EM.write(modifiedTable.toString());
			roTCT8EM.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			roTCT8EM.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			roTCT8EM.write(deletedTable.toString());
			roTCT8EM.write("</table><br><br>");
		}
		roTCT8EM.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			roTCT8EM.write("<tr><td>Base:&nbsp;</td><td>");
			roTCT8EM.write(Long.toString(base));
			roTCT8EM.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			roTCT8EM.write(Long.toString(deleted));
			roTCT8EM.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			roTCT8EM.write(Long.toString(modified));
			roTCT8EM.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			roTCT8EM.write(Long.toString(added));
			roTCT8EM.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			roTCT8EM.write(Long.toString(added + modified));
			roTCT8EM.write("</td></tr>\n");
		}
		roTCT8EM.write("<tr><td>Total:&nbsp;</td><td>");
		roTCT8EM.write(Long.toString(total));
		roTCT8EM.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		roTCT8EM.flush();
		InputStream JNKKPlaC = new FileInputStream(redlinesTempFile);
		byte[] JsDABRJ2 = new byte[4096];
		int NDCAVmMr;
		while ((NDCAVmMr = JNKKPlaC.read(JsDABRJ2)) != -1)
			SD73os0w.write(JsDABRJ2, 0, NDCAVmMr);
		SD73os0w.write("</BODY></HTML>".getBytes());
		SD73os0w.close();
		Browser.launch(VWLzMUdb.toURL().toString());
	}

}