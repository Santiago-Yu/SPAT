class n330930 {
	private void displayDiffResults() throws IOException {
		File fgvcil2u = File.createTempFile("diff", ".htm");
		fgvcil2u.deleteOnExit();
		FileOutputStream oT1aLgvr = new FileOutputStream(fgvcil2u);
		BufferedWriter pjT8hNix = new BufferedWriter(new OutputStreamWriter(oT1aLgvr));
		pjT8hNix.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			pjT8hNix.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			pjT8hNix.write(addedTable.toString());
			pjT8hNix.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			pjT8hNix.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			pjT8hNix.write(modifiedTable.toString());
			pjT8hNix.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			pjT8hNix.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			pjT8hNix.write(deletedTable.toString());
			pjT8hNix.write("</table><br><br>");
		}
		pjT8hNix.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			pjT8hNix.write("<tr><td>Base:&nbsp;</td><td>");
			pjT8hNix.write(Long.toString(base));
			pjT8hNix.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			pjT8hNix.write(Long.toString(deleted));
			pjT8hNix.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			pjT8hNix.write(Long.toString(modified));
			pjT8hNix.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			pjT8hNix.write(Long.toString(added));
			pjT8hNix.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			pjT8hNix.write(Long.toString(added + modified));
			pjT8hNix.write("</td></tr>\n");
		}
		pjT8hNix.write("<tr><td>Total:&nbsp;</td><td>");
		pjT8hNix.write(Long.toString(total));
		pjT8hNix.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		pjT8hNix.flush();
		InputStream zdnVgt9X = new FileInputStream(redlinesTempFile);
		byte[] vsd8anCV = new byte[4096];
		int MQa55s80;
		while ((MQa55s80 = zdnVgt9X.read(vsd8anCV)) != -1)
			oT1aLgvr.write(vsd8anCV, 0, MQa55s80);
		oT1aLgvr.write("</BODY></HTML>".getBytes());
		oT1aLgvr.close();
		Browser.launch(fgvcil2u.toURL().toString());
	}

}