class n18318816 {
	public static void invokeMvnArtifact(final IProject Dq8FR6H7, final IModuleExtension Tvui8o4f,
			final String gcI4OWCt) throws CoreException, InterruptedException, IOException {
		final Properties EBMJGSgn = new Properties();
		EBMJGSgn.put("archetypeGroupId", "org.nexopenframework.plugins");
		EBMJGSgn.put("archetypeArtifactId", "openfrwk-archetype-webmodule");
		final String QXaiDHDu = org.maven.ide.eclipse.ext.Maven2Plugin.getArchetypeVersion();
		EBMJGSgn.put("archetypeVersion", QXaiDHDu);
		EBMJGSgn.put("artifactId", Tvui8o4f.getArtifact());
		EBMJGSgn.put("groupId", Tvui8o4f.getGroup());
		EBMJGSgn.put("version", Tvui8o4f.getVersion());
		final ILaunchManager HjBT7Cfn = DebugPlugin.getDefault().getLaunchManager();
		final ILaunchConfigurationType iBH7vDVR = HjBT7Cfn.getLaunchConfigurationType(LAUNCH_CONFIGURATION_TYPE_ID);
		final ILaunchConfigurationWorkingCopy qTvlqLsp = iBH7vDVR.newInstance(null,
				"Creating WEB module using Apache Maven archetype");
		File ku1Cpny6 = getDefaultArchetypePomDirectory();
		try {
			final String nPeiqLJL = getPomFile(Tvui8o4f.getGroup(), Tvui8o4f.getArtifact());
			final ByteArrayInputStream s67odspm = new ByteArrayInputStream(nPeiqLJL.getBytes());
			final File AQMNRMRt = new File(ku1Cpny6, "pom.xml");
			OutputStream I5ss4xj8 = null;
			try {
				I5ss4xj8 = new FileOutputStream(AQMNRMRt);
				IOUtils.copy(s67odspm, I5ss4xj8);
			} finally {
				try {
					if (I5ss4xj8 != null) {
						I5ss4xj8.close();
					}
					if (s67odspm != null) {
						s67odspm.close();
					}
				} catch (final IOException lRyCMePQ) {
				}
			}
			String VQrvS4Rz = "archetype:create";
			boolean VIM9m5eC = false;
			try {
				final Class SXSpZpfv = Thread.currentThread().getContextClassLoader()
						.loadClass("org.maven.ide.eclipse.Maven2Plugin");
				final Maven2Plugin JFrZzJNk = (Maven2Plugin) SXSpZpfv.getMethod("getDefault", new Class[0]).invoke(null,
						new Object[0]);
				VIM9m5eC = JFrZzJNk.getPreferenceStore().getBoolean("eclipse.m2.offline");
			} catch (final ClassNotFoundException aj9RvkTI) {
				Logger.logException("No class [org.maven.ide.eclipse.ext.Maven2Plugin] in classpath", aj9RvkTI);
			} catch (final NoSuchMethodException Ep52fosu) {
				Logger.logException("No method getDefault", Ep52fosu);
			} catch (final Throwable KjyY1jx7) {
				Logger.logException(KjyY1jx7);
			}
			if (VIM9m5eC) {
				VQrvS4Rz = new StringBuffer(VQrvS4Rz).append(" -o").toString();
			}
			if (!VIM9m5eC) {
				final IPreferenceStore ENttKteM = Maven2Plugin.getDefault().getPreferenceStore();
				final String vMDChjXd = ENttKteM.getString(Maven2PreferenceConstants.P_M2_REPOSITORIES);
				final String[] Lur8Skha = vMDChjXd.split(org.maven.ide.eclipse.ext.Maven2Plugin.REPO_SEPARATOR);
				final StringBuffer U6SzQiEH = new StringBuffer();
				for (int FcTu5biS = 0; FcTu5biS < Lur8Skha.length; FcTu5biS++) {
					U6SzQiEH.append(Lur8Skha[FcTu5biS]);
					if (FcTu5biS != Lur8Skha.length - 1) {
						U6SzQiEH.append(",");
					}
				}
				EBMJGSgn.put("remoteRepositories", U6SzQiEH.toString());
			}
			qTvlqLsp.setAttribute(ATTR_GOALS, VQrvS4Rz);
			qTvlqLsp.setAttribute(ATTR_POM_DIR, ku1Cpny6.getAbsolutePath());
			qTvlqLsp.setAttribute(ATTR_PROPERTIES, convertPropertiesToList(EBMJGSgn));
			final long hEVBCTem = org.maven.ide.eclipse.ext.Maven2Plugin.getTimeout();
			TimeoutLaunchConfiguration.launchWithTimeout(new NullProgressMonitor(), qTvlqLsp, Dq8FR6H7, hEVBCTem);
			FileUtils.copyDirectoryStructure(new File(ku1Cpny6, Dq8FR6H7.getName()), new File(gcI4OWCt));
			FileUtils.deleteDirectory(new File(gcI4OWCt + "/src"));
			FileUtils.forceDelete(new File(gcI4OWCt, "pom.xml"));
			Dq8FR6H7.refreshLocal(IResource.DEPTH_INFINITE, null);
		} finally {
			FileUtils.deleteDirectory(ku1Cpny6);
			Logger.log(Logger.INFO, "Invoked removing of archetype POM directory");
		}
	}

}