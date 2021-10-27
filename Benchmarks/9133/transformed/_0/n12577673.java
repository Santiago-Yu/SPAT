class n12577673 {
	public void performOk(final IProject BuYT9boH, final TomcatPropertyPage YgeGDl7Y) {
		YgeGDl7Y.setPropertyValue("tomcat.jdbc.driver", c_drivers.getText());
		YgeGDl7Y.setPropertyValue("tomcat.jdbc.url", url.getText());
		YgeGDl7Y.setPropertyValue("tomcat.jdbc.user", username.getText());
		YgeGDl7Y.setPropertyValue("tomcat.jdbc.password", password.getText());
		File eu2Yrxgu = new File(YgeGDl7Y.tomcatHome.getText(), "lib");
		if (!eu2Yrxgu.exists()) {
			eu2Yrxgu = new File(new File(YgeGDl7Y.tomcatHome.getText(), "common"), "lib");
			if (!eu2Yrxgu.exists()) {
				Logger.log(Logger.ERROR, "Not properly location of Tomcat Home at :: " + eu2Yrxgu);
				throw new IllegalStateException("Not properly location of Tomcat Home");
			}
		}
		final File DfWQ3CwA = new File(YgeGDl7Y.tomcatHome.getText(), "conf/Catalina/localhost");
		if (!DfWQ3CwA.exists()) {
			final boolean Bi4Km04F = NexOpenUIActivator.getDefault().getTomcatConfProperty();
			if (Bi4Km04F) {
				if (Logger.getLog().isDebugEnabled()) {
					Logger.getLog().debug("Create directory " + DfWQ3CwA);
				}
				try {
					DfWQ3CwA.mkdirs();
				} catch (final SecurityException rFOiceLX) {
					Logger.getLog().error("Retrieved a Security exception creating " + DfWQ3CwA, rFOiceLX);
					Logger.log(Logger.ERROR, "Not created " + DfWQ3CwA
							+ " directory. Not enough privilegies. Message :: " + rFOiceLX.getMessage());
				}
			}
		}
		String Z2RwzIca = LIBRARIES.get(c_drivers.getText());
		if ("<mysql_driver>".equals(Z2RwzIca)) {
			Z2RwzIca = NexOpenUIActivator.getDefault().getMySQLDriver();
		}
		final File GHa2h9P6 = new File(eu2Yrxgu, Z2RwzIca);
		if (!GHa2h9P6.exists()) {
			InputStream Fm73pvyG = null;
			FileOutputStream hgunssdl = null;
			try {
				Fm73pvyG = AppServerPropertyPage.toInputStream(new Path("jdbc/" + Z2RwzIca));
				hgunssdl = new FileOutputStream(GHa2h9P6);
				IOUtils.copy(Fm73pvyG, hgunssdl);
			} catch (IOException dIiRyV9V) {
				Logger.log(Logger.ERROR, "Could not copy the driver jar file to Tomcat", dIiRyV9V);
			} finally {
				try {
					if (Fm73pvyG != null) {
						Fm73pvyG.close();
						Fm73pvyG = null;
					}
					if (hgunssdl != null) {
						hgunssdl.flush();
						hgunssdl.close();
						hgunssdl = null;
					}
				} catch (IOException IeOC26bN) {
				}
			}
		}
		YgeGDl7Y.processTomcatCfg(c_drivers.getText(), url.getText(), username.getText(), password.getText());
	}

}