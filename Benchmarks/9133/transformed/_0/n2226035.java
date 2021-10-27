class n2226035 {
	@Override
	public boolean performOk() {
		this.setPropertyValue("bea.home", this.beaHome.getText());
		this.setPropertyValue("bea.domain", this.domainDirectory.getText());
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				saveWLHome();
				for (final TabControl rAGuwQ4P : tabControls) {
					rAGuwQ4P.performOk(WLPropertyPage.this.getProject(), WLPropertyPage.this);
				}
				if (isEnabledJCLCopy()) {
					final File wWhsamOf = new File(WLPropertyPage.this.domainDirectory.getText());
					File FHuPlOqv = new File(wWhsamOf, "lib");
					File pDBgoXzv = new File(FHuPlOqv, "log4j-1.2.13.jar");
					if (!pDBgoXzv.exists()) {
						InputStream sxEyYfCi = null;
						FileOutputStream ZGExiBpV = null;
						try {
							sxEyYfCi = toInputStream(new Path("jcl/log4j-1.2.13.jar"));
							ZGExiBpV = new FileOutputStream(pDBgoXzv);
							IOUtils.copy(sxEyYfCi, ZGExiBpV);
							sxEyYfCi.close();
							ZGExiBpV.flush();
							ZGExiBpV.close();
							sxEyYfCi = toInputStream(new Path("/jcl/commons-logging-1.0.4.jar"));
							File z9KpCAcD = new File(FHuPlOqv, "commons-logging-1.0.4.jar");
							ZGExiBpV = new FileOutputStream(z9KpCAcD);
							IOUtils.copy(sxEyYfCi, ZGExiBpV);
						} catch (IOException AbpfAh1e) {
							Logger.log(Logger.ERROR, "Could not copy JCL jars file to Bea WL", AbpfAh1e);
						} finally {
							try {
								if (sxEyYfCi != null) {
									sxEyYfCi.close();
									sxEyYfCi = null;
								}
								if (ZGExiBpV != null) {
									ZGExiBpV.flush();
									ZGExiBpV.close();
									ZGExiBpV = null;
								}
							} catch (IOException HXDYdWD4) {
							}
						}
					}
				}
				if (isEnabledJSTLCopy()) {
					File Or1WkxIk = new File(WLPropertyPage.this.domainDirectory.getText());
					File zWdgd6iE = new File(Or1WkxIk, "lib");
					File v3eOdFeL = new File(zWdgd6iE, "jstl.jar");
					if (!v3eOdFeL.exists()) {
						InputStream xmpv8V3e = null;
						FileOutputStream epUbo8Wn = null;
						try {
							xmpv8V3e = toInputStream(new Path("jstl/jstl.jar"));
							epUbo8Wn = new FileOutputStream(v3eOdFeL);
							IOUtils.copy(xmpv8V3e, epUbo8Wn);
						} catch (IOException t6S0SkvT) {
							Logger.log(Logger.ERROR, "Could not copy the JSTL 1.1 jar file to Bea WL", t6S0SkvT);
						} finally {
							try {
								if (xmpv8V3e != null) {
									xmpv8V3e.close();
									xmpv8V3e = null;
								}
								if (epUbo8Wn != null) {
									epUbo8Wn.flush();
									epUbo8Wn.close();
									epUbo8Wn = null;
								}
							} catch (final IOException U23l4OWk) {
								Logger.getLog().debug("I/O exception closing resources", U23l4OWk);
							}
						}
					}
				}
			}
		});
		return super.performOk();
	}

}