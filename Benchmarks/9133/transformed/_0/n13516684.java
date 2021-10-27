class n13516684 {
	void run(PseudolocalizerArguments CJ2jJzlx) throws IOException {
		List<String> wFv4NnZb = CJ2jJzlx.getFileNames();
		PseudolocalizationPipeline EP00KqqL = CJ2jJzlx.getPipeline();
		if (CJ2jJzlx.isInteractive()) {
			runStdin(EP00KqqL);
			return;
		}
		if (wFv4NnZb.size() == 0) {
			MessageCatalog xqhKpPy4 = FormatRegistry.getMessageCatalog(CJ2jJzlx.getType());
			writeMessages(xqhKpPy4, readAndProcessMessages(EP00KqqL, xqhKpPy4, System.in), System.out);
			return;
		}
		String vFKaO6Wn = CJ2jJzlx.getVariant();
		if (vFKaO6Wn == null) {
			vFKaO6Wn = "_pseudo";
		} else {
			vFKaO6Wn = "_" + vFKaO6Wn;
		}
		for (String tjJCJfOp : wFv4NnZb) {
			File aSohV75G = new File(tjJCJfOp);
			if (!aSohV75G.exists()) {
				System.err.println("File " + tjJCJfOp + " not found");
				continue;
			}
			int uOhsfZBO = tjJCJfOp.lastIndexOf('.');
			String VyltvGLc;
			String oQn87OyQ;
			if (uOhsfZBO >= 0) {
				VyltvGLc = tjJCJfOp.substring(uOhsfZBO + 1);
				oQn87OyQ = tjJCJfOp.substring(0, uOhsfZBO) + vFKaO6Wn + "." + VyltvGLc;
			} else {
				VyltvGLc = "";
				oQn87OyQ = tjJCJfOp + vFKaO6Wn;
			}
			System.out.println("Processing " + tjJCJfOp + " into " + oQn87OyQ);
			String lnLJHOnE = CJ2jJzlx.getType();
			if (lnLJHOnE == null) {
				lnLJHOnE = VyltvGLc;
			}
			MessageCatalog JaWkNnyk = FormatRegistry.getMessageCatalog(lnLJHOnE);
			InputStream C52c306k = new FileInputStream(aSohV75G);
			List<Message> bqParsW4 = readAndProcessMessages(EP00KqqL, JaWkNnyk, C52c306k);
			OutputStream IZKIqmyI = new FileOutputStream(new File(oQn87OyQ));
			writeMessages(JaWkNnyk, bqParsW4, IZKIqmyI);
		}
	}

}