class n793122 {
	public void actionPerformed(ActionEvent tQlqMswP) {
		String m9R7Q4VR, A7Be7Pk5;
		String GthD0tCF, pTDWf41d;
		String Ek5CMLCH = "";
		buttonPressed = true;
		char S1jRG34j;
		int e0gLyaY1;
		int mMLkZ0EC;
		int EJ2c4Js5 = displayNum;
		for (int S58daWr6 = 0; S58daWr6 < 10; S58daWr6++) {
			if (tQlqMswP.getSource() == imageButtons[S58daWr6]) {
				if (rePrintAnswer)
					printAnswer();
				print.setVisible(true);
				selectTerm.setVisible(true);
				displayNum = S58daWr6;
				textArea2.setCaretPosition(textArea2.getText().length() - 1);
				e0gLyaY1 = textArea2.getText().indexOf("#" + (S58daWr6 + 1));
				if (e0gLyaY1 != -1)
					textArea2.setCaretPosition(e0gLyaY1);
				repaint();
			}
		}
		if (tQlqMswP.getSource() == print) {
			if (textArea2.getText().charAt(0) != '#')
				printAnswer();
			String oidml0un = textArea2.getText();
			int U7gA4wR8 = oidml0un.indexOf("#" + (displayNum + 1));
			U7gA4wR8 = oidml0un.indexOf("\n", U7gA4wR8);
			U7gA4wR8++;
			int SmMHVDQ3 = oidml0un.indexOf("\n---------", U7gA4wR8);
			oidml0un = oidml0un.substring(U7gA4wR8, SmMHVDQ3);
			String Ms9xveLv = "";
			if (term.getSelectedItem() == "Spring")
				Ms9xveLv = "SP";
			else if (term.getSelectedItem() == "Summer")
				Ms9xveLv = "SU";
			else
				Ms9xveLv = "FL";
			String GsNCzXl3 = getCodeBase().toString() + "schedule.cgi?term=" + Ms9xveLv + "&data="
					+ URLEncoder.encode(oidml0un);
			try {
				AppletContext LLKQeWnO = getAppletContext();
				URL FelYH6Qb = new URL(GsNCzXl3);
				LLKQeWnO.showDocument(FelYH6Qb, "_blank");
			} catch (MalformedURLException DutCry7S) {
			}
		}
		if (tQlqMswP.getSource() == webSite) {
			String uOHOmysF;
			if (term.getSelectedItem() == "Spring")
				uOHOmysF = "SP";
			else if (term.getSelectedItem() == "Summer")
				uOHOmysF = "SU";
			else
				uOHOmysF = "FL";
			String ftQYXmz6 = courseNum.getText().toUpperCase();
			String NQuJkE2v = "http://sis450.berkeley.edu:4200/OSOC/osoc?p_term=" + uOHOmysF + "&p_deptname="
					+ URLEncoder.encode(lst.getSelectedItem().toString()) + "&p_course=" + ftQYXmz6;
			try {
				AppletContext PiMILPr4 = getAppletContext();
				URL EwbyQbLV = new URL(NQuJkE2v);
				PiMILPr4.showDocument(EwbyQbLV, "_blank");
			} catch (MalformedURLException Lcu0UdyB) {
			}
		}
		if (tQlqMswP.getSource() == loadButton) {
			printSign("Loading...");
			String LME0vLyt = idField.getText();
			LME0vLyt = LME0vLyt.replace(' ', '_');
			String LPLZ1Icl = readURL(LME0vLyt);
			if (!publicSign.equals("Error loading.")) {
				textArea1.setText(LPLZ1Icl);
				LME0vLyt += ".2";
				LPLZ1Icl = readURL(LME0vLyt);
				absorb(LPLZ1Icl);
				printAnswer();
				for (int IWHApTPX = 0; IWHApTPX < 10; IWHApTPX++) {
					if (answer[IWHApTPX].gap != -1 && answer[IWHApTPX].gap != 9999 && answer[IWHApTPX].gap != 10000) {
						imageButtons[IWHApTPX].setVisible(true);
					} else
						imageButtons[IWHApTPX].setVisible(false);
				}
				if (!imageButtons[0].isVisible()) {
					print.setVisible(false);
					selectTerm.setVisible(false);
				} else {
					print.setVisible(true);
					selectTerm.setVisible(true);
				}
				printSign("Load complete.");
			}
			displayNum = 0;
			repaint();
		}
		if (tQlqMswP.getSource() == saveButton) {
			String AkmLLtww = idField.getText();
			AkmLLtww = AkmLLtww.replace(' ', '_');
			printSign("Saving...");
			writeURL(AkmLLtww, 1);
			printSign("Saving......");
			AkmLLtww += ".2";
			writeURL(AkmLLtww, 2);
			printSign("Save complete.");
		}
		if (tQlqMswP.getSource() == instructions) {
			showInstructions();
		}
		if (tQlqMswP.getSource() == net) {
			drawWarning = false;
			String jjzUjxz4 = "";
			String ayiACBSp = "";
			String EQsoBgDb;
			String hf97hGsv = "";
			textArea2.setText("Retrieving Data...");
			try {
				String AsWkjTmc;
				if (term.getSelectedItem() == "Spring")
					AsWkjTmc = "SP";
				else if (term.getSelectedItem() == "Summer")
					AsWkjTmc = "SU";
				else
					AsWkjTmc = "FL";
				String lCXBMEa9 = courseNum.getText().toUpperCase();
				Ek5CMLCH = lst.getSelectedItem().toString();
				{
					hf97hGsv = "http://sis450.berkeley.edu:4200/OSOC/osoc?p_term=" + AsWkjTmc + "&p_deptname="
							+ URLEncoder.encode(Ek5CMLCH) + "&p_course=" + lCXBMEa9;
					try {
						URL o8bSCvky = new URL(getCodeBase().toString() + "getURL.cgi");
						URLConnection CszrpJc3 = o8bSCvky.openConnection();
						CszrpJc3.setDoOutput(true);
						CszrpJc3.setDoInput(true);
						CszrpJc3.setUseCaches(false);
						CszrpJc3.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
						DataOutputStream MqQxjmYH = new DataOutputStream(CszrpJc3.getOutputStream());
						String AGufrEFn = "url=" + URLEncoder.encode(hf97hGsv);
						MqQxjmYH.writeBytes(AGufrEFn);
						MqQxjmYH.flush();
						DataInputStream RKxNbCRu = new DataInputStream(CszrpJc3.getInputStream());
						String IMRaTpji;
						while ((IMRaTpji = RKxNbCRu.readLine()) != null) {
						}
						RKxNbCRu.close();
					} catch (IOException PWKIBQF3) {
					}
				}
				URL SWPtfoPf = new URL(this.getCodeBase(), "classData.txt");
				URLConnection P6J2MzzM = SWPtfoPf.openConnection();
				StringBuffer uyf3orIx = new StringBuffer("");
				DataInputStream Uhqknq3C = new DataInputStream(new BufferedInputStream(P6J2MzzM.getInputStream()));
				while ((jjzUjxz4 = Uhqknq3C.readLine()) != null) {
					uyf3orIx.append(jjzUjxz4);
				}
				ayiACBSp = uyf3orIx.toString();
				Uhqknq3C.close();
			} catch (IOException P0JiROtH) {
			}
			String HoyCibO3 = (parseData(ayiACBSp, false));
			if (HoyCibO3.equals("-1"))
				HoyCibO3 = parseData(ayiACBSp, true);
			if (HoyCibO3.equals("\n")) {
				textArea2.append("\nNO DATA FOUND \n(" + hf97hGsv + ")");
			} else
				textArea1.append(HoyCibO3);
			repaint();
		}
		badInput = false;
		if (tQlqMswP.getSource() == button1) {
			if (t != null && t.isAlive()) {
				t.stop();
				epilogue();
				return;
			}
			displayNum = 0;
			textArea2.setCaretPosition(0);
			for (int x3Q0HQ4s = 0; x3Q0HQ4s < 30; x3Q0HQ4s++)
				for (int AFTzeJJx = 0; AFTzeJJx < 20; AFTzeJJx++) {
					matrix[x3Q0HQ4s][AFTzeJJx] = new entry();
					matrix[x3Q0HQ4s][AFTzeJJx].time = new Time[4];
					for (int DGcyxIiP = 0; DGcyxIiP < 4; DGcyxIiP++) {
						matrix[x3Q0HQ4s][AFTzeJJx].time[DGcyxIiP] = new Time();
						matrix[x3Q0HQ4s][AFTzeJJx].time[DGcyxIiP].from = 0;
					}
				}
			val = new entry[30];
			for (int Jw9EAeec = 0; Jw9EAeec < 30; Jw9EAeec++) {
				val[Jw9EAeec] = new entry();
				val[Jw9EAeec].time = new Time[4];
				for (int LC6qtLXB = 0; LC6qtLXB < 4; LC6qtLXB++) {
					val[Jw9EAeec].time[LC6qtLXB] = new Time();
					val[Jw9EAeec].time[LC6qtLXB].from = 0;
				}
			}
			oldPercentDone = -5;
			oldAmountDone = -1 * PRINTINTERVAL;
			percentDone = 0;
			amountDone = 0;
			drawWarning = false;
			errorMessage = "";
			String AuUT41tz = textArea1.getText();
			if (AuUT41tz.toUpperCase().indexOf("OR:") == -1)
				containsOR = false;
			else
				containsOR = true;
			AuUT41tz = removeOR(AuUT41tz.toUpperCase());
			StringTokenizer FKUzX8pm = new StringTokenizer(AuUT41tz, "\n");
			clss = -1;
			timeEntry = -1;
			boolean K3ipEg8i = false;
			while (FKUzX8pm.hasMoreTokens()) {
				m9R7Q4VR = FKUzX8pm.nextToken().toString();
				if (m9R7Q4VR.equals(""))
					break;
				else
					S1jRG34j = m9R7Q4VR.charAt(0);
				if (S1jRG34j == '0') {
					badInput = true;
					repaint();
					break;
				}
				if (S1jRG34j >= '1' && S1jRG34j <= '9') {
					K3ipEg8i = false;
					timeEntry++;
					if (timeEntry == 30) {
						rePrintAnswer = true;
						textArea2.setText("Error: Exceeded 30 time entries per class.");
						badInput = true;
						repaint();
						return;
					}
					nextTime = -1;
					StringTokenizer aDkO3HKa = new StringTokenizer(m9R7Q4VR, ",");
					while (aDkO3HKa.hasMoreTokens()) {
						String zeZ4qLrp;
						String Y9kpKN5F;
						int KdBtIPwW, iLMpl6dk, eGjfBQnx;
						nextTime++;
						if (nextTime == 4) {
							rePrintAnswer = true;
							textArea2.setText("Error: Exceeded 4 time intervals per entry!");
							badInput = true;
							repaint();
							return;
						}
						StringTokenizer TDzzr4fB = new StringTokenizer(aDkO3HKa.nextToken());
						zeZ4qLrp = TDzzr4fB.nextToken().toString();
						Y9kpKN5F = "";
						KdBtIPwW = 0;
						if (zeZ4qLrp.equals(""))
							break;
						while (zeZ4qLrp.charAt(KdBtIPwW) != '-') {
							Y9kpKN5F += zeZ4qLrp.charAt(KdBtIPwW);
							KdBtIPwW++;
							if (KdBtIPwW >= zeZ4qLrp.length()) {
								rePrintAnswer = true;
								textArea2.setText("Error: There should be no space before hyphens.");
								badInput = true;
								repaint();
								return;
							}
						}
						try {
							iLMpl6dk = Integer.parseInt(Y9kpKN5F);
						} catch (NumberFormatException Vo8ZSQpp) {
							rePrintAnswer = true;
							textArea2.setText("Error: There should be no a/p sign after FROM_TIME.");
							badInput = true;
							repaint();
							return;
						}
						KdBtIPwW++;
						Y9kpKN5F = "";
						if (KdBtIPwW >= zeZ4qLrp.length()) {
							badInput = true;
							repaint();
							rePrintAnswer = true;
							textArea2.setText("Error: am/pm sign missing??");
							return;
						}
						while (zeZ4qLrp.charAt(KdBtIPwW) >= '0' && zeZ4qLrp.charAt(KdBtIPwW) <= '9') {
							Y9kpKN5F += zeZ4qLrp.charAt(KdBtIPwW);
							KdBtIPwW++;
							if (KdBtIPwW >= zeZ4qLrp.length()) {
								badInput = true;
								repaint();
								rePrintAnswer = true;
								textArea2.setText("Error: am/pm sign missing??");
								return;
							}
						}
						eGjfBQnx = Integer.parseInt(Y9kpKN5F);
						if (zeZ4qLrp.charAt(KdBtIPwW) == 'a' || zeZ4qLrp.charAt(KdBtIPwW) == 'A') {
						} else {
							if (isLesse(iLMpl6dk, eGjfBQnx) && !timeEq(eGjfBQnx, 1200)) {
								if (String.valueOf(iLMpl6dk).length() == 4 || String.valueOf(iLMpl6dk).length() == 3) {
									iLMpl6dk += 1200;
								} else
									iLMpl6dk += 12;
							}
							if (!timeEq(eGjfBQnx, 1200)) {
								if (String.valueOf(eGjfBQnx).length() == 4 || String.valueOf(eGjfBQnx).length() == 3) {
									eGjfBQnx += 1200;
								} else
									eGjfBQnx += 12;
							}
						}
						if (String.valueOf(iLMpl6dk).length() == 2 || String.valueOf(iLMpl6dk).length() == 1)
							iLMpl6dk *= 100;
						if (String.valueOf(eGjfBQnx).length() == 2 || String.valueOf(eGjfBQnx).length() == 1)
							eGjfBQnx *= 100;
						matrix[timeEntry][clss].time[nextTime].from = iLMpl6dk;
						matrix[timeEntry][clss].time[nextTime].to = eGjfBQnx;
						if (TDzzr4fB.hasMoreTokens())
							A7Be7Pk5 = TDzzr4fB.nextToken().toString();
						else {
							rePrintAnswer = true;
							textArea2.setText("Error: days not specified?");
							badInput = true;
							repaint();
							return;
						}
						if (A7Be7Pk5.equals(""))
							return;
						if (A7Be7Pk5.indexOf("M") != -1 || A7Be7Pk5.indexOf("m") != -1)
							matrix[timeEntry][clss].time[nextTime].m = 1;
						if (A7Be7Pk5.indexOf("TU") != -1 || A7Be7Pk5.indexOf("Tu") != -1
								|| A7Be7Pk5.indexOf("tu") != -1)
							matrix[timeEntry][clss].time[nextTime].tu = 1;
						if (A7Be7Pk5.indexOf("W") != -1 || A7Be7Pk5.indexOf("w") != -1)
							matrix[timeEntry][clss].time[nextTime].w = 1;
						if (A7Be7Pk5.indexOf("TH") != -1 || A7Be7Pk5.indexOf("Th") != -1
								|| A7Be7Pk5.indexOf("th") != -1)
							matrix[timeEntry][clss].time[nextTime].th = 1;
						if (A7Be7Pk5.indexOf("F") != -1 || A7Be7Pk5.indexOf("f") != -1)
							matrix[timeEntry][clss].time[nextTime].f = 1;
					}
				} else {
					if (K3ipEg8i)
						clss--;
					clss++;
					if (clss == 20) {
						rePrintAnswer = true;
						textArea2.setText("Error: No more than 20 class entries!");
						badInput = true;
						repaint();
						return;
					}
					timeEntry = -1;
					m9R7Q4VR = m9R7Q4VR.trim();
					for (int LFLiyj4p = 0; LFLiyj4p < 30; LFLiyj4p++)
						matrix[LFLiyj4p][clss].name = m9R7Q4VR;
					K3ipEg8i = true;
				}
			}
			for (int hTwVCy7T = 0; hTwVCy7T < 30; hTwVCy7T++) {
				for (int DXmHiUvP = 0; DXmHiUvP < 4; DXmHiUvP++) {
					val[hTwVCy7T].time[DXmHiUvP].from = 0;
				}
			}
			for (int NBu69dEI = 0; NBu69dEI < 10; NBu69dEI++) {
				beat10[NBu69dEI] = 10000;
				answer[NBu69dEI].gap = 10000;
				for (int mIuCbp6n = 0; mIuCbp6n < 30; mIuCbp6n++)
					answer[NBu69dEI].classes[mIuCbp6n].name = "";
			}
			time = 0;
			calcTotal = 0;
			int tB4wz3NO = 0;
			calculateTotalPercent(0, "\n");
			amountToReach = calcTotal;
			button1.setLabel("...HALT GENERATION...");
			printWarn();
			if (t != null && t.isAlive())
				t.stop();
			t = new Thread(this, "Generator");
			t.start();
		}
	}

}