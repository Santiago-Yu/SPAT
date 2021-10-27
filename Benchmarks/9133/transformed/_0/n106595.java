class n106595 {
	private void displayDiffResults() throws IOException {
		File iNm4cyib = File.createTempFile("diff", ".htm");
		iNm4cyib.deleteOnExit();
		FileOutputStream N2iz1HRY = new FileOutputStream(iNm4cyib);
		BufferedWriter CKLIzVm8 = new BufferedWriter(new OutputStreamWriter(N2iz1HRY));
		CKLIzVm8.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			CKLIzVm8.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			CKLIzVm8.write(addedTable.toString());
			CKLIzVm8.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			CKLIzVm8.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			CKLIzVm8.write(modifiedTable.toString());
			CKLIzVm8.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			CKLIzVm8.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			CKLIzVm8.write(deletedTable.toString());
			CKLIzVm8.write("</table><br><br>");
		}
		CKLIzVm8.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			CKLIzVm8.write("<tr><td>Base:&nbsp;</td><td>");
			CKLIzVm8.write(Long.toString(base));
			CKLIzVm8.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			CKLIzVm8.write(Long.toString(deleted));
			CKLIzVm8.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			CKLIzVm8.write(Long.toString(modified));
			CKLIzVm8.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			CKLIzVm8.write(Long.toString(added));
			CKLIzVm8.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			CKLIzVm8.write(Long.toString(added + modified));
			CKLIzVm8.write("</td></tr>\n");
		}
		CKLIzVm8.write("<tr><td>Total:&nbsp;</td><td>");
		CKLIzVm8.write(Long.toString(total));
		CKLIzVm8.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		CKLIzVm8.flush();
		InputStream iaC7kxtg = new FileInputStream(redlinesTempFile);
		byte[] oaFLYds8 = new byte[4096];
		int qdp5dtLX;
		while ((qdp5dtLX = iaC7kxtg.read(oaFLYds8)) != -1)
			N2iz1HRY.write(oaFLYds8, 0, qdp5dtLX);
		N2iz1HRY.write("</BODY></HTML>".getBytes());
		N2iz1HRY.close();
		Browser.launch(iNm4cyib.toURL().toString());
	}

}