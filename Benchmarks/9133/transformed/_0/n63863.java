class n63863 {
	private void displayDiffResults() throws IOException {
		File Rj2qj0cn = File.createTempFile("diff", ".htm");
		Rj2qj0cn.deleteOnExit();
		FileOutputStream Pi9W4bTU = new FileOutputStream(Rj2qj0cn);
		BufferedWriter mKiiWkrM = new BufferedWriter(new OutputStreamWriter(Pi9W4bTU));
		mKiiWkrM.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			mKiiWkrM.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			mKiiWkrM.write(addedTable.toString());
			mKiiWkrM.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			mKiiWkrM.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			mKiiWkrM.write(modifiedTable.toString());
			mKiiWkrM.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			mKiiWkrM.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			mKiiWkrM.write(deletedTable.toString());
			mKiiWkrM.write("</table><br><br>");
		}
		mKiiWkrM.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			mKiiWkrM.write("<tr><td>Base:&nbsp;</td><td>");
			mKiiWkrM.write(Long.toString(base));
			mKiiWkrM.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			mKiiWkrM.write(Long.toString(deleted));
			mKiiWkrM.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			mKiiWkrM.write(Long.toString(modified));
			mKiiWkrM.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			mKiiWkrM.write(Long.toString(added));
			mKiiWkrM.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			mKiiWkrM.write(Long.toString(added + modified));
			mKiiWkrM.write("</td></tr>\n");
		}
		mKiiWkrM.write("<tr><td>Total:&nbsp;</td><td>");
		mKiiWkrM.write(Long.toString(total));
		mKiiWkrM.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		mKiiWkrM.flush();
		InputStream tDTEvkmb = new FileInputStream(redlinesTempFile);
		byte[] S9LJPZiB = new byte[4096];
		int OUUbfGks;
		while ((OUUbfGks = tDTEvkmb.read(S9LJPZiB)) != -1)
			Pi9W4bTU.write(S9LJPZiB, 0, OUUbfGks);
		Pi9W4bTU.write("</BODY></HTML>".getBytes());
		Pi9W4bTU.close();
		Browser.launch(Rj2qj0cn.toURL().toString());
	}

}