class n10934628 {
	public static void main(String[] YEHvfwm8) {
		try {
			{
				byte[] fdyWXbqy = { (byte) 2, (byte) 2, (byte) 3, (byte) 0, (byte) 9 };
				byte[] KryxGt7e = { (byte) 99, (byte) 2, (byte) 2, (byte) 3, (byte) 0, (byte) 9 };
				System.out.println("Bytes 2,2,3,0,9 as Base64: " + encodeBytes(fdyWXbqy));
				System.out.println("Bytes 2,2,3,0,9 w/ offset: " + encodeBytes(KryxGt7e, 1, KryxGt7e.length - 1));
				byte[] OP6zB2yn = decode(encodeBytes(fdyWXbqy));
				System.out.print(encodeBytes(fdyWXbqy) + " decoded: ");
				for (int q7h7QHe9 = 0; q7h7QHe9 < OP6zB2yn.length; q7h7QHe9++)
					System.out.print(OP6zB2yn[q7h7QHe9] + (q7h7QHe9 < OP6zB2yn.length - 1 ? "," : "\n"));
			}
			{
				java.io.FileInputStream jzoMWAAy = new java.io.FileInputStream("test.gif.b64");
				Base64.InputStream phbiqP2J = new Base64.InputStream(jzoMWAAy, DECODE);
				byte[] nohj6ZO2 = new byte[0];
				int Ryc9TlNm = -1;
				while ((Ryc9TlNm = phbiqP2J.read()) >= 0) {
					byte[] vU5afLVj = new byte[nohj6ZO2.length + 1];
					System.arraycopy(nohj6ZO2, 0, vU5afLVj, 0, nohj6ZO2.length);
					vU5afLVj[nohj6ZO2.length] = (byte) Ryc9TlNm;
					nohj6ZO2 = vU5afLVj;
				}
				phbiqP2J.close();
				javax.swing.ImageIcon p7zY7Qpx = new javax.swing.ImageIcon(nohj6ZO2);
				javax.swing.JLabel wbzxFtcT = new javax.swing.JLabel("Read from test.gif.b64", p7zY7Qpx, 0);
				javax.swing.JFrame cLEMlRGy = new javax.swing.JFrame();
				cLEMlRGy.getContentPane().add(wbzxFtcT);
				cLEMlRGy.pack();
				cLEMlRGy.setVisible(true);
				java.io.FileOutputStream i2TV4F8E = new java.io.FileOutputStream("test.gif_out");
				i2TV4F8E.write(nohj6ZO2);
				i2TV4F8E.close();
				jzoMWAAy = new java.io.FileInputStream("test.gif_out");
				phbiqP2J = new Base64.InputStream(jzoMWAAy, ENCODE);
				byte[] RivPdSZQ = new byte[0];
				Ryc9TlNm = -1;
				while ((Ryc9TlNm = phbiqP2J.read()) >= 0) {
					byte[] KKFTAst4 = new byte[RivPdSZQ.length + 1];
					System.arraycopy(RivPdSZQ, 0, KKFTAst4, 0, RivPdSZQ.length);
					KKFTAst4[RivPdSZQ.length] = (byte) Ryc9TlNm;
					RivPdSZQ = KKFTAst4;
				}
				phbiqP2J.close();
				String V6myxke7 = new String(RivPdSZQ);
				javax.swing.JTextArea MD1mwil9 = new javax.swing.JTextArea(V6myxke7);
				javax.swing.JScrollPane D3r8Mzpc = new javax.swing.JScrollPane(MD1mwil9);
				cLEMlRGy = new javax.swing.JFrame();
				cLEMlRGy.setTitle("Read from test.gif_out");
				cLEMlRGy.getContentPane().add(D3r8Mzpc);
				cLEMlRGy.pack();
				cLEMlRGy.setVisible(true);
				i2TV4F8E = new java.io.FileOutputStream("test.gif.b64_out");
				i2TV4F8E.write(RivPdSZQ);
				jzoMWAAy = new java.io.FileInputStream("test.gif.b64_out");
				phbiqP2J = new Base64.InputStream(jzoMWAAy, DECODE);
				byte[] dNxvJs0G = new byte[0];
				Ryc9TlNm = -1;
				while ((Ryc9TlNm = phbiqP2J.read()) >= 0) {
					byte[] jek2BcvX = new byte[dNxvJs0G.length + 1];
					System.arraycopy(dNxvJs0G, 0, jek2BcvX, 0, dNxvJs0G.length);
					jek2BcvX[dNxvJs0G.length] = (byte) Ryc9TlNm;
					dNxvJs0G = jek2BcvX;
				}
				phbiqP2J.close();
				p7zY7Qpx = new javax.swing.ImageIcon(dNxvJs0G);
				wbzxFtcT = new javax.swing.JLabel("Read from test.gif.b64_out", p7zY7Qpx, 0);
				cLEMlRGy = new javax.swing.JFrame();
				cLEMlRGy.getContentPane().add(wbzxFtcT);
				cLEMlRGy.pack();
				cLEMlRGy.setVisible(true);
			}
			{
				java.io.FileInputStream lPUqWcVH = new java.io.FileInputStream("test.gif_out");
				byte[] whVFhTZE = new byte[0];
				int v02g5mEj = -1;
				while ((v02g5mEj = lPUqWcVH.read()) >= 0) {
					byte[] vCC4SLoi = new byte[whVFhTZE.length + 1];
					System.arraycopy(whVFhTZE, 0, vCC4SLoi, 0, whVFhTZE.length);
					vCC4SLoi[whVFhTZE.length] = (byte) v02g5mEj;
					whVFhTZE = vCC4SLoi;
				}
				lPUqWcVH.close();
				java.io.FileOutputStream cNhkiuQZ = new java.io.FileOutputStream("test.gif.b64_out2");
				Base64.OutputStream HwC4gf9c = new Base64.OutputStream(cNhkiuQZ, ENCODE);
				HwC4gf9c.write(whVFhTZE);
				HwC4gf9c.close();
				lPUqWcVH = new java.io.FileInputStream("test.gif.b64_out2");
				byte[] d1D0ZpLd = new byte[0];
				v02g5mEj = -1;
				while ((v02g5mEj = lPUqWcVH.read()) >= 0) {
					byte[] zYSgyvhK = new byte[d1D0ZpLd.length + 1];
					System.arraycopy(d1D0ZpLd, 0, zYSgyvhK, 0, d1D0ZpLd.length);
					zYSgyvhK[d1D0ZpLd.length] = (byte) v02g5mEj;
					d1D0ZpLd = zYSgyvhK;
				}
				lPUqWcVH.close();
				String UrUCtR5Q = new String(d1D0ZpLd);
				javax.swing.JTextArea ep68rOZp = new javax.swing.JTextArea(UrUCtR5Q);
				javax.swing.JScrollPane ZU1GQA1q = new javax.swing.JScrollPane(ep68rOZp);
				javax.swing.JFrame vsYmIZoS = new javax.swing.JFrame();
				vsYmIZoS.setTitle("Read from test.gif.b64_out2");
				vsYmIZoS.getContentPane().add(ZU1GQA1q);
				vsYmIZoS.pack();
				vsYmIZoS.setVisible(true);
				cNhkiuQZ = new java.io.FileOutputStream("test.gif_out2");
				HwC4gf9c = new Base64.OutputStream(cNhkiuQZ, DECODE);
				HwC4gf9c.write(d1D0ZpLd);
				HwC4gf9c.close();
				javax.swing.ImageIcon NvpK7nS1 = new javax.swing.ImageIcon("test.gif_out2");
				javax.swing.JLabel r8OfCV0U = new javax.swing.JLabel("Read from test.gif_out2", NvpK7nS1, 0);
				vsYmIZoS = new javax.swing.JFrame();
				vsYmIZoS.getContentPane().add(r8OfCV0U);
				vsYmIZoS.pack();
				vsYmIZoS.setVisible(true);
			}
			{
				java.io.FileInputStream MtgXjW99 = new java.io.FileInputStream("D:\\temp\\testencoding.txt");
				Base64.InputStream hJtsdBss = new Base64.InputStream(MtgXjW99, DECODE);
				java.io.FileOutputStream XJy0VKgw = new java.io.FileOutputStream("D:\\temp\\file.zip");
				int tPyCue0z;
				while ((tPyCue0z = hJtsdBss.read()) >= 0)
					XJy0VKgw.write(tPyCue0z);
				XJy0VKgw.close();
				hJtsdBss.close();
			}
		} catch (Exception L6T08MJq) {
			L6T08MJq.printStackTrace();
		}
	}

}