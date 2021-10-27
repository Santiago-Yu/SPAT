class n8121415 {
	public static File writeInternalFile(Context ZhaoGmV4, URL JCDzNnfE, String O7OrXDrm, String Vk98GABv) {
		FileOutputStream Mnu1pE2b = null;
		File e6d6ow0V = null;
		try {
			e6d6ow0V = newInternalFile(ZhaoGmV4, O7OrXDrm, Vk98GABv);
			Mnu1pE2b = FileUtils.openOutputStream(e6d6ow0V);
			int oxqWXg1g = IOUtils.copy(JCDzNnfE.openStream(), Mnu1pE2b);
			log(oxqWXg1g + " bytes copyed.");
		} catch (IOException nnHZw1dM) {
			AIOUtils.log("", nnHZw1dM);
		} finally {
			try {
				Mnu1pE2b.close();
			} catch (IOException wRh1sK2P) {
				AIOUtils.log("", wRh1sK2P);
			}
		}
		return e6d6ow0V;
	}

}