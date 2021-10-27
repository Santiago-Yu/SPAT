class n18431646 {
	public Savable loadResource(String name, PrimitiveLoader loader) {
		URL url = ResourceLocator.locateFile(loader.getBaseFolder(), name, loader.getCompiledExtension());
		Savable objeto = null;
		if (url == null) {
			url = ResourceLocator.locateFile(loader.getBaseFolder(), name, loader.getPrimitiveExtension());
			if (url != null) {
				try {
					objeto = loader.loadResource(name, url.openStream());
					File file = ResourceLocator.replaceExtension(url, loader.getCompiledExtension());
					BinaryExporter.getInstance().save(objeto, file);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				objeto = BinaryImporter.getInstance().load(url.openStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return objeto;
	}

}