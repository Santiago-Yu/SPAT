class n361255 {
	private void displayDiffResults() throws IOException {
		File elXLJ0K2 = File.createTempFile("diff", ".htm");
		elXLJ0K2.deleteOnExit();
		FileOutputStream ORVdreP9 = new FileOutputStream(elXLJ0K2);
		BufferedWriter JdS14agT = new BufferedWriter(new OutputStreamWriter(ORVdreP9));
		JdS14agT.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			JdS14agT.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			JdS14agT.write(addedTable.toString());
			JdS14agT.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			JdS14agT.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			JdS14agT.write(modifiedTable.toString());
			JdS14agT.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			JdS14agT.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			JdS14agT.write(deletedTable.toString());
			JdS14agT.write("</table><br><br>");
		}
		JdS14agT.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			JdS14agT.write("<tr><td>Base:&nbsp;</td><td>");
			JdS14agT.write(Long.toString(base));
			JdS14agT.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			JdS14agT.write(Long.toString(deleted));
			JdS14agT.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			JdS14agT.write(Long.toString(modified));
			JdS14agT.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			JdS14agT.write(Long.toString(added));
			JdS14agT.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			JdS14agT.write(Long.toString(added + modified));
			JdS14agT.write("</td></tr>\n");
		}
		JdS14agT.write("<tr><td>Total:&nbsp;</td><td>");
		JdS14agT.write(Long.toString(total));
		JdS14agT.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		JdS14agT.flush();
		InputStream M2y6uLjR = new FileInputStream(redlinesTempFile);
		byte[] yTbVJqjl = new byte[4096];
		int UWFM1aHd;
		while ((UWFM1aHd = M2y6uLjR.read(yTbVJqjl)) != -1)
			ORVdreP9.write(yTbVJqjl, 0, UWFM1aHd);
		ORVdreP9.write("</BODY></HTML>".getBytes());
		ORVdreP9.close();
		Browser.launch(elXLJ0K2.toURL().toString());
	}

}