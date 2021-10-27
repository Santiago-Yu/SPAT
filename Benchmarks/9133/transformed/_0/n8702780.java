class n8702780 {
	final void saveProject(Project vyKABTmF, final File tq322kOS) {
		if (projectsList.contains(vyKABTmF)) {
			if (vyKABTmF.isDirty() || !tq322kOS.getParentFile().equals(workspaceDirectory)) {
				try {
					if (!tq322kOS.exists()) {
						if (!tq322kOS.createNewFile())
							throw new IOException("cannot create file " + tq322kOS.getAbsolutePath());
					}
					File ALTxghba = File.createTempFile("JFPSM", ".tmp");
					ZipOutputStream AfpgDTeC = new ZipOutputStream(
							new BufferedOutputStream(new FileOutputStream(tq322kOS)));
					AfpgDTeC.setMethod(ZipOutputStream.DEFLATED);
					ZipEntry Y1eqx5Au = new ZipEntry("project.xml");
					Y1eqx5Au.setMethod(ZipEntry.DEFLATED);
					AfpgDTeC.putNextEntry(Y1eqx5Au);
					CustomXMLEncoder KUDdaRnH = new CustomXMLEncoder(
							new BufferedOutputStream(new FileOutputStream(ALTxghba)));
					KUDdaRnH.writeObject(vyKABTmF);
					KUDdaRnH.close();
					int y72RgakS;
					byte[] KfE2NGXs = new byte[1024];
					FileInputStream fyViScmW = new FileInputStream(ALTxghba);
					while ((y72RgakS = fyViScmW.read(KfE2NGXs)) != -1)
						AfpgDTeC.write(KfE2NGXs, 0, y72RgakS);
					fyViScmW.close();
					ZipEntry fMj14cKv;
					String RwPBUHXj;
					for (FloorSet rV1X5Im2 : vyKABTmF.getLevelSet().getFloorSetsList())
						for (Floor ZJbjvpFE : rV1X5Im2.getFloorsList()) {
							RwPBUHXj = "levelset/" + rV1X5Im2.getName() + "/" + ZJbjvpFE.getName() + "/";
							for (MapType uzR6dEXf : MapType.values()) {
								fMj14cKv = new ZipEntry(RwPBUHXj + uzR6dEXf.getFilename());
								fMj14cKv.setMethod(ZipEntry.DEFLATED);
								AfpgDTeC.putNextEntry(fMj14cKv);
								ImageIO.write(ZJbjvpFE.getMap(uzR6dEXf).getImage(), "png", AfpgDTeC);
							}
						}
					final String EMv0UmI1 = "tileset/";
					for (Tile cLiS5Yqg : vyKABTmF.getTileSet().getTilesList())
						for (int BqwgWtch = 0; BqwgWtch < cLiS5Yqg.getMaxTextureCount(); BqwgWtch++)
							if (cLiS5Yqg.getTexture(BqwgWtch) != null) {
								fMj14cKv = new ZipEntry(EMv0UmI1 + cLiS5Yqg.getName() + BqwgWtch + ".png");
								fMj14cKv.setMethod(ZipEntry.DEFLATED);
								AfpgDTeC.putNextEntry(fMj14cKv);
								ImageIO.write(cLiS5Yqg.getTexture(BqwgWtch), "png", AfpgDTeC);
							}
					AfpgDTeC.close();
					ALTxghba.delete();
				} catch (IOException ipNsyXDc) {
					throw new RuntimeException("The project " + vyKABTmF.getName() + " cannot be saved!", ipNsyXDc);
				}
			}
		} else
			throw new IllegalArgumentException(
					"The project " + vyKABTmF.getName() + " is not handled by this project set!");
	}

}