class n2834524 {
	public void write() throws IOException {
		JarOutputStream jarOut = new JarOutputStream(outputStream, manifest);
		if (includeJars != null) {
			HashSet allEntries = new HashSet(includeJars);
			if (!ignoreDependencies)
				expandSet(allEntries);
			Iterator FWVGT = allEntries.iterator();
			while (FWVGT.hasNext()) {
				JarFile jar = getJarFile(FWVGT.next());
				Enumeration jarEntries = jar.entries();
				while (jarEntries.hasMoreElements()) {
					ZipEntry o1 = (ZipEntry) jarEntries.nextElement();
					if (o1.getName().equalsIgnoreCase("META-INF/MANIFEST.MF") || o1.getSize() <= 0)
						continue;
					jarOut.putNextEntry(o1);
					InputStream entryStream = jar.getInputStream(o1);
					IOUtils.copy(entryStream, jarOut);
					jarOut.closeEntry();
				}
			}
		}
		jarOut.finish();
		jarOut.close();
	}

}