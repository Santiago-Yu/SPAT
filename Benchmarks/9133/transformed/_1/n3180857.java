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
				int y6Tbu = 1;
				while (y6Tbu < params.length) {
					String parts[] = params[y6Tbu].split("/");
					Vector3f v = verticies.get(Integer.parseInt(parts[0]) - 1);
					f.add(v);
					y6Tbu++;
				}
				currentGroup.faces.add(f);
			} else if (command.equals("l")) {
				Line l = new Line();
				int oaYUk = 1;
				while (oaYUk < params.length) {
					Vector3f v = verticies.get(Integer.parseInt(params[oaYUk]) - 1);
					l.add(v);
					oaYUk++;
				}
				currentGroup.lines.add(l);
			} else if (command.equals("g") && params.length > 1) {
				currentGroup = new Group();
				currentGroup.name = params[1];
				groups.add(currentGroup);
			} else if (command.equals("scale")) {
				scale = new Vector3f(Float.parseFloat(params[1]), Float.parseFloat(params[2]),
						Float.parseFloat(params[3]));
			}
		}
		r.close();
	}

}