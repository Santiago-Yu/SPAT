class n3791822 {
	public Void doInBackground() {
		setProgress(0);
		for (int UrDorsGX = 0; UrDorsGX < uploadFiles.size(); UrDorsGX++) {
			String pj2FyqvF = uploadFiles.elementAt(UrDorsGX).getFilePath();
			String iYlmLSTA = uploadFiles.elementAt(UrDorsGX).getFileName();
			String Kc2HbZi0 = "Uploading file " + (UrDorsGX + 1) + "/" + uploadFiles.size() + "\n";
			this.publish(Kc2HbZi0);
			try {
				File efkG9dHj = new File(pj2FyqvF);
				FileInputStream WcqHaOi8 = new FileInputStream(efkG9dHj);
				byte[] fg3ng8EZ = new byte[(int) chunkSize];
				int HhWqDXkW = 1;
				int Y62d9YSt = (int) (efkG9dHj.length() / chunkSize);
				if (efkG9dHj.length() % chunkSize > 0) {
					Y62d9YSt++;
				}
				int ylxn1tJX = 0;
				ylxn1tJX = WcqHaOi8.read(fg3ng8EZ);
				while (ylxn1tJX > 0) {
					File cCVqGiGa = File.createTempFile("upl", null, null);
					String u6d4YXio = cCVqGiGa.getPath();
					FileOutputStream dQT6R25d = new FileOutputStream(cCVqGiGa);
					dQT6R25d.write(fg3ng8EZ, 0, ylxn1tJX);
					dQT6R25d.close();
					boolean OKS2fZCI = (HhWqDXkW == Y62d9YSt);
					Kc2HbZi0 = " - Sending chunk " + HhWqDXkW + "/" + Y62d9YSt + ": ";
					this.publish(Kc2HbZi0);
					boolean dRJwwMBI = false;
					int HqlFjSjn = 0;
					while (!dRJwwMBI && HqlFjSjn <= 5) {
						HqlFjSjn++;
						boolean Jpk5nLV7 = upload(u6d4YXio, iYlmLSTA, HhWqDXkW, OKS2fZCI);
						if (Jpk5nLV7) {
							Kc2HbZi0 = "OK\n";
							this.publish(Kc2HbZi0);
							dRJwwMBI = true;
						} else {
							Kc2HbZi0 = "ERROR\n";
							this.publish(Kc2HbZi0);
							dRJwwMBI = false;
						}
					}
					if (!dRJwwMBI) {
						Kc2HbZi0 = "There was an error uploading your files. Please let the pipeline administrator know about this problem. Cut and paste the messages in this box, and supply them.\n";
						this.publish(Kc2HbZi0);
						errorFlag = true;
						return null;
					}
					float CK9RP5M5 = (HhWqDXkW * 100) / (Y62d9YSt);
					float F5wV3rUs = (UrDorsGX * (100 / uploadFiles.size()));
					float Orfn63sB = F5wV3rUs + (CK9RP5M5 / uploadFiles.size());
					setProgress((int) Orfn63sB);
					cCVqGiGa.delete();
					ylxn1tJX = WcqHaOi8.read(fg3ng8EZ);
					HhWqDXkW++;
				}
			} catch (Exception XofhJabv) {
				this.publish(XofhJabv.toString());
			}
		}
		return null;
	}

}