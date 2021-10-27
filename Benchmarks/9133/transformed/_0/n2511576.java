class n2511576 {
	public void doUpdate(String E9RBZiyJ) {
		try {
			final String ASPDrHqy = "http://xnavigator.sourceforge.net/dist/";
			JFrame lpUNttpT = null;
			try {
				JPanel XGhjpdvp = new JPanel();
				XGhjpdvp.setLayout(null);
				XGhjpdvp.setBackground(new java.awt.Color(255, 255, 255));
				XGhjpdvp.setBorder(new TitledBorder(""));
				ClassLoader nvWLDKEw = this.getClass().getClassLoader();
				int ESCTdmoH = 10;
				int NliswVgh = 400;
				int aN0nYRat = 360;
				int SRRiw9Z8 = 50;
				int jcRJ7vf8 = 20;
				int minekYVO = ESCTdmoH;
				I3Label LFW5gO1h = new I3Label("XNavigator Update");
				LFW5gO1h.setBounds(30, minekYVO, 350, 25);
				XGhjpdvp.add(LFW5gO1h);
				ImageIcon Pc7QfeKU = new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(nvWLDKEw.getResource("resources/splash3.jpg")));
				JButton Xz7ceYUX = new JButton(Pc7QfeKU);
				Xz7ceYUX.setBounds(20, minekYVO += 30, 350, 235);
				Xz7ceYUX.setBorder(null);
				Xz7ceYUX.setFocusPainted(false);
				XGhjpdvp.add(Xz7ceYUX);
				JTextPane UceOASaT = new JTextPane();
				UceOASaT.setLayout(null);
				UceOASaT.setBounds(jcRJ7vf8, minekYVO += 235, aN0nYRat, SRRiw9Z8);
				UceOASaT.setBackground(new java.awt.Color(255, 255, 255));
				UceOASaT.setEditable(false);
				UceOASaT.setFocusable(false);
				XGhjpdvp.add(UceOASaT);
				JTextPane Mnme7o1h = new JTextPane();
				Mnme7o1h.setLayout(null);
				Mnme7o1h.setBounds(jcRJ7vf8, minekYVO += SRRiw9Z8, aN0nYRat, SRRiw9Z8);
				Mnme7o1h.setBackground(new java.awt.Color(255, 255, 255));
				Mnme7o1h.setEditable(false);
				Mnme7o1h.setFocusable(false);
				XGhjpdvp.add(Mnme7o1h);
				lpUNttpT = new JFrame();
				lpUNttpT.setUndecorated(false);
				lpUNttpT.setTitle("XNavigator Update");
				lpUNttpT.setSize(400, 430);
				lpUNttpT.getContentPane().add(XGhjpdvp);
				lpUNttpT.setVisible(true);
				lpUNttpT.setEnabled(true);
				lpUNttpT.setResizable(false);
				lpUNttpT.setLocation(300, 150);
				lpUNttpT.addWindowListener(this);
				XGhjpdvp.repaint();
				UceOASaT.setText(i18n.getString("UPDATE_CHECK_INSTANCES"));
				String BCx0ZntT = i18n.getString("UPDATE_INSTANCES");
				JLabel tjOMDHa4 = new JLabel(
						"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: bold;}--></style></head><body><span class=\"Stil2\">XNavigator Update</span></body></html>");
				JLabel jizLrtjI = new JLabel(
						"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: normal;}--></style></head><body><span class=\"Stil2\">"
								+ "<br>" + BCx0ZntT + " " + "</span></body></html>");
				Object[] OAJdAy3m = { tjOMDHa4, jizLrtjI };
				Object[] McZd8gXc = { i18n.getString("CONTINUE"), i18n.getString("CANCEL") };
				int aZyQXVZL = JOptionPane.showOptionDialog(null, OAJdAy3m, "Update", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, McZd8gXc, McZd8gXc[0]);
				if (aZyQXVZL == 0) {
				} else {
					lpUNttpT.dispose();
					return;
				}
				UceOASaT.setText(i18n.getString("UPDATE_CHECK_ENVIRONMENT"));
				if ((new File(".project")).exists()) {
					Object[] j4s2Z5Vb = {
							"Im Eclipse Projekt solltest Du besser die neueste Version aus dem SVN ziehen -Arne-",
							"Update abgebrochen" };
					JOptionPane.showMessageDialog(null, j4s2Z5Vb, "Update Error", JOptionPane.ERROR_MESSAGE);
					lpUNttpT.dispose();
					return;
				}
				Object[] cfRaew3h = { i18n.getString("UPDATE_WARNING") };
				Object[] S9iPH3OI = { i18n.getString("CONTINUE"), i18n.getString("CANCEL") };
				int ZCBCUHkm = JOptionPane.showOptionDialog(null, cfRaew3h, i18n.getString("WARNING"),
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, S9iPH3OI, S9iPH3OI[0]);
				if (ZCBCUHkm == 1) {
					lpUNttpT.dispose();
					return;
				}
				lpUNttpT.requestFocus();
				lpUNttpT.requestFocusInWindow();
				UceOASaT.setText(i18n.getString("UPDATE_DOWNLOADING"));
				String kbFJTqmJ = "XNavigator-" + E9RBZiyJ + ".zip";
				URL otBbVBBO = new URL(ASPDrHqy + kbFJTqmJ);
				URLConnection h27nCRN4 = otBbVBBO.openConnection();
				int Cd3yixrg = h27nCRN4.getContentLength();
				String tUpv3BO6 = otBbVBBO.toString();
				Mnme7o1h.setText("Download " + tUpv3BO6 + " ... 0%");
				java.io.BufferedInputStream u8l8gzrV = new java.io.BufferedInputStream(otBbVBBO.openStream());
				java.io.FileOutputStream sz04s5bq = new java.io.FileOutputStream(kbFJTqmJ);
				java.io.BufferedOutputStream pX9am90D = new BufferedOutputStream(sz04s5bq, 1024);
				int KRXYW64T = 1024;
				byte R95PUC9b[] = new byte[KRXYW64T];
				int NXwnIupK = 0;
				int fvEMClTY = 0;
				int nO6RQtP3 = 0;
				while ((NXwnIupK = u8l8gzrV.read(R95PUC9b, 0, KRXYW64T)) > 0) {
					pX9am90D.write(R95PUC9b, 0, NXwnIupK);
					fvEMClTY += NXwnIupK;
					int XDZdzwza = (100 * fvEMClTY) / Cd3yixrg;
					if (XDZdzwza > nO6RQtP3) {
						Mnme7o1h.setText("Download " + tUpv3BO6 + " ... " + XDZdzwza + "%");
						nO6RQtP3 = XDZdzwza;
					}
				}
				pX9am90D.close();
				sz04s5bq.close();
				u8l8gzrV.close();
				Mnme7o1h.setText("Download " + otBbVBBO.toString() + " ... ok.");
				UceOASaT.setText(i18n.getString("UPDATE_EXTRACTING"));
				boolean AoBiF912 = deleteFiles(new File("./lib"), false);
				if (!AoBiF912) {
					lpUNttpT.dispose();
					return;
				}
				extractZipFile(kbFJTqmJ, Mnme7o1h);
				Mnme7o1h.setText(i18n.getString("UPDATE_COMPLETE"));
				Object[] T9gpcXRB = { i18n.getString("UPDATE_COMPLETE") };
				Object[] BJZjPqNa = { i18n.getString("OK") };
				JOptionPane.showOptionDialog(null, T9gpcXRB, "Success", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, BJZjPqNa, BJZjPqNa[0]);
				System.exit(0);
			} catch (Exception PdwbKdGA) {
				PdwbKdGA.printStackTrace();
				String hqepOFxa = "";
				String cDHXbnnW = "";
				hqepOFxa = i18n.getString("UPDATE_FAILED");
				cDHXbnnW = "<a href='" + ASPDrHqy + "'>" + ASPDrHqy + "</a>";
				JLabel qv4MaRzk = new JLabel(
						"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: normal;}--></style></head><body><span class=\"Stil2\">"
								+ "<br>" + hqepOFxa + " " + "</span></body></html>");
				JLabel iwHHX33D = new JLabel(
						"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: normal;}--></style></head><body><span class=\"Stil2\">"
								+ cDHXbnnW + "<br>" + "</span></body></html>");
				JLabel kuWdAfWj = new JLabel(
						"<html><head><style type=\"text/css\"><!--.Stil2 {font-size: 10px;font-weight: normal;}--></style></head><body><span class=\"Stil2\">"
								+ E9RBZiyJ + "</span></body></html>");
				iwHHX33D.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				iwHHX33D.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent LVmnh3te) {
						if (LVmnh3te.getClickCount() > 0) {
							try {
								javax.jnlp.BasicService TRTAhR3S;
								TRTAhR3S = (javax.jnlp.BasicService) javax.jnlp.ServiceManager
										.lookup("javax.jnlp.BasicService");
								TRTAhR3S.showDocument(new URL(ASPDrHqy));
							} catch (Exception HFLQeCMe) {
								HFLQeCMe.printStackTrace();
								try {
									Runtime.getRuntime().exec("cmd.exe /c start " + ASPDrHqy);
								} catch (IOException RV26rpn7) {
									RV26rpn7.printStackTrace();
								}
							}
						}
					}
				});
				Object[] gK3rhYeu = { qv4MaRzk, iwHHX33D, kuWdAfWj };
				Object[] vw7kxBYF = { i18n.getString("OK") };
				lpUNttpT.dispose();
				JOptionPane.showOptionDialog(null, gK3rhYeu, "Error", JOptionPane.DEFAULT_OPTION,
						JOptionPane.ERROR_MESSAGE, null, vw7kxBYF, vw7kxBYF[0]);
			}
			lpUNttpT.setVisible(false);
			lpUNttpT.dispose();
		} catch (Exception X3mcNvWg) {
			X3mcNvWg.printStackTrace();
		}
	}

}