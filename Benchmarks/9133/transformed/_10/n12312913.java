class n12312913 {
	public static void rewrite(String[] args) throws IOException, CodeCheckException {
		ClassWriter writer = new ClassWriter();
		writer.readClass(new FileInputStream(args[0]));
		BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(args[1]));
		for (Iterator i = writer.getMethods().iterator(); i.hasNext();) {
			MethodInfo method = (MethodInfo) i.next();
			CodeAttribute attribute = method.getCodeAttribute();
			int origStack = attribute.getMaxStack();
			System.out.print(method.getName());
			attribute.codeCheck();
			System.out.println(" " + origStack + " " + attribute.getMaxStack());
		}
		writer.writeClass(outStream);
		outStream.close();
	}

}