class n17477951 {
	public static void copy(String OR8523UI, String kZqYshk0) throws Exception {
		try {
			FileReader Ku2AyhEK = new FileReader(OR8523UI);
			FileWriter EMYQroH5 = new FileWriter(kZqYshk0);
			int en0kZzjd;
			while ((en0kZzjd = Ku2AyhEK.read()) != -1)
				EMYQroH5.write(en0kZzjd);
			Ku2AyhEK.close();
			EMYQroH5.close();
		} catch (Exception qm18WUSv) {
			throw new Exception(
					"Could not copy " + OR8523UI + " into " + kZqYshk0 + " because:\n" + qm18WUSv.getMessage());
		}
	}

}