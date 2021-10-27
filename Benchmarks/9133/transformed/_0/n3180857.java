class n3180857 {
	void load(URL ryQNT2nX) throws IOException {
		BufferedReader TLhMWZyd = new BufferedReader(new InputStreamReader(ryQNT2nX.openStream()));
		Vector3f xwlTOlsx = new Vector3f(1, 1, 1);
		Group vqBOpeoq = new Group();
		vqBOpeoq.name = "default";
		groups.add(vqBOpeoq);
		String pR6BcJJi;
		while ((pR6BcJJi = TLhMWZyd.readLine()) != null) {
			String[] cTuhFiZG = pR6BcJJi.split(" +");
			if (cTuhFiZG.length == 0)
				continue;
			String Ags43LeB = cTuhFiZG[0];
			if (cTuhFiZG[0].equals("v")) {
				Vector3f SYbK4A5x = new Vector3f(Float.parseFloat(cTuhFiZG[1]) * xwlTOlsx.x,
						Float.parseFloat(cTuhFiZG[2]) * xwlTOlsx.y, Float.parseFloat(cTuhFiZG[3]) * xwlTOlsx.z);
				verticies.add(SYbK4A5x);
				radius = Math.max(radius, SYbK4A5x.length());
			}
			if (Ags43LeB.equals("center")) {
				epicenter = new Vector3f(Float.parseFloat(cTuhFiZG[1]), Float.parseFloat(cTuhFiZG[2]),
						Float.parseFloat(cTuhFiZG[3]));
			} else if (Ags43LeB.equals("f")) {
				Face vl3TQQY8 = new Face();
				for (int muN9e4bf = 1; muN9e4bf < cTuhFiZG.length; muN9e4bf++) {
					String IjPtCJWf[] = cTuhFiZG[muN9e4bf].split("/");
					Vector3f NqROwRVl = verticies.get(Integer.parseInt(IjPtCJWf[0]) - 1);
					vl3TQQY8.add(NqROwRVl);
				}
				vqBOpeoq.faces.add(vl3TQQY8);
			} else if (Ags43LeB.equals("l")) {
				Line VfFiFe12 = new Line();
				for (int T8aIKkhL = 1; T8aIKkhL < cTuhFiZG.length; T8aIKkhL++) {
					Vector3f WZ5psJkI = verticies.get(Integer.parseInt(cTuhFiZG[T8aIKkhL]) - 1);
					VfFiFe12.add(WZ5psJkI);
				}
				vqBOpeoq.lines.add(VfFiFe12);
			} else if (Ags43LeB.equals("g") && cTuhFiZG.length > 1) {
				vqBOpeoq = new Group();
				vqBOpeoq.name = cTuhFiZG[1];
				groups.add(vqBOpeoq);
			} else if (Ags43LeB.equals("scale")) {
				xwlTOlsx = new Vector3f(Float.parseFloat(cTuhFiZG[1]), Float.parseFloat(cTuhFiZG[2]),
						Float.parseFloat(cTuhFiZG[3]));
			}
		}
		TLhMWZyd.close();
	}

}