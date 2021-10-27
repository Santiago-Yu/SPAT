class n14819747 {
	public static void main(final String args[]) {
		if (args.length < 2 || (args.length == 3 && !"-d".equals(args[0]))) {
			System.out.println("Usage: AdapterGenerator [Options] <PrologFile> <ClassPath>");
			System.out.println("       where the framework is the first element in the class path");
			System.out.println("Options: -d Enables the generation of debug output");
			return;
		}
		boolean debug = args.length == 3;
		File prologFile = new File(debug ? args[1] : args[0]);
		if (!prologFile.isFile()) {
			System.out.println("The given file does not exist.");
			return;
		}
		String source;
		File targetFile = new File(prologFile.getParentFile(),
				prologFile.getName().substring(0, prologFile.getName().lastIndexOf(".")) + ".jar");
		Parser myParser = new PrologParserImpl();
		try {
			source = FileUtils.readFileToString(prologFile);
		} catch (IOException ex) {
			System.out.println("Error reading file: " + ex.getMessage());
			return;
		}
		PrologProgram myProgram;
		try {
			myProgram = (PrologProgram) myParser.parse(source);
		} catch (Exception ex) {
			System.out.println("Could not parse file: " + ex.getMessage());
			return;
		}
		try {
			FactVisitor myVisitor = new FactVisitor();
			myVisitor.visit(myProgram);
			Map<String, TypeGenerationInfo> adapterLayer = myVisitor.getAdapterLayer();
			if (adapterLayer.size() == 0) {
				System.out.println("No adapters to generate, " + "did you forget to run the comeback rules?");
				return;
			}
			ClassWriter adapterWriter = new ClassWriter(new JarEntryWriter(targetFile));
			URLClassLoader classLoader = createClassLoaderFromClassPath(debug ? args[2] : args[1]);
			Type annotationType = Type.getObjectType("net/sourceforge/comeback/Adapter");
			AdapterAnnotationGenerator annotationGenerator = new AdapterAnnotationGenerator();
			adapterWriter.writeClass(annotationType.getClassName(),
					annotationGenerator.createAnnotation(annotationType));
			AdapterLookupGenerator lookupWriter = new AdapterLookupGenerator(
					Type.getObjectType("net/sourceforge/comeback/Adapters"), annotationType);
			GenerationContext context = new GenerationContext(adapterLayer, classLoader, annotationType, lookupWriter,
					adapterWriter);
			context.setGenerateDebugOutput(debug);
			Iterator<TypeGenerationInfo> iterator = adapterLayer.values().iterator();
			ByteArrayOutputStream serialized = new ByteArrayOutputStream();
			while (iterator.hasNext()) {
				TypeGenerationInfo info = iterator.next();
				context.generateAdapter(info);
			}
			ObjectOutputStream out = new ObjectOutputStream(serialized);
			out.writeObject(adapterLayer);
			out.close();
			adapterWriter.writeResource("net/sourceforge/comeback/adapterlayer.ser", serialized.toByteArray());
			Assembler assembler = new Assembler(adapterWriter);
			String[] sharedClassesPrefixes = new String[2];
			URL url = Main.class.getResource("/" + Main.class.getName().replace('.', '/') + ".class");
			PatternClassFilter filter = new PatternClassFilter();
			JarURLConnection connection = (JarURLConnection) url.openConnection();
			sharedClassesPrefixes[0] = assembler.assemble(connection.getJarFile(), filter);
			url = Type.class.getResource("/" + Type.class.getName().replace('.', '/') + ".class");
			filter = new PatternClassFilter();
			connection = (JarURLConnection) url.openConnection();
			String tmp = debug ? args[2] : args[1];
			sharedClassesPrefixes[1] = assembler.assemble(connection.getJarFile(), filter);
			adapterWriter.writeClass(lookupWriter.getType().getClassName(),
					lookupWriter.createAdapterLookup(adapterLayer.values(),
							tmp.substring(tmp.lastIndexOf(File.pathSeparator) + 1), sharedClassesPrefixes));
			adapterWriter.close();
		} catch (Throwable e) {
			e.printStackTrace();
			return;
		}
	}

}