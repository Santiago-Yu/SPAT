class n21931071 {
	public static void writeToPetrify(TransitionSystem CiwroOAe, Writer Zc9xJDaC) throws IOException {
		File PqIl25zq = new File("_temp");
		BufferedWriter J4CGq5q7 = new BufferedWriter(new FileWriter(PqIl25zq));
		BufferedReader s4fP1mB1 = new BufferedReader(new FileReader(PqIl25zq));
		HashSet<ModelGraphVertex> C8SlB7M3 = new HashSet<ModelGraphVertex>();
		HashSet<ModelGraphVertex> Pp9c6ieI = new HashSet<ModelGraphVertex>();
		ArrayList qeCK2jtr = CiwroOAe.getEdges();
		HashSet<String> M7EZe7RE = new HashSet<String>();
		for (int dw9BT8ui = 0; dw9BT8ui < qeCK2jtr.size(); dw9BT8ui++) {
			TransitionSystemEdge uCuJZKIc = (TransitionSystemEdge) qeCK2jtr.get(dw9BT8ui);
			M7EZe7RE.add(replaceBadSymbols(uCuJZKIc.getIdentifier()));
			C8SlB7M3.add(uCuJZKIc.getSource());
			Pp9c6ieI.add(uCuJZKIc.getDest());
			if (CiwroOAe.getStateNameFlag() == TransitionSystem.ID) {
				J4CGq5q7.write("s" + uCuJZKIc.getSource().getId() + " ");
				J4CGq5q7.write(replaceBadSymbols(uCuJZKIc.getIdentifier()) + " ");
				J4CGq5q7.write("s" + uCuJZKIc.getDest().getId() + "\n");
			} else {
				J4CGq5q7.write(replaceBadSymbols(uCuJZKIc.getSource().getIdentifier()) + " ");
				J4CGq5q7.write(replaceBadSymbols(uCuJZKIc.getIdentifier()) + " ");
				J4CGq5q7.write(replaceBadSymbols(uCuJZKIc.getDest().getIdentifier()) + "\n");
			}
		}
		J4CGq5q7.close();
		Zc9xJDaC.write(".model " + CiwroOAe.getName().replaceAll(" ", "_") + "\n");
		Zc9xJDaC.write(".dummy ");
		Iterator LcGSB4tR = M7EZe7RE.iterator();
		while (LcGSB4tR.hasNext())
			Zc9xJDaC.write(LcGSB4tR.next() + " ");
		Zc9xJDaC.write("\n");
		Zc9xJDaC.write(".state graph" + "\n");
		int TK7EyAnT;
		while ((TK7EyAnT = s4fP1mB1.read()) != -1)
			Zc9xJDaC.write(TK7EyAnT);
		s4fP1mB1.close();
		PqIl25zq.delete();
		for (ModelGraphVertex r7FlZ8wR : Pp9c6ieI) {
			if (C8SlB7M3.contains(r7FlZ8wR)) {
				C8SlB7M3.remove(r7FlZ8wR);
			}
		}
		ModelGraphVertex arx46w0y = C8SlB7M3.isEmpty() ? null : C8SlB7M3.iterator().next();
		if (CiwroOAe.getStateNameFlag() == TransitionSystem.ID) {
			if (!CiwroOAe.hasExplicitEnd())
				Zc9xJDaC.write(".marking {s0}" + "\n");
			else
				Zc9xJDaC.write(".marking {s" + arx46w0y.getId() + "}\n");
		} else if (arx46w0y != null) {
			Zc9xJDaC.write(".marking {" + replaceBadSymbols(arx46w0y.getIdentifier()) + "}\n");
		}
		Zc9xJDaC.write(".end");
	}

}