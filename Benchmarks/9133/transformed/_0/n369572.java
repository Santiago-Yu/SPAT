class n369572 {
	private void displayDiffResults() throws IOException {
		File NJ8Dvsr0 = File.createTempFile("diff", ".htm");
		NJ8Dvsr0.deleteOnExit();
		FileOutputStream Y2HvQTPK = new FileOutputStream(NJ8Dvsr0);
		BufferedWriter RtO9wz94 = new BufferedWriter(new OutputStreamWriter(Y2HvQTPK));
		RtO9wz94.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			RtO9wz94.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			RtO9wz94.write(addedTable.toString());
			RtO9wz94.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			RtO9wz94.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			RtO9wz94.write(modifiedTable.toString());
			RtO9wz94.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			RtO9wz94.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			RtO9wz94.write(deletedTable.toString());
			RtO9wz94.write("</table><br><br>");
		}
		RtO9wz94.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			RtO9wz94.write("<tr><td>Base:&nbsp;</td><td>");
			RtO9wz94.write(Long.toString(base));
			RtO9wz94.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			RtO9wz94.write(Long.toString(deleted));
			RtO9wz94.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			RtO9wz94.write(Long.toString(modified));
			RtO9wz94.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			RtO9wz94.write(Long.toString(added));
			RtO9wz94.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			RtO9wz94.write(Long.toString(added + modified));
			RtO9wz94.write("</td></tr>\n");
		}
		RtO9wz94.write("<tr><td>Total:&nbsp;</td><td>");
		RtO9wz94.write(Long.toString(total));
		RtO9wz94.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		RtO9wz94.flush();
		InputStream qNkeWPAq = new FileInputStream(redlinesTempFile);
		byte[] hjvBXAfE = new byte[4096];
		int LOU2Usjg;
		while ((LOU2Usjg = qNkeWPAq.read(hjvBXAfE)) != -1)
			Y2HvQTPK.write(hjvBXAfE, 0, LOU2Usjg);
		Y2HvQTPK.write("</BODY></HTML>".getBytes());
		Y2HvQTPK.close();
		Browser.launch(NJ8Dvsr0.toURL().toString());
	}

}