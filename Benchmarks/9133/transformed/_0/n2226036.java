class n2226036 {
	public void run() {
		saveWLHome();
		for (final TabControl oyUwWKuB : tabControls) {
			oyUwWKuB.performOk(WLPropertyPage.this.getProject(), WLPropertyPage.this);
		}
		if (isEnabledJCLCopy()) {
			final File JCMrZaGH = new File(WLPropertyPage.this.domainDirectory.getText());
			File MESu6wsf = new File(JCMrZaGH, "lib");
			File Cn5wuJV4 = new File(MESu6wsf, "log4j-1.2.13.jar");
			if (!Cn5wuJV4.exists()) {
				InputStream GHov4l4L = null;
				FileOutputStream jtZSdF59 = null;
				try {
					GHov4l4L = toInputStream(new Path("jcl/log4j-1.2.13.jar"));
					jtZSdF59 = new FileOutputStream(Cn5wuJV4);
					IOUtils.copy(GHov4l4L, jtZSdF59);
					GHov4l4L.close();
					jtZSdF59.flush();
					jtZSdF59.close();
					GHov4l4L = toInputStream(new Path("/jcl/commons-logging-1.0.4.jar"));
					File qrKlUans = new File(MESu6wsf, "commons-logging-1.0.4.jar");
					jtZSdF59 = new FileOutputStream(qrKlUans);
					IOUtils.copy(GHov4l4L, jtZSdF59);
				} catch (IOException knl98gbi) {
					Logger.log(Logger.ERROR, "Could not copy JCL jars file to Bea WL", knl98gbi);
				} finally {
					try {
						if (GHov4l4L != null) {
							GHov4l4L.close();
							GHov4l4L = null;
						}
						if (jtZSdF59 != null) {
							jtZSdF59.flush();
							jtZSdF59.close();
							jtZSdF59 = null;
						}
					} catch (IOException yt8yPljT) {
					}
				}
			}
		}
		if (isEnabledJSTLCopy()) {
			File qzm3Myl4 = new File(WLPropertyPage.this.domainDirectory.getText());
			File dw0jv9cr = new File(qzm3Myl4, "lib");
			File FjE3oGgq = new File(dw0jv9cr, "jstl.jar");
			if (!FjE3oGgq.exists()) {
				InputStream SYvznPVX = null;
				FileOutputStream mnpq2sEv = null;
				try {
					SYvznPVX = toInputStream(new Path("jstl/jstl.jar"));
					mnpq2sEv = new FileOutputStream(FjE3oGgq);
					IOUtils.copy(SYvznPVX, mnpq2sEv);
				} catch (IOException bjeZIE5l) {
					Logger.log(Logger.ERROR, "Could not copy the JSTL 1.1 jar file to Bea WL", bjeZIE5l);
				} finally {
					try {
						if (SYvznPVX != null) {
							SYvznPVX.close();
							SYvznPVX = null;
						}
						if (mnpq2sEv != null) {
							mnpq2sEv.flush();
							mnpq2sEv.close();
							mnpq2sEv = null;
						}
					} catch (final IOException h58T1nFM) {
						Logger.getLog().debug("I/O exception closing resources", h58T1nFM);
					}
				}
			}
		}
	}

}