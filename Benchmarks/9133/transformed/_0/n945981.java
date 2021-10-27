class n945981 {
	private void displayDiffResults() throws IOException {
		File gyQn1rFf = File.createTempFile("diff", ".htm");
		gyQn1rFf.deleteOnExit();
		FileOutputStream g4mlkled = new FileOutputStream(gyQn1rFf);
		BufferedWriter ppYkfPsu = new BufferedWriter(new OutputStreamWriter(g4mlkled));
		ppYkfPsu.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			ppYkfPsu.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			ppYkfPsu.write(addedTable.toString());
			ppYkfPsu.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			ppYkfPsu.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			ppYkfPsu.write(modifiedTable.toString());
			ppYkfPsu.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			ppYkfPsu.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			ppYkfPsu.write(deletedTable.toString());
			ppYkfPsu.write("</table><br><br>");
		}
		ppYkfPsu.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			ppYkfPsu.write("<tr><td>Base:&nbsp;</td><td>");
			ppYkfPsu.write(Long.toString(base));
			ppYkfPsu.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			ppYkfPsu.write(Long.toString(deleted));
			ppYkfPsu.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			ppYkfPsu.write(Long.toString(modified));
			ppYkfPsu.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			ppYkfPsu.write(Long.toString(added));
			ppYkfPsu.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			ppYkfPsu.write(Long.toString(added + modified));
			ppYkfPsu.write("</td></tr>\n");
		}
		ppYkfPsu.write("<tr><td>Total:&nbsp;</td><td>");
		ppYkfPsu.write(Long.toString(total));
		ppYkfPsu.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		ppYkfPsu.flush();
		InputStream Riqpw9pf = new FileInputStream(redlinesTempFile);
		byte[] E6EZTlMV = new byte[4096];
		int lh5QomXD;
		while ((lh5QomXD = Riqpw9pf.read(E6EZTlMV)) != -1)
			g4mlkled.write(E6EZTlMV, 0, lh5QomXD);
		g4mlkled.write("</BODY></HTML>".getBytes());
		g4mlkled.close();
		Browser.launch(gyQn1rFf.toURL().toString());
	}

}