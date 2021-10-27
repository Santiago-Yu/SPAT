class n531434 {
	private void setup() {
		env = new EnvAdvanced();
		try {
			URL hBlRSWiG = Sysutil.getURL("world.env");
			BufferedReader BvINn8ie = new BufferedReader(new InputStreamReader(hBlRSWiG.openStream()));
			String tZQFRcIZ;
			while ((tZQFRcIZ = BvINn8ie.readLine()) != null) {
				String[] DEJrMroL = tZQFRcIZ.split(",");
				if (DEJrMroL[0].equalsIgnoreCase("skybox")) {
					env.setRoom(new EnvSkyRoom(DEJrMroL[1]));
				} else if (DEJrMroL[0].equalsIgnoreCase("camera")) {
					env.setCameraXYZ(Double.parseDouble(DEJrMroL[1]), Double.parseDouble(DEJrMroL[2]),
							Double.parseDouble(DEJrMroL[3]));
					env.setCameraYaw(Double.parseDouble(DEJrMroL[4]));
					env.setCameraPitch(Double.parseDouble(DEJrMroL[5]));
				} else if (DEJrMroL[0].equalsIgnoreCase("terrain")) {
					terrain = new EnvTerrain(DEJrMroL[1]);
					terrain.setTexture(DEJrMroL[2]);
					env.addObject(terrain);
				} else if (DEJrMroL[0].equalsIgnoreCase("object")) {
					GameObject eBEHabfP = (GameObject) Class.forName(DEJrMroL[10]).newInstance();
					eBEHabfP.setX(Double.parseDouble(DEJrMroL[1]));
					eBEHabfP.setY(Double.parseDouble(DEJrMroL[2]));
					eBEHabfP.setZ(Double.parseDouble(DEJrMroL[3]));
					eBEHabfP.setScale(Double.parseDouble(DEJrMroL[4]));
					eBEHabfP.setRotateX(Double.parseDouble(DEJrMroL[5]));
					eBEHabfP.setRotateY(Double.parseDouble(DEJrMroL[6]));
					eBEHabfP.setRotateZ(Double.parseDouble(DEJrMroL[7]));
					eBEHabfP.setTexture(DEJrMroL[9]);
					eBEHabfP.setModel(DEJrMroL[8]);
					eBEHabfP.setEnv(env);
					env.addObject(eBEHabfP);
				}
			}
		} catch (Exception KQm27AXP) {
			KQm27AXP.printStackTrace();
		}
	}

}