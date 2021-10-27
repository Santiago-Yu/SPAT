class n17972560 {
	private void folderFileChooserActionPerformed(java.awt.event.ActionEvent sSBPzuFJ) {
		if (sSBPzuFJ.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
			File QeHkVxJN = folderFileChooser.getSelectedFile();
			File XGIqJUVR;
			String XoNtUnfQ;
			Document hKF6skXt;
			StringBuilder hGmYIOzB = new StringBuilder();
			int YrshVT09;
			String nhEMTeb6;
			Term Qi8ONDUe;
			String oV9yKdIe;
			String VUvUjcuM;
			int rd7yUhjP;
			ArrayList<File> XrB6OT4K = new ArrayList<File>();
			ArrayList<File> cn20ZTxU = new ArrayList<File>();
			HashSet<File> vWybKamw = new HashSet<File>();
			FileNameExtensionFilter biqPOt5q = new FileNameExtensionFilter("Text Files", "txt");
			Scanner ITjYolID = null;
			FileChannel sebBx6Yb = null;
			FileChannel CYiJal8J = null;
			HashMap<String, Integer> r4Ydn0iQ = null;
			Index QyOnmV52 = activeCollection.getIndex();
			int CUoI3MLY;
			int JgrY5fkv;
			for (File NhsZtRNI : QeHkVxJN.listFiles())
				if (biqPOt5q.accept(NhsZtRNI))
					XrB6OT4K.add(NhsZtRNI);
				else
					cn20ZTxU.add(NhsZtRNI);
			for (File Dt6vgZWD : XrB6OT4K) {
				XoNtUnfQ = Dt6vgZWD.getName();
				hKF6skXt = new Document(XoNtUnfQ);
				if (activeCollection.containsDocument(hKF6skXt)) {
					YrshVT09 = 1;
					XoNtUnfQ = XoNtUnfQ.concat("(" + YrshVT09 + ")");
					hKF6skXt.setDocumentName(XoNtUnfQ);
					while (activeCollection.containsDocument(hKF6skXt)) {
						YrshVT09++;
						XoNtUnfQ = hGmYIOzB
								.replace(XoNtUnfQ.length() - 2, XoNtUnfQ.length() - 1, new Integer(YrshVT09).toString())
								.toString();
						hKF6skXt.setDocumentName(XoNtUnfQ);
					}
				}
				r4Ydn0iQ = new HashMap<String, Integer>();
				try {
					ITjYolID = new Scanner(new BufferedReader(new FileReader(Dt6vgZWD)));
					ITjYolID.useDelimiter(Pattern.compile("\\p{Space}|\\p{Punct}|\\p{Cntrl}"));
					while (ITjYolID.hasNext()) {
						nhEMTeb6 = ITjYolID.next().toLowerCase();
						if (!nhEMTeb6.isEmpty())
							if (r4Ydn0iQ.containsKey(nhEMTeb6))
								r4Ydn0iQ.put(nhEMTeb6, r4Ydn0iQ.get(nhEMTeb6) + 1);
							else
								r4Ydn0iQ.put(nhEMTeb6, 1);
					}
					CUoI3MLY = 0;
					for (String T8feIszo : r4Ydn0iQ.keySet()) {
						Qi8ONDUe = new Term(T8feIszo);
						if (!QyOnmV52.termExists(Qi8ONDUe))
							QyOnmV52.addTerm(Qi8ONDUe);
						JgrY5fkv = r4Ydn0iQ.get(T8feIszo);
						if (JgrY5fkv > CUoI3MLY)
							CUoI3MLY = JgrY5fkv;
						QyOnmV52.addOccurence(Qi8ONDUe, hKF6skXt, JgrY5fkv);
					}
					hKF6skXt.setTermMaxFrequency(CUoI3MLY);
					activeCollection.addDocument(hKF6skXt);
					oV9yKdIe = System.getProperty("user.home");
					VUvUjcuM = System.getProperty("file.separator");
					XGIqJUVR = new File(oV9yKdIe + VUvUjcuM + "Infrared" + VUvUjcuM
							+ activeCollection.getDocumentCollectionName() + VUvUjcuM + XoNtUnfQ);
					XGIqJUVR.createNewFile();
					sebBx6Yb = new FileInputStream(Dt6vgZWD).getChannel();
					CYiJal8J = new FileOutputStream(XGIqJUVR).getChannel();
					CYiJal8J.transferFrom(sebBx6Yb, 0, sebBx6Yb.size());
				} catch (FileNotFoundException Rm8SfpcV) {
					System.err.println(
							Rm8SfpcV.getMessage() + " This error should never occur! The file was just selected!");
					return;
				} catch (IOException ksr9OMhF) {
					rd7yUhjP = JOptionPane.showConfirmDialog(this,
							"A file insertion has failed. If you want it to ignore this"
									+ "file, press YES, else press NO to repeat the insertion",
							"FileInsertionFailure", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (rd7yUhjP == JOptionPane.NO_OPTION) {
						activeCollection.removeDocument(hKF6skXt);
						for (String BnVKRQAn : r4Ydn0iQ.keySet()) {
							QyOnmV52.removeAllOccurences(new Term(BnVKRQAn), hKF6skXt);
						}
						XrB6OT4K.add(Dt6vgZWD);
					} else
						vWybKamw.add(Dt6vgZWD);
				} finally {
					try {
						if (ITjYolID != null)
							ITjYolID.close();
						if (sebBx6Yb != null)
							sebBx6Yb.close();
						if (CYiJal8J != null)
							CYiJal8J.close();
					} catch (IOException yXmzPP6E) {
						System.err.println(yXmzPP6E.getMessage());
					}
				}
			}
			if (vWybKamw.size() > 0) {
				IgnoredFilesDialog aWwjNnrn = new IgnoredFilesDialog(vWybKamw, this);
				aWwjNnrn.setVisible(true);
			}
			processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (sSBPzuFJ.getActionCommand().equalsIgnoreCase(JFileChooser.CANCEL_SELECTION))
			processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}