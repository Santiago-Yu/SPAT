class n471804 {
	public static void doVersionCheck(View fIoC18ln) {
		fIoC18ln.showWaitCursor();
		try {
			URL w5baPPb6 = new URL(jEdit.getProperty("version-check.url"));
			InputStream PfK138v2 = w5baPPb6.openStream();
			BufferedReader hhZYi0Mv = new BufferedReader(new InputStreamReader(PfK138v2));
			String dYiV6g30;
			String nT8K8APX = null;
			String GVcDpUgH = null;
			while ((dYiV6g30 = hhZYi0Mv.readLine()) != null) {
				if (dYiV6g30.startsWith(".version"))
					nT8K8APX = dYiV6g30.substring(8).trim();
				else if (dYiV6g30.startsWith(".build"))
					GVcDpUgH = dYiV6g30.substring(6).trim();
			}
			hhZYi0Mv.close();
			if (nT8K8APX != null && GVcDpUgH != null) {
				if (jEdit.getBuild().compareTo(GVcDpUgH) < 0)
					newVersionAvailable(fIoC18ln, nT8K8APX, w5baPPb6);
				else {
					GUIUtilities.message(fIoC18ln, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException jVsVplLX) {
			String[] f9Re9xZi = { jEdit.getProperty("version-check.url"), jVsVplLX.toString() };
			GUIUtilities.error(fIoC18ln, "read-error", f9Re9xZi);
		}
		fIoC18ln.hideWaitCursor();
	}

}