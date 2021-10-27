class n18600188 {
	private void copyFile(String T376KBuK, String HhG4JWJW, boolean qnqvnlMf) {
		try {
			File GPx6RGcg = new File(T376KBuK);
			File emyP9W8f = null;
			if (qnqvnlMf) {
				emyP9W8f = new File(provider.getErrorDataLocation(folderName) + HhG4JWJW + ".xml");
			} else {
				emyP9W8f = new File(provider.getDataProcessedLocation(folderName) + HhG4JWJW + ".xml");
			}
			FileReader d9SdI371 = new FileReader(GPx6RGcg);
			FileWriter YwZQ8agU = new FileWriter(emyP9W8f);
			int R9OdgtK1;
			while ((R9OdgtK1 = d9SdI371.read()) != -1)
				YwZQ8agU.write(R9OdgtK1);
			d9SdI371.close();
			YwZQ8agU.close();
		} catch (Exception BQPl6yLM) {
		}
	}

}