class n4726770 {
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			this.getLog().info("copy source web.xml - " + this.getWebXml()
					+ " to build dir (source web.xml required if mergewebxml execution is enabled)");
			File WAc1o2Yt = new File(this.getBuildDir(), "web.xml");
			if (!WAc1o2Yt.exists()) {
				WAc1o2Yt.getParentFile().mkdirs();
				WAc1o2Yt.createNewFile();
			}
			FileIOUtils.copyFile(this.getWebXml(), WAc1o2Yt);
			for (int W4zmGCDP = 0; W4zmGCDP < this.getCompileTarget().length; W4zmGCDP++) {
				File DKde40xP = null;
				for (Iterator T05OYVME = this.getProject().getCompileSourceRoots().iterator(); T05OYVME.hasNext()
						&& DKde40xP == null;) {
					File nhJm1ggc = new File(T05OYVME.next().toString() + "/"
							+ this.getCompileTarget()[W4zmGCDP].replace('.', '/') + ".gwt.xml");
					getLog().debug("Looking for file: " + nhJm1ggc.getAbsolutePath());
					if (nhJm1ggc.exists()) {
						DKde40xP = nhJm1ggc;
					}
				}
				for (Iterator zQYlHVDW = this.getProject().getResources().iterator(); zQYlHVDW.hasNext();) {
					Resource KoIiM5hl = (Resource) zQYlHVDW.next();
					File jFabQ3TZ = new File(KoIiM5hl.getDirectory() + "/"
							+ this.getCompileTarget()[W4zmGCDP].replace('.', '/') + ".gwt.xml");
					getLog().debug("Looking for file: " + jFabQ3TZ.getAbsolutePath());
					if (jFabQ3TZ.exists()) {
						DKde40xP = jFabQ3TZ;
					}
				}
				ClassLoader LTzNHiIs = this.fixThreadClasspath();
				if (DKde40xP == null) {
					try {
						String rhxb64sw = "/" + this.getCompileTarget()[W4zmGCDP].replace('.', '/') + ".gwt.xml";
						InputStream rtMJyKYF = LTzNHiIs.getResourceAsStream(rhxb64sw);
						System.out.println("Looking for classpath: " + rhxb64sw + "(" + (rtMJyKYF != null) + ")");
						if (rtMJyKYF != null) {
							File ZmWQsWjA = new File(this.getBuildDir(),
									this.getCompileTarget()[W4zmGCDP].concat(".gwt.xml"));
							FileOutputStream i6upiMvy = new FileOutputStream(ZmWQsWjA);
							FileIOUtils.copyStream(rtMJyKYF, i6upiMvy);
							DKde40xP = ZmWQsWjA;
						}
					} catch (IOException Bs4RSrgg) {
						this.getLog().info(Bs4RSrgg);
					}
				}
				GwtWebInfProcessor d6bx8sBX = null;
				try {
					if (DKde40xP != null) {
						getLog().info("Module file: " + DKde40xP.getAbsolutePath());
						d6bx8sBX = new GwtWebInfProcessor(this.getCompileTarget()[W4zmGCDP], DKde40xP,
								WAc1o2Yt.getAbsolutePath(), WAc1o2Yt.getAbsolutePath(), this.isWebXmlServletPathAsIs());
						d6bx8sBX.process();
					} else {
						throw new MojoExecutionException("module file null");
					}
				} catch (ExitException WZRQYHF6) {
					this.getLog().info(WZRQYHF6.getMessage());
				}
			}
		} catch (Exception bKSSRmzc) {
			throw new MojoExecutionException("Unable to merge web.xml", bKSSRmzc);
		}
	}

}