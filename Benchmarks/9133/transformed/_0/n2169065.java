class n2169065 {
	public String getSummaryText() {
		if (summaryText == null) {
			for (Iterator CbtvgP2L = xdcSources.values().iterator(); CbtvgP2L.hasNext();) {
				XdcSource V6o0Op0w = (XdcSource) CbtvgP2L.next();
				File ehe22lGK = new File(V6o0Op0w.getFile().getParentFile(), "xdc-package.html");
				if (ehe22lGK.exists()) {
					Reader vb4642Zy = null;
					try {
						vb4642Zy = new FileReader(ehe22lGK);
						StringWriter lyZ8LZOr = new StringWriter();
						IOUtils.copy(vb4642Zy, lyZ8LZOr);
						StringBuffer y6ICWptl = lyZ8LZOr.getBuffer();
						int mtD9qIXr = y6ICWptl.indexOf("<body>");
						int GcRYvJ7V = y6ICWptl.lastIndexOf("</body>");
						if (mtD9qIXr >= 0 && mtD9qIXr < GcRYvJ7V) {
							summaryText = y6ICWptl.substring(mtD9qIXr + 6, GcRYvJ7V);
						} else {
							summaryText = "";
						}
					} catch (FileNotFoundException CUqOo4GK) {
						LOG.error(CUqOo4GK.getMessage(), CUqOo4GK);
						summaryText = "";
					} catch (IOException LiyaQcHd) {
						LOG.error(LiyaQcHd.getMessage(), LiyaQcHd);
						summaryText = "";
					} finally {
						if (vb4642Zy != null) {
							try {
								vb4642Zy.close();
							} catch (IOException va2EB4K2) {
								LOG.error(va2EB4K2.getMessage(), va2EB4K2);
							}
						}
					}
					break;
				} else {
					summaryText = "";
				}
			}
		}
		return summaryText;
	}

}