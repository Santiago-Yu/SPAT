class n14819747 {
	public static void main(final String jCwa3fwB[]) {
		if (jCwa3fwB.length < 2 || (jCwa3fwB.length == 3 && !"-d".equals(jCwa3fwB[0]))) {
			System.out.println("Usage: AdapterGenerator [Options] <PrologFile> <ClassPath>");
			System.out.println("       where the framework is the first element in the class path");
			System.out.println("Options: -d Enables the generation of debug output");
			return;
		}
		boolean JkcqxpIz = jCwa3fwB.length == 3;
		File QdKQ5ddD = new File(JkcqxpIz ? jCwa3fwB[1] : jCwa3fwB[0]);
		if (!QdKQ5ddD.isFile()) {
			System.out.println("The given file does not exist.");
			return;
		}
		File y89PtSVJ = new File(QdKQ5ddD.getParentFile(),
				QdKQ5ddD.getName().substring(0, QdKQ5ddD.getName().lastIndexOf(".")) + ".jar");
		String N43dFKtQ;
		try {
			N43dFKtQ = FileUtils.readFileToString(QdKQ5ddD);
		} catch (IOException shgb8Fri) {
			System.out.println("Error reading file: " + shgb8Fri.getMessage());
			return;
		}
		Parser TI5qOzD9 = new PrologParserImpl();
		PrologProgram nY4WIBZz;
		try {
			nY4WIBZz = (PrologProgram) TI5qOzD9.parse(N43dFKtQ);
		} catch (Exception METHoQaq) {
			System.out.println("Could not parse file: " + METHoQaq.getMessage());
			return;
		}
		try {
			FactVisitor UQ0jXhC9 = new FactVisitor();
			UQ0jXhC9.visit(nY4WIBZz);
			Map<String, TypeGenerationInfo> xpfFHTYv = UQ0jXhC9.getAdapterLayer();
			if (xpfFHTYv.size() == 0) {
				System.out.println("No adapters to generate, " + "did you forget to run the comeback rules?");
				return;
			}
			URLClassLoader gJOR1BIk = createClassLoaderFromClassPath(JkcqxpIz ? jCwa3fwB[2] : jCwa3fwB[1]);
			ClassWriter cLNMFLVX = new ClassWriter(new JarEntryWriter(y89PtSVJ));
			AdapterAnnotationGenerator WTP251gT = new AdapterAnnotationGenerator();
			Type hmshKd4W = Type.getObjectType("net/sourceforge/comeback/Adapter");
			cLNMFLVX.writeClass(hmshKd4W.getClassName(), WTP251gT.createAnnotation(hmshKd4W));
			AdapterLookupGenerator GcFyXGJB = new AdapterLookupGenerator(
					Type.getObjectType("net/sourceforge/comeback/Adapters"), hmshKd4W);
			GenerationContext itlhcvAg = new GenerationContext(xpfFHTYv, gJOR1BIk, hmshKd4W, GcFyXGJB, cLNMFLVX);
			itlhcvAg.setGenerateDebugOutput(JkcqxpIz);
			Iterator<TypeGenerationInfo> x1bcBkcG = xpfFHTYv.values().iterator();
			while (x1bcBkcG.hasNext()) {
				TypeGenerationInfo iv39vBVQ = x1bcBkcG.next();
				itlhcvAg.generateAdapter(iv39vBVQ);
			}
			ByteArrayOutputStream k9l962rt = new ByteArrayOutputStream();
			ObjectOutputStream Glug2aDk = new ObjectOutputStream(k9l962rt);
			Glug2aDk.writeObject(xpfFHTYv);
			Glug2aDk.close();
			cLNMFLVX.writeResource("net/sourceforge/comeback/adapterlayer.ser", k9l962rt.toByteArray());
			String[] DZuDMD9F = new String[2];
			Assembler GYn7Cx7G = new Assembler(cLNMFLVX);
			PatternClassFilter X1zIqp2X = new PatternClassFilter();
			URL XnDwMKJn = Main.class.getResource("/" + Main.class.getName().replace('.', '/') + ".class");
			JarURLConnection NVZWDqQD = (JarURLConnection) XnDwMKJn.openConnection();
			DZuDMD9F[0] = GYn7Cx7G.assemble(NVZWDqQD.getJarFile(), X1zIqp2X);
			X1zIqp2X = new PatternClassFilter();
			XnDwMKJn = Type.class.getResource("/" + Type.class.getName().replace('.', '/') + ".class");
			NVZWDqQD = (JarURLConnection) XnDwMKJn.openConnection();
			DZuDMD9F[1] = GYn7Cx7G.assemble(NVZWDqQD.getJarFile(), X1zIqp2X);
			String LgB5xJTC = JkcqxpIz ? jCwa3fwB[2] : jCwa3fwB[1];
			cLNMFLVX.writeClass(GcFyXGJB.getType().getClassName(), GcFyXGJB.createAdapterLookup(xpfFHTYv.values(),
					LgB5xJTC.substring(LgB5xJTC.lastIndexOf(File.pathSeparator) + 1), DZuDMD9F));
			cLNMFLVX.close();
		} catch (Throwable a2I5qUnV) {
			a2I5qUnV.printStackTrace();
			return;
		}
	}

}