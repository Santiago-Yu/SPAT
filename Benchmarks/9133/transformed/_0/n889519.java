class n889519 {
	private void displayDiffResults() throws IOException {
		File w7VeWRiX = File.createTempFile("diff", ".htm");
		w7VeWRiX.deleteOnExit();
		FileOutputStream pgpoGcb8 = new FileOutputStream(w7VeWRiX);
		BufferedWriter rdfY8PnE = new BufferedWriter(new OutputStreamWriter(pgpoGcb8));
		rdfY8PnE.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			rdfY8PnE.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			rdfY8PnE.write(addedTable.toString());
			rdfY8PnE.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			rdfY8PnE.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			rdfY8PnE.write(modifiedTable.toString());
			rdfY8PnE.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			rdfY8PnE.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			rdfY8PnE.write(deletedTable.toString());
			rdfY8PnE.write("</table><br><br>");
		}
		rdfY8PnE.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			rdfY8PnE.write("<tr><td>Base:&nbsp;</td><td>");
			rdfY8PnE.write(Long.toString(base));
			rdfY8PnE.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			rdfY8PnE.write(Long.toString(deleted));
			rdfY8PnE.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			rdfY8PnE.write(Long.toString(modified));
			rdfY8PnE.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			rdfY8PnE.write(Long.toString(added));
			rdfY8PnE.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			rdfY8PnE.write(Long.toString(added + modified));
			rdfY8PnE.write("</td></tr>\n");
		}
		rdfY8PnE.write("<tr><td>Total:&nbsp;</td><td>");
		rdfY8PnE.write(Long.toString(total));
		rdfY8PnE.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		rdfY8PnE.flush();
		InputStream ndp2GLuY = new FileInputStream(redlinesTempFile);
		byte[] PBAjEW0s = new byte[4096];
		int bRJ48I6t;
		while ((bRJ48I6t = ndp2GLuY.read(PBAjEW0s)) != -1)
			pgpoGcb8.write(PBAjEW0s, 0, bRJ48I6t);
		pgpoGcb8.write("</BODY></HTML>".getBytes());
		pgpoGcb8.close();
		Browser.launch(w7VeWRiX.toURL().toString());
	}

}