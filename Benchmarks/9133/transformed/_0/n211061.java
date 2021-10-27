class n211061 {
	private void displayDiffResults() throws IOException {
		File LMKNYoCu = File.createTempFile("diff", ".htm");
		LMKNYoCu.deleteOnExit();
		FileOutputStream YZ6ij3Wj = new FileOutputStream(LMKNYoCu);
		BufferedWriter GEr9GUYF = new BufferedWriter(new OutputStreamWriter(YZ6ij3Wj));
		GEr9GUYF.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			GEr9GUYF.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			GEr9GUYF.write(addedTable.toString());
			GEr9GUYF.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			GEr9GUYF.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			GEr9GUYF.write(modifiedTable.toString());
			GEr9GUYF.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			GEr9GUYF.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			GEr9GUYF.write(deletedTable.toString());
			GEr9GUYF.write("</table><br><br>");
		}
		GEr9GUYF.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			GEr9GUYF.write("<tr><td>Base:&nbsp;</td><td>");
			GEr9GUYF.write(Long.toString(base));
			GEr9GUYF.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			GEr9GUYF.write(Long.toString(deleted));
			GEr9GUYF.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			GEr9GUYF.write(Long.toString(modified));
			GEr9GUYF.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			GEr9GUYF.write(Long.toString(added));
			GEr9GUYF.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			GEr9GUYF.write(Long.toString(added + modified));
			GEr9GUYF.write("</td></tr>\n");
		}
		GEr9GUYF.write("<tr><td>Total:&nbsp;</td><td>");
		GEr9GUYF.write(Long.toString(total));
		GEr9GUYF.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		GEr9GUYF.flush();
		InputStream SDf5QfVP = new FileInputStream(redlinesTempFile);
		byte[] UbaIJUe0 = new byte[4096];
		int elnaqjpx;
		while ((elnaqjpx = SDf5QfVP.read(UbaIJUe0)) != -1)
			YZ6ij3Wj.write(UbaIJUe0, 0, elnaqjpx);
		YZ6ij3Wj.write("</BODY></HTML>".getBytes());
		YZ6ij3Wj.close();
		Browser.launch(LMKNYoCu.toURL().toString());
	}

}