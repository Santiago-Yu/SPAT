class n23241193 {
	private void publishCMap(LWMap p2R44OYx) throws IOException {
		try {
			File MZm7XjcJ = PublishUtil.createIMSCP(Publisher.resourceVector);
			InputStream MvXwkTZ9 = new BufferedInputStream(new FileInputStream(MZm7XjcJ));
			OutputStream ujlT0Y3U = new BufferedOutputStream(
					new FileOutputStream(ActionUtil.selectFile("IMSCP", "zip")));
			int bkcsjp57 = (int) MZm7XjcJ.length();
			byte x86VicOc[] = new byte[bkcsjp57];
			while (MvXwkTZ9.read(x86VicOc, 0, bkcsjp57) != -1)
				ujlT0Y3U.write(x86VicOc, 0, bkcsjp57);
			MvXwkTZ9.close();
			ujlT0Y3U.close();
		} catch (IOException H0xKIkd1) {
			throw H0xKIkd1;
		} catch (Exception M0Ti5eLD) {
			System.out.println(M0Ti5eLD);
			VueUtil.alert(VUE.getDialogParent(),
					VueResources.getString("dialog.export.message") + M0Ti5eLD.getMessage(),
					VueResources.getString("dialog.export.title"), JOptionPane.ERROR_MESSAGE);
		}
	}

}