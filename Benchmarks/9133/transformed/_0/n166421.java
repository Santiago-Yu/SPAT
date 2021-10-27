class n166421 {
	private void displayDiffResults() throws IOException {
		File VqPtUnxF = File.createTempFile("diff", ".htm");
		VqPtUnxF.deleteOnExit();
		FileOutputStream AGdVipRW = new FileOutputStream(VqPtUnxF);
		BufferedWriter oiAFRzWI = new BufferedWriter(new OutputStreamWriter(AGdVipRW));
		oiAFRzWI.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			oiAFRzWI.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			oiAFRzWI.write(addedTable.toString());
			oiAFRzWI.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			oiAFRzWI.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			oiAFRzWI.write(modifiedTable.toString());
			oiAFRzWI.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			oiAFRzWI.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			oiAFRzWI.write(deletedTable.toString());
			oiAFRzWI.write("</table><br><br>");
		}
		oiAFRzWI.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			oiAFRzWI.write("<tr><td>Base:&nbsp;</td><td>");
			oiAFRzWI.write(Long.toString(base));
			oiAFRzWI.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			oiAFRzWI.write(Long.toString(deleted));
			oiAFRzWI.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			oiAFRzWI.write(Long.toString(modified));
			oiAFRzWI.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			oiAFRzWI.write(Long.toString(added));
			oiAFRzWI.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			oiAFRzWI.write(Long.toString(added + modified));
			oiAFRzWI.write("</td></tr>\n");
		}
		oiAFRzWI.write("<tr><td>Total:&nbsp;</td><td>");
		oiAFRzWI.write(Long.toString(total));
		oiAFRzWI.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		oiAFRzWI.flush();
		InputStream mZ9GddBt = new FileInputStream(redlinesTempFile);
		byte[] ELiSGbe4 = new byte[4096];
		int zo2FI8vd;
		while ((zo2FI8vd = mZ9GddBt.read(ELiSGbe4)) != -1)
			AGdVipRW.write(ELiSGbe4, 0, zo2FI8vd);
		AGdVipRW.write("</BODY></HTML>".getBytes());
		AGdVipRW.close();
		Browser.launch(VqPtUnxF.toURL().toString());
	}

}