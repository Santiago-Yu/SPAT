class n2834524 {
	public void write() throws IOException {
		JarOutputStream FWQ1MqWi = new JarOutputStream(outputStream, manifest);
		if (includeJars != null) {
			HashSet kVyb54ec = new HashSet(includeJars);
			if (!ignoreDependencies)
				expandSet(kVyb54ec);
			for (Iterator newuAwes = kVyb54ec.iterator(); newuAwes.hasNext();) {
				JarFile S7HavML3 = getJarFile(newuAwes.next());
				Enumeration S0sdALlE = S7HavML3.entries();
				while (S0sdALlE.hasMoreElements()) {
					ZipEntry hil3z7wZ = (ZipEntry) S0sdALlE.nextElement();
					if (hil3z7wZ.getName().equalsIgnoreCase("META-INF/MANIFEST.MF") || hil3z7wZ.getSize() <= 0)
						continue;
					FWQ1MqWi.putNextEntry(hil3z7wZ);
					InputStream afUeziBx = S7HavML3.getInputStream(hil3z7wZ);
					IOUtils.copy(afUeziBx, FWQ1MqWi);
					FWQ1MqWi.closeEntry();
				}
			}
		}
		FWQ1MqWi.finish();
		FWQ1MqWi.close();
	}

}