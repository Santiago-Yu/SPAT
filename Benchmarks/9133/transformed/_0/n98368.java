class n98368 {
	private void displayDiffResults() throws IOException {
		File H8lv6WMj = File.createTempFile("diff", ".htm");
		H8lv6WMj.deleteOnExit();
		FileOutputStream k0mmlseh = new FileOutputStream(H8lv6WMj);
		BufferedWriter kf2S5wZr = new BufferedWriter(new OutputStreamWriter(k0mmlseh));
		kf2S5wZr.write("<html><head><title>LOC Differences</title>\n" + SCRIPT + "</head>\n"
				+ "<body bgcolor='#ffffff'>\n" + "<div onMouseOver=\"window.defaultStatus='Metrics'\">\n");
		if (addedTable.length() > 0) {
			kf2S5wZr.write("<table border><tr><th>Files Added:</th>" + "<th>Add</th><th>Type</th></tr>");
			kf2S5wZr.write(addedTable.toString());
			kf2S5wZr.write("</table><br><br>");
		}
		if (modifiedTable.length() > 0) {
			kf2S5wZr.write("<table border><tr><th>Files Modified:</th>"
					+ "<th>Base</th><th>Del</th><th>Mod</th><th>Add</th>" + "<th>Total</th><th>Type</th></tr>");
			kf2S5wZr.write(modifiedTable.toString());
			kf2S5wZr.write("</table><br><br>");
		}
		if (deletedTable.length() > 0) {
			kf2S5wZr.write("<table border><tr><th>Files Deleted:</th>" + "<th>Del</th><th>Type</th></tr>");
			kf2S5wZr.write(deletedTable.toString());
			kf2S5wZr.write("</table><br><br>");
		}
		kf2S5wZr.write("<table name=METRICS BORDER>\n");
		if (modifiedTable.length() > 0 || deletedTable.length() > 0) {
			kf2S5wZr.write("<tr><td>Base:&nbsp;</td><td>");
			kf2S5wZr.write(Long.toString(base));
			kf2S5wZr.write("</td></tr>\n<tr><td>Deleted:&nbsp;</td><td>");
			kf2S5wZr.write(Long.toString(deleted));
			kf2S5wZr.write("</td></tr>\n<tr><td>Modified:&nbsp;</td><td>");
			kf2S5wZr.write(Long.toString(modified));
			kf2S5wZr.write("</td></tr>\n<tr><td>Added:&nbsp;</td><td>");
			kf2S5wZr.write(Long.toString(added));
			kf2S5wZr.write("</td></tr>\n<tr><td>New & Changed:&nbsp;</td><td>");
			kf2S5wZr.write(Long.toString(added + modified));
			kf2S5wZr.write("</td></tr>\n");
		}
		kf2S5wZr.write("<tr><td>Total:&nbsp;</td><td>");
		kf2S5wZr.write(Long.toString(total));
		kf2S5wZr.write("</td></tr>\n</table></div>");
		redlinesOut.close();
		kf2S5wZr.flush();
		InputStream fnLRR6aH = new FileInputStream(redlinesTempFile);
		byte[] RfU27CVk = new byte[4096];
		int LAJ1w2QC;
		while ((LAJ1w2QC = fnLRR6aH.read(RfU27CVk)) != -1)
			k0mmlseh.write(RfU27CVk, 0, LAJ1w2QC);
		k0mmlseh.write("</BODY></HTML>".getBytes());
		k0mmlseh.close();
		Browser.launch(H8lv6WMj.toURL().toString());
	}

}