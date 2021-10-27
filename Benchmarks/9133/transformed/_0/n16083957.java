class n16083957 {
	protected void createValueListAnnotation(IProgressMonitor kKydrb0a, IPackageFragment caYM6OTA, Map CeXL8qXx)
			throws CoreException {
		IProject SR3r6JUp = caYM6OTA.getJavaProject().getProject();
		QualifiedName OvFA7XI5 = new QualifiedName(JstActivator.PLUGIN_ID, JstActivator.PACKAGE_INFO_LOCATION);
		String fqwBB55D = SR3r6JUp.getPersistentProperty(OvFA7XI5);
		if (fqwBB55D != null) {
			IFolder mi0fj3aP = SR3r6JUp.getFolder(new Path(NexOpenFacetInstallDataModelProvider.WEB_SRC_MAIN_JAVA));
			IFolder RgbSbedM = mi0fj3aP.getFolder(fqwBB55D);
			if (!RgbSbedM.exists()) {
				Logger.log(Logger.INFO, "package-info package [" + fqwBB55D + "] does not exists.");
				Logger.log(Logger.INFO,
						"ValueList annotation will not be added by this wizard. "
								+ "You must add manually in your package-info class if exist "
								+ "or create a new one at location " + fqwBB55D);
				return;
			}
			IFile cazQyeyn = RgbSbedM.getFile("package-info.java");
			if (!cazQyeyn.exists()) {
				Logger.log(Logger.INFO, "package-info class at location [" + fqwBB55D + "] does not exists.");
				return;
			}
			InputStream fbP1reWU = cazQyeyn.getContents();
			ByteArrayOutputStream yAzOhZKr = new ByteArrayOutputStream();
			try {
				IOUtils.copy(fbP1reWU, yAzOhZKr);
				String EM03mpL1 = new String(yAzOhZKr.toByteArray());
				VelocityEngine OtO10xEC = VelocityEngineHolder.getEngine();
				CeXL8qXx.put("adapterType", getAdapterType());
				CeXL8qXx.put("packageInfo", fqwBB55D.replace('/', '.'));
				CeXL8qXx.put("defaultNumberPerPage", "5");
				CeXL8qXx.put("defaultSortDirection", "asc");
				if (isFacadeAdapter()) {
					CeXL8qXx.put("facadeType", "true");
				}
				if (EM03mpL1.indexOf("@ValueLists({})") > -1) {
					appendValueList(kKydrb0a, CeXL8qXx, cazQyeyn, EM03mpL1, OtO10xEC, true);
					return;
				} else if (EM03mpL1.indexOf("@ValueLists") > -1) {
					appendValueList(kKydrb0a, CeXL8qXx, cazQyeyn, EM03mpL1, OtO10xEC, false);
					return;
				}
				String Wu9trRk5 = VelocityEngineUtils.mergeTemplateIntoString(OtO10xEC, "ValueList.vm", CeXL8qXx);
				ByteArrayInputStream gso33g90 = new ByteArrayInputStream(Wu9trRk5.getBytes());
				try {
					cazQyeyn.setContents(gso33g90, true, false, kKydrb0a);
				} finally {
					gso33g90.close();
				}
				return;
			} catch (IOException uNl3QTiD) {
				IStatus kGCzJiJH = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
						"I/O exception", uNl3QTiD);
				throw new CoreException(kGCzJiJH);
			} catch (VelocityException rJ9oYziX) {
				IStatus NGrCl0zY = new Status(IStatus.ERROR, JeeServiceComponentUIPlugin.PLUGIN_ID, IStatus.OK,
						"Velocity exception", rJ9oYziX);
				throw new CoreException(NGrCl0zY);
			} finally {
				try {
					yAzOhZKr.close();
					fbP1reWU.close();
				} catch (IOException NQTzD047) {
				}
			}
		}
		Logger.log(Logger.INFO, "package-info location property does not exists.");
	}

}