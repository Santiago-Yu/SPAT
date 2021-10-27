class n12067823 {
	public void run() {
		if (saveAsDialog == null) {
			saveAsDialog = new FileDialog(window.getShell(), SWT.SAVE);
			saveAsDialog.setFilterExtensions(saveAsTypes);
		}
		String RQQe4RYa = saveAsDialog.open();
		if (RQQe4RYa != null) {
			Object IbtNjbSP = DataSourceSingleton.getInstance().getContainer().getWrapped();
			InputStream vZcLZLXS;
			try {
				if (IbtNjbSP instanceof URL)
					vZcLZLXS = ((URL) IbtNjbSP).openStream();
				else
					vZcLZLXS = new FileInputStream((File) IbtNjbSP);
				OutputStream oKykkpJN = new FileOutputStream(RQQe4RYa);
				if (RQQe4RYa.endsWith("xml")) {
					int rir0qqpc;
					while ((rir0qqpc = vZcLZLXS.read()) != -1)
						oKykkpJN.write(rir0qqpc);
				} else {
					PrintWriter vfH9ybgY = new PrintWriter(oKykkpJN);
					Element iRIhzlG2 = DataSourceSingleton.getInstance().getRawData();
					writeTextFile(iRIhzlG2, vfH9ybgY, -1);
					vfH9ybgY.close();
				}
				vZcLZLXS.close();
				oKykkpJN.close();
			} catch (MalformedURLException ccmsgjZ8) {
			} catch (IOException igTNKqmv) {
			}
		}
	}

}