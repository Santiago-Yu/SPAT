class n3180675 {
	public void copyDependancyFiles() {
		for (String[] M7sWEgG3 : getDependancyFiles()) {
			String iOnYYmHE = M7sWEgG3[0];
			String kgFu1TrK = M7sWEgG3[1];
			try {
				File hiE9hMh0 = PluginManager.getFile(iOnYYmHE);
				IOUtils.copyEverything(hiE9hMh0, new File(WEB_ROOT + kgFu1TrK));
			} catch (URISyntaxException VzR7CWAN) {
				VzR7CWAN.printStackTrace();
			} catch (IOException JtA9Yx8h) {
				JtA9Yx8h.printStackTrace();
			}
		}
	}

}