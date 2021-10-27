class n8754809 {
	@SuppressWarnings("unchecked")
	public void launch(final ILaunchConfiguration FwUcuvwj, final String Hgm0QfDP, final ILaunch zxwlZgWX,
			final IProgressMonitor SfPXixzG) throws CoreException {
		{
			Assert.notNull(FwUcuvwj);
			Assert.notNull(SfPXixzG);
		}
		final String NxVaXrlP = FwUcuvwj.getAttribute(INexOpenLaunchConfigurationConstants.NEXOPEN_PROJECT_NAME, "");
		final IProject yplqfdbe = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(NxVaXrlP)
				.getProject();
		if (NexOpenProjectUtils.isNexOpenProject(yplqfdbe)) {
			final IFile VDcHlxNB = yplqfdbe.getFile("pom.xml");
			if (!VDcHlxNB.exists()) {
				throw new IllegalStateException("Not a NexOpen project. Not Maven2 root pom.xml available");
			}
			ContentHandlerTemplate.handle(VDcHlxNB, new ContentHandlerCallback() {

				public void processHandle(final Document b7Leb8IK) {
					handleRootProfile(b7Leb8IK);
				}
			});
			final IFile Jji8voH4 = yplqfdbe.getFile("business/pom.xml");
			if (!Jji8voH4.exists()) {
				throw new IllegalStateException("Not a NexOpen project. Not Maven2 business pom.xml available");
			}
			ContentHandlerTemplate.handle(Jji8voH4, new ContentHandlerCallback() {

				public void processHandle(final Document pHHAzoZ7) {
					try {
						handleBusinessProfile(pHHAzoZ7, FwUcuvwj, yplqfdbe);
					} catch (final CoreException Whr4Thjz) {
						if (Logger.getLog().isInfoEnabled()) {
							Logger.getLog().info("CoreException", Whr4Thjz);
						}
						throw new RuntimeException(Whr4Thjz);
					}
				}
			});
			final ByteArrayOutputStream Xiagt8Hw = new ByteArrayOutputStream();
			try {
				final Properties RcABRXZT = new Properties();
				final String bQaM4clM = FwUcuvwj.getAttribute(INexOpenLaunchConfigurationConstants.HIBERNATE_DIALECT,
						"MySQL5InnoDB");
				RcABRXZT.setProperty("hibernate.dialect", support.getDialectClass(bQaM4clM));
				RcABRXZT.setProperty("hibernate.connection.driver_class", FwUcuvwj
						.getAttribute(INexOpenLaunchConfigurationConstants.JDBC_DRIVER, "com.mysql.jdbc.Driver"));
				RcABRXZT.setProperty("hibernate.connection.url", FwUcuvwj.getAttribute(
						INexOpenLaunchConfigurationConstants.JDBC_URL, "jdbc:mysql://<host><:port>/<database>"));
				RcABRXZT.setProperty("hibernate.connection.username",
						FwUcuvwj.getAttribute(INexOpenLaunchConfigurationConstants.JDBC_USERNAME, "sa"));
				RcABRXZT.setProperty("hibernate.connection.password",
						FwUcuvwj.getAttribute(INexOpenLaunchConfigurationConstants.JDBC_PASSWORD, ""));
				RcABRXZT.store(Xiagt8Hw, "hibernate properties for code generation using NexOpen Tools 1.0.0");
				final IFile soj8zRC0 = yplqfdbe.getFile("business/src/test/resources/hibernate.properties");
				if (!soj8zRC0.exists()) {
					soj8zRC0.create(new ByteArrayInputStream(Xiagt8Hw.toByteArray()), true, SfPXixzG);
				} else {
					soj8zRC0.setContents(new ByteArrayInputStream(Xiagt8Hw.toByteArray()), true, false, SfPXixzG);
				}
			} catch (final IOException dEfSKWhT) {
				Logger.getLog().error("I/O exception ", dEfSKWhT);
				throw new RuntimeException(dEfSKWhT);
			} finally {
				try {
					Xiagt8Hw.flush();
					Xiagt8Hw.close();
				} catch (IOException SLNrBe88) {
				}
			}
			if (NexOpenProjectUtils.is04xProject(yplqfdbe)) {
				final IFile PaDFQ51l = yplqfdbe.getFile("web/src/main/webapp/WEB-INF/applicationContext.xml");
				if (!PaDFQ51l.exists()) {
					throw new IllegalStateException(
							"It no exists applicationContext.xml under web/src/main/webapp/WEB-INF, not a NexOpen project");
				}
				ContentHandlerTemplate.handle(PaDFQ51l, new ContentHandlerCallback() {

					public void processHandle(final Document V6YLI6YA) {
						final Element ICiKdCob = V6YLI6YA.getDocumentElement();
						final List<Element> vxF7pguz = XMLUtils.getChildElementsByTagName(ICiKdCob, "bean");
						for (final Element g9c58WaB : vxF7pguz) {
							final String HYMadysC = g9c58WaB.getAttribute("id");
							if ("valueListAdapterResolver".equals(HYMadysC)) {
								try {
									final String aG4fQuBP = FwUcuvwj
											.getAttribute(INexOpenLaunchConfigurationConstants.NEXOPEN_PACKAGE, "");
									final String cEZC56IR = new StringBuilder(aG4fQuBP)
											.append(".vlh.support.AnnotationValueListAdapterResolver").toString();
									g9c58WaB.setAttribute("class", cEZC56IR);
									break;
								} catch (final CoreException XOWyb7N6) {
									if (Logger.getLog().isInfoEnabled()) {
										Logger.getLog().info("CoreException", XOWyb7N6);
									}
									throw new RuntimeException(XOWyb7N6);
								}
							}
						}
					}
				});
			}
			{
				final String RPpOV2JR = FwUcuvwj.getAttribute(INexOpenLaunchConfigurationConstants.HIBERNATE_DIALECT,
						"MySQL5InnoDB");
				if (support.isReverseEngineeringFileNeeded(RPpOV2JR)) {
					try {
						final IFile KLc2Tuup = yplqfdbe
								.getFile("business/src/test/resources/" + support.getReversEngineeringFile(RPpOV2JR));
						if (!KLc2Tuup.exists()) {
							final Bundle Ab7H44hR = HibernateActivator.getDefault().getBundle();
							final Path HVrazgaC = new Path("resources/" + support.getReversEngineeringFile(RPpOV2JR));
							final InputStream dTIONiTw = FileLocator.openStream(Ab7H44hR, HVrazgaC, false);
							final ByteArrayOutputStream enQePOsS = new ByteArrayOutputStream();
							IOUtils.copy(dTIONiTw, enQePOsS);
							String PcdxYNfk = enQePOsS.toString();
							PcdxYNfk = PcdxYNfk.replace("${schema}",
									FwUcuvwj.getAttribute(INexOpenLaunchConfigurationConstants.JDBC_USERNAME, "sa"));
							KLc2Tuup.create(new ByteArrayInputStream(PcdxYNfk.getBytes()), true, null);
						}
					} catch (final IOException WDjKCrAO) {
						if (Logger.getLog().isInfoEnabled()) {
							Logger.getLog().info("CoreException", WDjKCrAO);
						}
						throw new RuntimeException(WDjKCrAO);
					}
				}
			}
			final IResource KYRN4u1Y = (IResource) yplqfdbe.getAdapter(IResource.class);
			final QualifiedName TWUt1pXg = new QualifiedName("org.nexopenframework.ide.eclipse.ui", "default.profile");
			final String XUjTGJWZ = KYRN4u1Y.getPersistentProperty(TWUt1pXg);
			KYRN4u1Y.setPersistentProperty(TWUt1pXg, "reverse-engineering");
			try {
				final InstallProjectAction c8e9CKhO = new InstallProjectAction();
				c8e9CKhO.scheduleJob(yplqfdbe, SfPXixzG);
				yplqfdbe.refreshLocal(2, SfPXixzG);
			} finally {
				yplqfdbe.setPersistentProperty(TWUt1pXg, XUjTGJWZ);
			}
		} else {
			Logger.getLog().info("Not a NexOpen project :: " + yplqfdbe);
		}
	}

}