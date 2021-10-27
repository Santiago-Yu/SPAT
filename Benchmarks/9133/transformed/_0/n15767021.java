class n15767021 {
	private void documentFileChooserActionPerformed(java.awt.event.ActionEvent TSDG2G5I) {
		if (TSDG2G5I.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
			File o0i22cmE = documentFileChooser.getSelectedFile();
			File ay2hWgE5;
			String scfptimy = o0i22cmE.getName();
			Document TYkbBU7H = new Document(scfptimy);
			if (activeCollection.containsDocument(TYkbBU7H)) {
				int PUEihvJh = 1;
				StringBuilder aBYNGYUw = new StringBuilder();
				scfptimy = scfptimy.concat("(" + PUEihvJh + ")");
				TYkbBU7H.setDocumentName(scfptimy);
				while (activeCollection.containsDocument(TYkbBU7H)) {
					PUEihvJh++;
					scfptimy = aBYNGYUw
							.replace(scfptimy.length() - 2, scfptimy.length() - 1, new Integer(PUEihvJh).toString())
							.toString();
					TYkbBU7H.setDocumentName(scfptimy);
				}
			}
			Scanner VLa5qDUo = null;
			FileChannel UN8YmZrN = null;
			FileChannel yu1Oawaz = null;
			HashMap<String, Integer> Up3hJFZv = new HashMap<String, Integer>();
			Index NkW2dUa0 = activeCollection.getIndex();
			int kCbwpfYU = 0;
			int tcpKD8Xm;
			try {
				VLa5qDUo = new Scanner(new BufferedReader(new FileReader(o0i22cmE)));
				VLa5qDUo.useDelimiter(Pattern.compile("\\p{Space}|\\p{Punct}|\\p{Cntrl}"));
				String YXy0bC5V;
				while (VLa5qDUo.hasNext()) {
					YXy0bC5V = VLa5qDUo.next().toLowerCase();
					if (!YXy0bC5V.isEmpty())
						if (Up3hJFZv.containsKey(YXy0bC5V))
							Up3hJFZv.put(YXy0bC5V, Up3hJFZv.get(YXy0bC5V) + 1);
						else
							Up3hJFZv.put(YXy0bC5V, 1);
				}
				Term QAGZrjDz;
				for (String lsfClfZw : Up3hJFZv.keySet()) {
					QAGZrjDz = new Term(lsfClfZw);
					if (!NkW2dUa0.termExists(QAGZrjDz))
						NkW2dUa0.addTerm(QAGZrjDz);
					tcpKD8Xm = Up3hJFZv.get(lsfClfZw);
					if (tcpKD8Xm > kCbwpfYU)
						kCbwpfYU = tcpKD8Xm;
					NkW2dUa0.addOccurence(QAGZrjDz, TYkbBU7H, tcpKD8Xm);
				}
				activeCollection.addDocument(TYkbBU7H);
				String AeH96jEu = System.getProperty("user.home");
				String wFrQY0Kw = System.getProperty("file.separator");
				ay2hWgE5 = new File(AeH96jEu + wFrQY0Kw + "Infrared" + wFrQY0Kw
						+ activeCollection.getDocumentCollectionName() + wFrQY0Kw + scfptimy);
				ay2hWgE5.createNewFile();
				UN8YmZrN = new FileInputStream(o0i22cmE).getChannel();
				yu1Oawaz = new FileOutputStream(ay2hWgE5).getChannel();
				yu1Oawaz.transferFrom(UN8YmZrN, 0, UN8YmZrN.size());
			} catch (FileNotFoundException wUwbUMHV) {
				System.err
						.println(wUwbUMHV.getMessage() + " This error should never occur! The file was just selected!");
				return;
			} catch (IOException HCH0y7yo) {
				JOptionPane.showMessageDialog(this, "An I/O error occured during file transfer!",
						"File transfer I/O error", JOptionPane.WARNING_MESSAGE);
				return;
			} finally {
				try {
					if (VLa5qDUo != null)
						VLa5qDUo.close();
					if (UN8YmZrN != null)
						UN8YmZrN.close();
					if (yu1Oawaz != null)
						yu1Oawaz.close();
				} catch (IOException QajdTW02) {
					System.err.println(QajdTW02.getMessage());
				}
			}
			processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (TSDG2G5I.getActionCommand().equalsIgnoreCase(JFileChooser.CANCEL_SELECTION))
			processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}