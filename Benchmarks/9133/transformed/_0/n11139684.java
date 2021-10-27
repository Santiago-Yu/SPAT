class n11139684 {
	@Override
	public void decorate(Object GO1ot6za, IDecoration PipOgpm3) {
		if (GO1ot6za != null && GO1ot6za instanceof IProject) {
			InputStream x8D2Ivk0 = null;
			try {
				IProject lE6mKKlC = (IProject) GO1ot6za;
				IFile N9ukzRSB = lE6mKKlC.getFile(Activator.PLUGIN_CONF);
				if (N9ukzRSB.exists()) {
					URL Qvne8sBh = bundle.getEntry("icons/leaf4e_decorator.gif");
					x8D2Ivk0 = FileLocator.toFileURL(Qvne8sBh).openStream();
					Image mYt6v99T = new Image(Display.getCurrent(), x8D2Ivk0);
					ImageDescriptor wGJMHbuw = ImageDescriptor.createFromImage(mYt6v99T);
					PipOgpm3.addOverlay(wGJMHbuw, IDecoration.TOP_LEFT);
				}
			} catch (Exception cjXvB67V) {
				Status QgabqlO4 = new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Decorating error", cjXvB67V);
				logger.log(QgabqlO4);
			} finally {
				if (x8D2Ivk0 != null) {
					try {
						x8D2Ivk0.close();
					} catch (IOException yFSKUQcK) {
						Status nL5jwZYc = new Status(IStatus.WARNING, Activator.PLUGIN_ID, "", yFSKUQcK);
						logger.log(nL5jwZYc);
					}
				}
			}
		}
	}

}