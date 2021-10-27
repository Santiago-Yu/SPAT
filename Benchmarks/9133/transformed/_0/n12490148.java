class n12490148 {
	private void createIDocPluginProject(IProgressMonitor cOenE7hG, String V1Ov0KLh, String qxTKBaUA, String sZabTZqO)
			throws CoreException, IOException {
		cOenE7hG.subTask(MessageFormat.format(Messages.ProjectGenerator_CreatePluginTaskDescription, qxTKBaUA));
		final Map<String, byte[]> AJRB9bNd = readArchiveFile(V1Ov0KLh);
		cOenE7hG.worked(10);
		IProject nzrJx1pf = workspaceRoot.getProject(qxTKBaUA);
		if (nzrJx1pf.exists()) {
			nzrJx1pf.delete(true, true, new SubProgressMonitor(cOenE7hG, 5));
		} else {
			cOenE7hG.worked(5);
		}
		nzrJx1pf.create(new SubProgressMonitor(cOenE7hG, 5));
		nzrJx1pf.open(new SubProgressMonitor(cOenE7hG, 5));
		IProjectDescription Pjl6Q0da = nzrJx1pf.getDescription();
		Pjl6Q0da.setNatureIds(new String[] { JavaCore.NATURE_ID, PLUGIN_NATURE_ID });
		nzrJx1pf.setDescription(Pjl6Q0da, new SubProgressMonitor(cOenE7hG, 5));
		IJavaProject aU2fcHPl = JavaCore.create(nzrJx1pf);
		IFolder OXfQLXvF = nzrJx1pf.getFolder("bin");
		IPath TW4LFqip = OXfQLXvF.getFullPath();
		aU2fcHPl.setOutputLocation(TW4LFqip, new SubProgressMonitor(cOenE7hG, 5));
		nzrJx1pf.getFile("sapidoc3.jar").create(new ByteArrayInputStream(AJRB9bNd.get("sapidoc3.jar")), true,
				new SubProgressMonitor(cOenE7hG, 15));
		IFolder wTKRLKSH = nzrJx1pf.getFolder("META-INF");
		wTKRLKSH.create(true, true, new SubProgressMonitor(cOenE7hG, 5));
		StringBuilder mWaunNLP = new StringBuilder();
		mWaunNLP.append("Manifest-Version: 1.0\n");
		mWaunNLP.append("Bundle-ManifestVersion: 2\n");
		mWaunNLP.append("Bundle-Name: SAP IDoc Library v3\n");
		mWaunNLP.append(MessageFormat.format("Bundle-SymbolicName: {0}\n", qxTKBaUA));
		mWaunNLP.append("Bundle-Version: 7.11.0\n");
		mWaunNLP.append("Bundle-ClassPath: bin/,\n");
		mWaunNLP.append(" sapidoc3.jar\n");
		mWaunNLP.append("Bundle-Vendor: SAP AG, Walldorf (packaged using RCER)\n");
		mWaunNLP.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\n");
		mWaunNLP.append("Export-Package: com.sap.conn.idoc,\n");
		mWaunNLP.append(" com.sap.conn.idoc.jco,\n");
		mWaunNLP.append(" com.sap.conn.idoc.rt.cp,\n");
		mWaunNLP.append(" com.sap.conn.idoc.rt.record,\n");
		mWaunNLP.append(" com.sap.conn.idoc.rt.record.impl,\n");
		mWaunNLP.append(" com.sap.conn.idoc.rt.trace,\n");
		mWaunNLP.append(" com.sap.conn.idoc.rt.util,\n");
		mWaunNLP.append(" com.sap.conn.idoc.rt.xml\n");
		mWaunNLP.append("Bundle-ActivationPolicy: lazy\n");
		mWaunNLP.append(MessageFormat.format("Require-Bundle: {0}\n", sZabTZqO));
		writeTextFile(cOenE7hG, mWaunNLP, wTKRLKSH.getFile("MANIFEST.MF"));
		final IPath ARdhFE21 = new Path(MessageFormat.format("/{0}/sapidoc3.jar", qxTKBaUA));
		IClasspathEntry Go3NYj37 = JavaCore.newLibraryEntry(ARdhFE21, Path.EMPTY, Path.EMPTY, true);
		aU2fcHPl.setRawClasspath(new IClasspathEntry[] { Go3NYj37 }, new SubProgressMonitor(cOenE7hG, 5));
		StringBuilder f9IXGbc2 = new StringBuilder();
		f9IXGbc2.append("bin.includes = META-INF/,\\\n");
		f9IXGbc2.append("               sapidoc3.jar,\\\n");
		f9IXGbc2.append("               .\n");
		writeTextFile(cOenE7hG, f9IXGbc2, nzrJx1pf.getFile("build.properties"));
		exportableBundles.add(modelManager.findModel(nzrJx1pf));
	}

}