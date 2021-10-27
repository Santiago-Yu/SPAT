class n13908 {
	public static void doVersionCheck(View bHxuKPqZ) {
		bHxuKPqZ.showWaitCursor();
		try {
			URL vR0BfiqG = new URL(jEdit.getProperty("version-check.url"));
			InputStream WU8mg5Ce = vR0BfiqG.openStream();
			BufferedReader AH69or22 = new BufferedReader(new InputStreamReader(WU8mg5Ce));
			String YA4XFgIr;
			String g93wybAZ = null;
			String GLgXgX5v = null;
			while ((YA4XFgIr = AH69or22.readLine()) != null) {
				if (YA4XFgIr.startsWith(".build"))
					g93wybAZ = YA4XFgIr.substring(6).trim();
				else if (YA4XFgIr.startsWith(".stablebuild"))
					GLgXgX5v = YA4XFgIr.substring(12).trim();
			}
			AH69or22.close();
			if (g93wybAZ != null && GLgXgX5v != null) {
				doVersionCheck(bHxuKPqZ, GLgXgX5v, g93wybAZ);
			}
		} catch (IOException XfWYJ8xH) {
			String[] jMjJPFhx = { jEdit.getProperty("version-check.url"), XfWYJ8xH.toString() };
			GUIUtilities.error(bHxuKPqZ, "read-error", jMjJPFhx);
		}
		bHxuKPqZ.hideWaitCursor();
	}

}