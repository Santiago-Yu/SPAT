class n3180857 {
	void load(URL url) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
		Vector3f scale = new Vector3f(1, 1, 1);
		Group currentGroup = new Group();
		currentGroup.name = "default";
		groups.add(currentGroup);
		String line;
		while ((line = r.readLine()) != null) {
			String[] params = line.split(" +");
			if (params.length == 0)
				continue;
			String command = params[0];
			if (params[0].equals("v")) {
				Vector3f vertex = new Vector3f(Float.parseFloat(params[1]) * scale.x,
						Float.parseFloat(params[2]) * scale.y, Float.parseFloat(params[3]) * scale.z);
				verticies.add(vertex);
				radius = Math.max(radius, vertex.length());
			}
			if (command.equals("center")) {
				epicenter = new Vector3f(Float.parseFloat(params[1]), Float.parseFloat(params[2]),
						Float.parseFloat(params[3]));
			} else if (command.equals("f")) {
				Face f = new Face();
				for (int i = 1; i < params.length; i++) {
					String parts[] = params[i].split("/");
					Vector3f v = verticies.get(Integer.parseInt(parts[0]) - 1);
					f.add(v);
				}
				currentGroup.faces.add(f);
			} else if (command.equals("l")) {
				Line l = new Line();
				for (int i = 1; i < params.length; i++) {
					Vector3f v = verticies.get(Integer.parseInt(params[i]) - 1);
					l.add(v);
				}
				currentGroup.lines.add(l);
			} else if (command.equals("g") && params.length > 1) {
				currentGroup = new Group();
				currentGroup.name = params[1];
				groups.add(currentGroup);
			} else
				scale = (command.equals("scale")) ? new Vector3f(Float.parseFloat(params[1]),
						Float.parseFloat(params[2]), Float.parseFloat(params[3])) : scale;
		}
		r.close();
	}

}