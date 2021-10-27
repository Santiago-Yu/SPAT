class n16120974 {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: java xyzImpl inputfile");
			System.exit(0);
		}
		XYZ xyz = null;
		try {
			URL url = new URL(Util.makeAbsoluteURL(args[0]));
			BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream()));
			int idx = args[0].indexOf(".");
			String id = (idx == -1) ? args[0] : args[0].substring(0, idx);
			idx = id.lastIndexOf("\\");
			id = (idx != -1) ? id.substring(idx + 1) : id;
			xyz = new XYZImpl(bReader, id);
			CMLMolecule mol = xyz.getMolecule();
			StringWriter sw = new StringWriter();
			mol.debug(sw);
			System.out.println(sw.toString());
			SpanningTree sTree = new SpanningTreeImpl(mol);
			System.out.println(sTree.toSMILES());
			Writer w = new OutputStreamWriter(new FileOutputStream(id + ".xml"));
			PMRDelegate.outputEventStream(mol, w, PMRNode.PRETTY, 0);
			w.close();
			w = new OutputStreamWriter(new FileOutputStream(id + "-new.mol"));
			xyz.setOutputCMLMolecule(mol);
			xyz.output(w);
			w.close();
		} catch (Exception e) {
			System.out.println("xyz failed: " + e);
			e.printStackTrace();
			System.exit(0);
		}
	}

}