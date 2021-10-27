class n7380001 {
	private static void generateFile(String IRFalPxV, String Stz09i7W) throws Exception {
		File QGXmLBDA = new File(IRFalPxV);
		if (QGXmLBDA.exists() == false) {
			throw new Exception(Messages.getString("ScriptDocToBinary.Input_File_Does_Not_Exist") + IRFalPxV);
		}
		Environment KKdpaFO7 = new Environment();
		KKdpaFO7.initBuiltInObjects();
		NativeObjectsReader UTsh3zUa = new NativeObjectsReader(KKdpaFO7);
		InputStream gL5Dbk43 = new FileInputStream(QGXmLBDA);
		System.out.println(Messages.getString("ScriptDocToBinary.Reading_Documentation") + IRFalPxV);
		UTsh3zUa.loadXML(gL5Dbk43);
		checkFile(Stz09i7W);
		File BC1u0svk = new File(Stz09i7W);
		FileOutputStream CcXXkdnk = new FileOutputStream(BC1u0svk);
		TabledOutputStream SAnV4zrF = new TabledOutputStream(CcXXkdnk);
		UTsh3zUa.getScriptDoc().write(SAnV4zrF);
		SAnV4zrF.close();
		System.out.println(Messages.getString("ScriptDocToBinary.Finished"));
		System.out.println();
	}

}