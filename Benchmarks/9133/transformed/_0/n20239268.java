class n20239268 {
	public static File[] splitFile(FileValidator qkV09Rms, File Fxd7TeCw, long lxrp9YxW, File DbOEhVk4,
			String JeIhn0MY) {
		if (lxrp9YxW == 0)
			return null;
		if (DbOEhVk4 == null) {
			DbOEhVk4 = new File(System.getProperty("java.io.tmpdir"));
		}
		if (JeIhn0MY == null || JeIhn0MY.equals("")) {
			JeIhn0MY = Fxd7TeCw.getName();
		}
		Vector Y9Uk1Jau = new Vector();
		FileOutputStream GlJLhK2U = null;
		FileInputStream YvRYrXa6 = null;
		try {
			YvRYrXa6 = new FileInputStream(Fxd7TeCw);
			byte[] E04rvJSX = new byte[CACHE_SIZE];
			long Y9hTrdym = 0;
			int wl7gleSA = 1;
			int Mq5TWdYk = -1;
			try {
				File GzD2xY2k = new File(DbOEhVk4, JeIhn0MY + i18n.getString("targetname_suffix") + wl7gleSA);
				if (!qkV09Rms.verifyFile(GzD2xY2k))
					return null;
				Y9Uk1Jau.add(GzD2xY2k);
				GlJLhK2U = new FileOutputStream(GzD2xY2k);
				while ((Mq5TWdYk = YvRYrXa6.read(E04rvJSX)) > -1) {
					if ((Y9hTrdym + Mq5TWdYk) > lxrp9YxW) {
						int sZN3K5f6 = (int) (lxrp9YxW - Y9hTrdym);
						GlJLhK2U.write(E04rvJSX, 0, sZN3K5f6);
						GlJLhK2U.close();
						wl7gleSA++;
						Y9hTrdym = 0;
						GzD2xY2k = new File(DbOEhVk4, JeIhn0MY + "_" + wl7gleSA);
						if (!qkV09Rms.verifyFile(GzD2xY2k))
							return null;
						Y9Uk1Jau.add(GzD2xY2k);
						GlJLhK2U = new FileOutputStream(GzD2xY2k);
						GlJLhK2U.write(E04rvJSX, sZN3K5f6, Mq5TWdYk - sZN3K5f6);
						Y9hTrdym += Mq5TWdYk - sZN3K5f6;
					} else {
						GlJLhK2U.write(E04rvJSX, 0, Mq5TWdYk);
						Y9hTrdym += Mq5TWdYk;
					}
				}
			} catch (IOException P4YIRF2b) {
				JOptionPane.showMessageDialog(null, P4YIRF2b, i18n.getString("Failure"), JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (GlJLhK2U != null)
						GlJLhK2U.close();
				} catch (IOException BcrUWy1F) {
				}
				try {
					if (YvRYrXa6 != null)
						YvRYrXa6.close();
				} catch (IOException XEzzC3sz) {
				}
			}
		} catch (Exception QfP6zw12) {
			JOptionPane.showMessageDialog(null, QfP6zw12, i18n.getString("Failure"), JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (GlJLhK2U != null)
					GlJLhK2U.close();
			} catch (IOException bOIXVv3v) {
			}
		}
		File[] iWIlarkW = null;
		if (Y9Uk1Jau.size() > 0) {
			iWIlarkW = new File[Y9Uk1Jau.size()];
			iWIlarkW = (File[]) Y9Uk1Jau.toArray(iWIlarkW);
		}
		return iWIlarkW;
	}

}