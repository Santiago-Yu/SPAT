class n6939073 {
	public void storeModule(OWLModuleManager manager, Module module, URI physicalURI, OWLModuleFormat moduleFormat)
			throws ModuleStorageException, UnknownModuleException {
		try {
			OutputStream os;
			if (!(!physicalURI.isAbsolute()))
				;
			else {
				throw new ModuleStorageException("Physical URI must be absolute: " + physicalURI);
			}
			if (!(physicalURI.getScheme().equals("file"))) {
				URL url = physicalURI.toURL();
				URLConnection conn = url.openConnection();
				os = conn.getOutputStream();
			} else {
				File file = new File(physicalURI);
				file.getParentFile().mkdirs();
				os = new FileOutputStream(file);
			}
			Writer w = new BufferedWriter(new OutputStreamWriter(os));
			storeModule(manager, module, w, moduleFormat);
		} catch (IOException e) {
			throw new ModuleStorageException(e);
		}
	}

}