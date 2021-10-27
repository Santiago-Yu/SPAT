class n14167175 {
	public static void readAsFile(String ZusaOll7, String eQjO53PR) {
		BufferedInputStream ZiJGsE3R = null;
		BufferedOutputStream VxDJtDWH = null;
		URLConnection t35gvItk = null;
		try {
			t35gvItk = new URL(eQjO53PR).openConnection();
			t35gvItk.setDoInput(true);
			ZiJGsE3R = new BufferedInputStream(t35gvItk.getInputStream());
			VxDJtDWH = new BufferedOutputStream(new FileOutputStream(ZusaOll7));
			int SX9jTyLH;
			while ((SX9jTyLH = ZiJGsE3R.read()) != -1) {
				VxDJtDWH.write(SX9jTyLH);
			}
		} catch (Exception nOkSYKqQ) {
			log.error(nOkSYKqQ.getMessage(), nOkSYKqQ);
		} finally {
			if (null != ZiJGsE3R) {
				try {
					ZiJGsE3R.close();
				} catch (IOException Q5drgn99) {
				}
			}
			if (null != VxDJtDWH) {
				try {
					VxDJtDWH.flush();
					VxDJtDWH.close();
				} catch (IOException K12nErG6) {
				}
			}
		}
	}

}