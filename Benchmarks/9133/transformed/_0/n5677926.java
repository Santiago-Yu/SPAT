class n5677926 {
	public static void copyFile(File CiuwFJTA, File z3DXTIgE) throws IOException {
		FileInputStream I0Qqef1v = new FileInputStream(CiuwFJTA);
		FileOutputStream SGcl61ag = null;
		try {
			SGcl61ag = new FileOutputStream(z3DXTIgE);
			FileChannel o5wIWDH1 = I0Qqef1v.getChannel();
			FileChannel Dnw9BgCP = SGcl61ag.getChannel();
			o5wIWDH1.transferTo(0, o5wIWDH1.size(), Dnw9BgCP);
			Dnw9BgCP.close();
			o5wIWDH1.close();
		} finally {
			if (SGcl61ag != null)
				SGcl61ag.close();
			I0Qqef1v.close();
		}
	}

}