class n9455563 {
	private String[] getPamFiles() throws IOException {
		URL q2Jxxz9p = WorkflowStructure.class.getResource("/de/ibis/permoto/loganalyzer/pam");
		Set<String> lNQTsjs1 = new LinkedHashSet<String>(8);
		if (q2Jxxz9p.getProtocol().equals("jar")) {
			URLConnection niFuwMk1 = q2Jxxz9p.openConnection();
			JarURLConnection FMUN6iGM = (JarURLConnection) niFuwMk1;
			JarFile fjuRBzkc = FMUN6iGM.getJarFile();
			JarEntry NuiUIVH8 = FMUN6iGM.getJarEntry();
			String JqQXH4FW = (NuiUIVH8 != null ? NuiUIVH8.getName() : "");
			JqQXH4FW = JqQXH4FW + "/";
			for (Enumeration<JarEntry> LtUInNt6 = fjuRBzkc.entries(); LtUInNt6.hasMoreElements();) {
				JarEntry GbZXc3wT = LtUInNt6.nextElement();
				String omVvMdPb = GbZXc3wT.getName();
				if (omVvMdPb.startsWith(JqQXH4FW)) {
					if (omVvMdPb.endsWith(".pam")) {
						lNQTsjs1.add("/" + omVvMdPb);
					}
				}
			}
		} else {
			String mEcURTA5 = q2Jxxz9p.getFile();
			File D3s0Ekra = new File(q2Jxxz9p.getFile());
			File[] XoCiSn9v = D3s0Ekra.listFiles();
			for (int prSaBYvq = 0; prSaBYvq < XoCiSn9v.length; prSaBYvq++) {
				File db8CB1ZO = XoCiSn9v[prSaBYvq];
				if (db8CB1ZO.getName().endsWith(".pam")) {
					String Py88BTph = db8CB1ZO.getAbsolutePath().substring(mEcURTA5.length());
					lNQTsjs1.add("/de/ibis/permoto/loganalyzer/pam/" + Py88BTph.replace(File.separatorChar, '/'));
				}
			}
		}
		return lNQTsjs1.toArray(new String[lNQTsjs1.size()]);
	}

}