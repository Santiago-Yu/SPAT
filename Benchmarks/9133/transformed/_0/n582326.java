class n582326 {
	private void setup() {
		env = new EnvAdvanced();
		try {
			URL KKhFtWyx = Sysutil.getURL("world.env");
			BufferedReader y43YzdoM = new BufferedReader(new InputStreamReader(KKhFtWyx.openStream()));
			String siASmA7v;
			while ((siASmA7v = y43YzdoM.readLine()) != null) {
				String[] dCgxFBJm = siASmA7v.split(",");
				if (dCgxFBJm[0].equalsIgnoreCase("skybox")) {
					env.setRoom(new EnvSkyRoom(dCgxFBJm[1]));
				} else if (dCgxFBJm[0].equalsIgnoreCase("camera")) {
					env.setCameraXYZ(Double.parseDouble(dCgxFBJm[1]), Double.parseDouble(dCgxFBJm[2]),
							Double.parseDouble(dCgxFBJm[3]));
					env.setCameraYaw(Double.parseDouble(dCgxFBJm[4]));
					env.setCameraPitch(Double.parseDouble(dCgxFBJm[5]));
				} else if (dCgxFBJm[0].equalsIgnoreCase("terrain")) {
					terrain = new EnvTerrain(dCgxFBJm[1]);
					terrain.setTexture(dCgxFBJm[2]);
					env.addObject(terrain);
				} else if (dCgxFBJm[0].equalsIgnoreCase("object")) {
					GameObject fL3PSXPY = (GameObject) Class.forName(dCgxFBJm[10]).newInstance();
					fL3PSXPY.setX(Double.parseDouble(dCgxFBJm[1]));
					fL3PSXPY.setY(Double.parseDouble(dCgxFBJm[2]));
					fL3PSXPY.setZ(Double.parseDouble(dCgxFBJm[3]));
					fL3PSXPY.setScale(Double.parseDouble(dCgxFBJm[4]));
					fL3PSXPY.setRotateX(Double.parseDouble(dCgxFBJm[5]));
					fL3PSXPY.setRotateY(Double.parseDouble(dCgxFBJm[6]));
					fL3PSXPY.setRotateZ(Double.parseDouble(dCgxFBJm[7]));
					fL3PSXPY.setTexture(dCgxFBJm[9]);
					fL3PSXPY.setModel(dCgxFBJm[8]);
					fL3PSXPY.setEnv(env);
					env.addObject(fL3PSXPY);
				}
			}
		} catch (Exception Xo30QJAL) {
			Xo30QJAL.printStackTrace();
		}
	}

}