class n4114529 {
	@Override
	public void save(File LEWIfTJI) {
		actInstance = instance;
		this.setProperty(EsomMapper.PROPERTY_INSTANCE, String.valueOf(actInstance));
		log.debug("instance: " + this.getProperty(EsomMapper.PROPERTY_INSTANCE));
		if (this.getProperty(EsomMapper.PROPERTY_LRN_RADIO_SELECTED) == EsomMapper.RADIO_LOAD_SELECTED) {
			File FGoKbpvP = new File(this.getProperty(EsomMapper.PROPERTY_LRN_FILE));
			if (FGoKbpvP.getParent() != LEWIfTJI.getPath()) {
				log.debug("saving lrn file in save folder " + LEWIfTJI.getPath());
				File ViRENB5Y = new File(
						LEWIfTJI.getAbsolutePath() + File.separator + FGoKbpvP.getName() + String.valueOf(actInstance));
				try {
					FileReader doydjk7Z = new FileReader(FGoKbpvP);
					BufferedReader bR0FOg2q = new BufferedReader(doydjk7Z);
					ViRENB5Y.createNewFile();
					FileWriter qCfvq7jp = new FileWriter(ViRENB5Y);
					BufferedWriter AixdMZtq = new BufferedWriter(qCfvq7jp);
					int Lk4zgegv = 0;
					while ((Lk4zgegv = bR0FOg2q.read()) != -1)
						AixdMZtq.write(Lk4zgegv);
					AixdMZtq.flush();
					AixdMZtq.close();
					bR0FOg2q.close();
					doydjk7Z.close();
				} catch (FileNotFoundException oUgsoio3) {
					log.error("Error while opening lrn sourcefile! Saving wasn't possible!!!");
					oUgsoio3.printStackTrace();
				} catch (IOException MHqltjhZ) {
					log.error("Error while creating lrn destfile! Creating wasn't possible!!!");
					MHqltjhZ.printStackTrace();
				}
				this.setProperty(EsomMapper.PROPERTY_LRN_FILE, ViRENB5Y.getName());
				log.debug("done saving lrn file");
			}
		}
		if (this.getProperty(EsomMapper.PROPERTY_WTS_RADIO_SELECTED) == EsomMapper.RADIO_LOAD_SELECTED) {
			File u263wWJa = new File(this.getProperty(EsomMapper.PROPERTY_WTS_FILE));
			if (u263wWJa.getParent() != LEWIfTJI.getPath()) {
				log.debug("saving wts file in save folder " + LEWIfTJI.getPath());
				File R0Myk4xa = new File(
						LEWIfTJI.getAbsolutePath() + File.separator + u263wWJa.getName() + String.valueOf(actInstance));
				try {
					FileReader onO3HjYZ = new FileReader(u263wWJa);
					BufferedReader YgHauTQI = new BufferedReader(onO3HjYZ);
					R0Myk4xa.createNewFile();
					FileWriter ephW0VFt = new FileWriter(R0Myk4xa);
					BufferedWriter A4CqRgk2 = new BufferedWriter(ephW0VFt);
					int TlFGCvfb = 0;
					while ((TlFGCvfb = YgHauTQI.read()) != -1)
						A4CqRgk2.write(TlFGCvfb);
					A4CqRgk2.flush();
					A4CqRgk2.close();
					YgHauTQI.close();
					onO3HjYZ.close();
				} catch (FileNotFoundException fqItlwNg) {
					log.error("Error while opening wts sourcefile! Saving wasn't possible!!!");
					fqItlwNg.printStackTrace();
				} catch (IOException RO6ij1LL) {
					log.error("Error while creating wts destfile! Creating wasn't possible!!!");
					RO6ij1LL.printStackTrace();
				}
				this.setProperty(EsomMapper.PROPERTY_WTS_FILE, R0Myk4xa.getName());
				log.debug("done saving wts file");
			}
		}
		if (this.getProperty(EsomMapper.PROPERTY_LRN_RADIO_SELECTED) == EsomMapper.RADIO_SELECT_FROM_DATANAV_SELECTED) {
			this.setProperty(EsomMapper.PROPERTY_LRN_FILE, "EsomMapper" + this.actInstance + ".lrn");
			File da82k9iO = new File(LEWIfTJI + File.separator + this.getProperty(EsomMapper.PROPERTY_LRN_FILE));
			try {
				FileWriter Awqbdd7b = new FileWriter(da82k9iO);
				BufferedWriter MmasE4WH = new BufferedWriter(Awqbdd7b);
				MmasE4WH.write("# EsomMapper LRN save file\n");
				MmasE4WH.write("% " + this.inputVectors.getNumRows() + "\n");
				MmasE4WH.write("% " + this.inputVectors.getNumCols() + "\n");
				MmasE4WH.write("% 9");
				for (IColumn ploj9yUe : this.inputVectors.getColumns()) {
					if (ploj9yUe.getType() == IClusterNumber.class)
						MmasE4WH.write("\t2");
					else if (ploj9yUe.getType() == String.class)
						MmasE4WH.write("\t8");
					else
						MmasE4WH.write("\t1");
				}
				MmasE4WH.write("\n% Key");
				for (IColumn pAzc0uL0 : this.inputVectors.getColumns()) {
					MmasE4WH.write("\t" + pAzc0uL0.getLabel());
				}
				MmasE4WH.write("\n");
				int jGA9Hx3T = 0;
				for (Vector<Object> pnGz0Whb : this.inputVectors.getGrid()) {
					MmasE4WH.write(this.inputVectors.getKey(jGA9Hx3T++).toString());
					for (Object ghcCumC7 : pnGz0Whb)
						MmasE4WH.write("\t" + ghcCumC7.toString());
					MmasE4WH.write("\n");
				}
				MmasE4WH.flush();
				Awqbdd7b.flush();
				MmasE4WH.close();
				Awqbdd7b.close();
			} catch (IOException CdYlHzZA) {
				CdYlHzZA.printStackTrace();
			}
			this.setProperty(EsomMapper.PROPERTY_LRN_RADIO_SELECTED, EsomMapper.RADIO_LOAD_SELECTED);
		}
		if (this.getProperty(EsomMapper.PROPERTY_WTS_RADIO_SELECTED) == EsomMapper.RADIO_SELECT_FROM_DATANAV_SELECTED) {
			this.setProperty(EsomMapper.PROPERTY_WTS_FILE, "EsomMapper" + this.actInstance + ".wts");
			MyRetina cQbdReO1 = new MyRetina(this.outputRetina.getNumRows(), this.outputRetina.getNumCols(),
					this.outputRetina.getDim(), this.outputRetina.getDistanceFunction(), this.outputRetina.isToroid());
			for (int ypeWYQdA = 0; ypeWYQdA < this.outputRetina.getNumRows(); ypeWYQdA++) {
				for (int WrEiXMaU = 0; WrEiXMaU < this.outputRetina.getNumCols(); WrEiXMaU++) {
					for (int HPJzqOB1 = 0; HPJzqOB1 < this.outputRetina.getDim(); HPJzqOB1++) {
						cQbdReO1.setNeuron(ypeWYQdA, WrEiXMaU, HPJzqOB1,
								this.outputRetina.getPointasDoubleArray(ypeWYQdA, WrEiXMaU)[HPJzqOB1]);
					}
				}
			}
			EsomIO.writeWTSFile(LEWIfTJI + File.separator + this.getProperty(EsomMapper.PROPERTY_WTS_FILE), cQbdReO1);
			this.setProperty(EsomMapper.PROPERTY_WTS_RADIO_SELECTED, EsomMapper.RADIO_LOAD_SELECTED);
		}
		EsomMapper.instance++;
	}

}