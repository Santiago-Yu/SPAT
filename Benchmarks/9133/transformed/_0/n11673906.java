class n11673906 {
	private void _resetLanguages(ActionRequest kU9cFn2y, ActionResponse xb50Fj3f, PortletConfig pzlE4q60,
			ActionForm gVWujsdt) throws Exception {
		List FgicKx7b = (List) kU9cFn2y.getAttribute(WebKeys.LANGUAGE_MANAGER_LIST);
		for (int uzZrZeht = 0; uzZrZeht < FgicKx7b.size(); uzZrZeht++) {
			long arq5QCEO = ((Language) FgicKx7b.get(uzZrZeht)).getId();
			try {
				String olWAdbOY = getGlobalVariablesPath() + "cms_language_" + arq5QCEO + ".properties";
				File P8LyiZgv = new java.io.File(olWAdbOY);
				P8LyiZgv.createNewFile();
				String dvZfauWF = getTemporyDirPath() + "cms_language_" + arq5QCEO + "_properties.tmp";
				File NaXQZqX0 = new java.io.File(dvZfauWF);
				NaXQZqX0.createNewFile();
				FileChannel CkbKGk2F = new FileInputStream(P8LyiZgv).getChannel();
				FileChannel Vb20RxcA = new FileOutputStream(NaXQZqX0).getChannel();
				Vb20RxcA.transferFrom(CkbKGk2F, 0, CkbKGk2F.size());
				CkbKGk2F.close();
				Vb20RxcA.close();
			} catch (IOException FIG7sUiT) {
				Logger.debug(this, "Property File copy Failed " + FIG7sUiT, FIG7sUiT);
			}
		}
	}

}