class n3054600 {
	private void generateArchetype(final IProject TY6J77jF, final IDataModel TJgkUmsI, final IProgressMonitor HjAgjctC,
			final boolean s3clN4tZ) throws CoreException, InterruptedException, IOException {
		if (getArchetypeArtifactId(TJgkUmsI) != null) {
			final Properties DbX2Q3ev = new Properties();
			DbX2Q3ev.put("archetypeArtifactId", getArchetypeArtifactId(TJgkUmsI));
			DbX2Q3ev.put("archetypeGroupId", getArchetypeGroupId(TJgkUmsI));
			DbX2Q3ev.put("archetypeVersion", getArchetypeVersion(TJgkUmsI));
			String e6uMilIE = (String) TJgkUmsI.getProperty(IMavenFacetInstallDataModelProperties.PROJECT_ARTIFACT_ID);
			if (e6uMilIE == null || e6uMilIE.trim().length() == 0) {
				e6uMilIE = TY6J77jF.getName();
			}
			DbX2Q3ev.put("artifactId", e6uMilIE);
			String kRAXDsEZ = (String) TJgkUmsI.getProperty(IMavenFacetInstallDataModelProperties.PROJECT_GROUP_ID);
			if (kRAXDsEZ == null || kRAXDsEZ.trim().length() == 0) {
				kRAXDsEZ = TY6J77jF.getName();
			}
			DbX2Q3ev.put("groupId", kRAXDsEZ);
			DbX2Q3ev.put("version", TJgkUmsI.getProperty(IMavenFacetInstallDataModelProperties.PROJECT_VERSION));
			final StringBuffer DVE2JEdn = new StringBuffer(System.getProperty("user.home")).append(File.separator);
			DVE2JEdn.append(".m2").append(File.separator).append("repository");
			final String VYG1SYr3 = DVE2JEdn.toString();
			Logger.getLog().debug("Local Maven2 repository :: " + VYG1SYr3);
			DbX2Q3ev.put("localRepository", VYG1SYr3);
			if (!s3clN4tZ) {
				final String O39rNlWA = getRepositories();
				DbX2Q3ev.put("remoteRepositories", O39rNlWA);
			}
			final ILaunchManager YGmm94JS = DebugPlugin.getDefault().getLaunchManager();
			final ILaunchConfigurationType XAT2b68z = YGmm94JS.getLaunchConfigurationType(LAUNCH_CONFIGURATION_TYPE_ID);
			final ILaunchConfigurationWorkingCopy lVqYK0aa = XAT2b68z.newInstance(null,
					"Creating project using Apache Maven archetype");
			File geiXqWbs = getDefaultArchetypePomDirectory();
			try {
				String wvtzPWxb = getPomFile(kRAXDsEZ, e6uMilIE);
				ByteArrayInputStream L4pjkcpg = new ByteArrayInputStream(wvtzPWxb.getBytes());
				File yUsW3ZrV = new File(geiXqWbs, "pom.xml");
				OutputStream qrad9kgY = null;
				try {
					qrad9kgY = new FileOutputStream(yUsW3ZrV);
					IOUtils.copy(L4pjkcpg, qrad9kgY);
				} finally {
					try {
						if (qrad9kgY != null) {
							qrad9kgY.close();
						}
						if (L4pjkcpg != null) {
							L4pjkcpg.close();
						}
					} catch (IOException noObAjse) {
					}
				}
				if (SiteManager.isHttpProxyEnable()) {
					addProxySettings(DbX2Q3ev);
				}
				lVqYK0aa.setAttribute(ATTR_POM_DIR, geiXqWbs.getAbsolutePath());
				lVqYK0aa.setAttribute(ATTR_PROPERTIES, convertPropertiesToList(DbX2Q3ev));
				String lMqolVkr = "archetype:create";
				if (s3clN4tZ) {
					lMqolVkr = new StringBuffer(lMqolVkr).append(" -o").toString();
				}
				lMqolVkr = updateGoal(lMqolVkr);
				lVqYK0aa.setAttribute(ATTR_GOALS, lMqolVkr);
				final long UtPzmTzb = org.maven.ide.eclipse.ext.Maven2Plugin.getTimeout();
				TimeoutLaunchConfiguration.launchWithTimeout(HjAgjctC, lVqYK0aa, TY6J77jF, UtPzmTzb);
				HjAgjctC.setTaskName("Moving to workspace");
				FileUtils.copyDirectoryStructure(new File(geiXqWbs, TY6J77jF.getName()),
						ArchetypePOMHelper.getProjectDirectory(TY6J77jF));
				HjAgjctC.worked(1);
				performMavenInstall(HjAgjctC, TY6J77jF, s3clN4tZ);
				TY6J77jF.refreshLocal(2, HjAgjctC);
			} catch (final IOException tw4543NK) {
				Logger.log(Logger.ERROR,
						"I/O exception. One probably solution is absence "
								+ "of mvn2 archetypes or not the correct version, "
								+ "in your local repository. Please, check existence " + "of this archetype.");
				Logger.getLog().error("I/O Exception arised creating mvn2 archetype", tw4543NK);
				throw tw4543NK;
			} finally {
				FileUtils.deleteDirectory(geiXqWbs);
				Logger.log(Logger.INFO, "Invoked removing of archetype POM directory");
			}
		}
		HjAgjctC.worked(1);
	}

}