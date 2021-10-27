class n12490144 {
	private void createJCoPluginProject(IProgressMonitor VQK88aqe, String vvpFV27h, String uSQfUR1G)
			throws CoreException, IOException {
		VQK88aqe.subTask(MessageFormat.format(Messages.ProjectGenerator_CreatePluginTaskDescription, uSQfUR1G));
		final Map<String, byte[]> Z3HkCDfG = readArchiveFile(vvpFV27h);
		VQK88aqe.worked(10);
		IProject DBghtbhM = workspaceRoot.getProject(uSQfUR1G);
		if (DBghtbhM.exists()) {
			DBghtbhM.delete(true, true, new SubProgressMonitor(VQK88aqe, 5));
		} else {
			VQK88aqe.worked(5);
		}
		DBghtbhM.create(new SubProgressMonitor(VQK88aqe, 5));
		DBghtbhM.open(new SubProgressMonitor(VQK88aqe, 5));
		IProjectDescription ilmROcY0 = DBghtbhM.getDescription();
		ilmROcY0.setNatureIds(new String[] { JavaCore.NATURE_ID, PLUGIN_NATURE_ID });
		DBghtbhM.setDescription(ilmROcY0, new SubProgressMonitor(VQK88aqe, 5));
		IJavaProject V9K3Jp64 = JavaCore.create(DBghtbhM);
		IFolder RTrT2j49 = DBghtbhM.getFolder("bin");
		IPath hY3X30QR = RTrT2j49.getFullPath();
		V9K3Jp64.setOutputLocation(hY3X30QR, new SubProgressMonitor(VQK88aqe, 5));
		DBghtbhM.getFolder("jni").create(true, true, new SubProgressMonitor(VQK88aqe, 5));
		DBghtbhM.getFile("sapjco3.jar").create(new ByteArrayInputStream(Z3HkCDfG.get("sapjco3.jar")), true,
				new SubProgressMonitor(VQK88aqe, 10));
		IFolder Qlak2KCq = DBghtbhM.getFolder("META-INF");
		Qlak2KCq.create(true, true, new SubProgressMonitor(VQK88aqe, 5));
		StringBuilder CsVfJeLS = new StringBuilder();
		CsVfJeLS.append("Manifest-Version: 1.0\n");
		CsVfJeLS.append("Bundle-ManifestVersion: 2\n");
		CsVfJeLS.append("Bundle-Name: SAP Java Connector v3\n");
		CsVfJeLS.append(MessageFormat.format("Bundle-SymbolicName: {0}\n", uSQfUR1G));
		CsVfJeLS.append("Bundle-Version: 7.11.0\n");
		CsVfJeLS.append("Bundle-ClassPath: bin/,\n");
		CsVfJeLS.append(" sapjco3.jar,\n");
		CsVfJeLS.append(" jni/\n");
		CsVfJeLS.append("Bundle-Vendor: SAP AG, Walldorf (packaged using RCER)\n");
		CsVfJeLS.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\n");
		CsVfJeLS.append("Export-Package: com.sap.conn.jco,\n");
		CsVfJeLS.append(" com.sap.conn.jco.ext,\n");
		CsVfJeLS.append(" com.sap.conn.jco.monitor,\n");
		CsVfJeLS.append(" com.sap.conn.jco.rt,\n");
		CsVfJeLS.append(" com.sap.conn.jco.server\n");
		CsVfJeLS.append("Bundle-ActivationPolicy: lazy\n");
		writeTextFile(VQK88aqe, CsVfJeLS, Qlak2KCq.getFile("MANIFEST.MF"));
		final IPath B4iKuzmi = new Path(MessageFormat.format("/{0}/sapjco3.jar", uSQfUR1G));
		IClasspathEntry bTwqhlPs = JavaCore.newLibraryEntry(B4iKuzmi, Path.EMPTY, Path.EMPTY, true);
		final IPath ydVXJ4CI = new Path(MessageFormat.format("/{0}/jni", uSQfUR1G));
		IClasspathEntry f8EJDpgT = JavaCore.newLibraryEntry(ydVXJ4CI, Path.EMPTY, Path.EMPTY, true);
		V9K3Jp64.setRawClasspath(new IClasspathEntry[] { bTwqhlPs, f8EJDpgT }, new SubProgressMonitor(VQK88aqe, 5));
		StringBuilder ZvH0ku50 = new StringBuilder();
		ZvH0ku50.append("bin.includes = META-INF/,\\\n");
		ZvH0ku50.append("               sapjco3.jar,\\\n");
		ZvH0ku50.append("               jni/,\\\n");
		ZvH0ku50.append("               .\n");
		writeTextFile(VQK88aqe, ZvH0ku50, DBghtbhM.getFile("build.properties"));
		exportableBundles.add(modelManager.findModel(DBghtbhM));
	}

}