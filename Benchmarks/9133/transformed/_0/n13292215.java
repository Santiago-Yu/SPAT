class n13292215 {
	public static void main(String[] ZdFDMDw9) {
		try {
			{
				byte[] wGBUKsSI = { (byte) 2, (byte) 2, (byte) 3, (byte) 0, (byte) 9 };
				byte[] WpUVYnNX = { (byte) 99, (byte) 2, (byte) 2, (byte) 3, (byte) 0, (byte) 9 };
				System.out.println("Bytes 2,2,3,0,9 as Base64: " + encodeBytes(wGBUKsSI));
				System.out.println("Bytes 2,2,3,0,9 w/ offset: " + encodeBytes(WpUVYnNX, 1, WpUVYnNX.length - 1));
				byte[] cUm8hvL1 = decode(encodeBytes(wGBUKsSI));
				System.out.print(encodeBytes(wGBUKsSI) + " decoded: ");
				for (int PewqZJx2 = 0; PewqZJx2 < cUm8hvL1.length; PewqZJx2++)
					System.out.print(cUm8hvL1[PewqZJx2] + (PewqZJx2 < cUm8hvL1.length - 1 ? "," : "\n"));
			}
			{
				java.io.FileInputStream YChbzF3b = new java.io.FileInputStream("test.gif.b64");
				Base64.InputStream B2jxQTCq = new Base64.InputStream(YChbzF3b, DECODE);
				byte[] EzBH5cK6 = new byte[0];
				int vmOKb8Mk = -1;
				while ((vmOKb8Mk = B2jxQTCq.read()) >= 0) {
					byte[] SSIss0Iy = new byte[EzBH5cK6.length + 1];
					System.arraycopy(EzBH5cK6, 0, SSIss0Iy, 0, EzBH5cK6.length);
					SSIss0Iy[EzBH5cK6.length] = (byte) vmOKb8Mk;
					EzBH5cK6 = SSIss0Iy;
				}
				B2jxQTCq.close();
				javax.swing.ImageIcon Pml5XS05 = new javax.swing.ImageIcon(EzBH5cK6);
				javax.swing.JLabel bzqcRaKE = new javax.swing.JLabel("Read from test.gif.b64", Pml5XS05, 0);
				javax.swing.JFrame IihyzjdV = new javax.swing.JFrame();
				IihyzjdV.getContentPane().add(bzqcRaKE);
				IihyzjdV.pack();
				IihyzjdV.show();
				java.io.FileOutputStream FnzH0Qga = new java.io.FileOutputStream("test.gif_out");
				FnzH0Qga.write(EzBH5cK6);
				FnzH0Qga.close();
				YChbzF3b = new java.io.FileInputStream("test.gif_out");
				B2jxQTCq = new Base64.InputStream(YChbzF3b, ENCODE);
				byte[] vhOJCctH = new byte[0];
				vmOKb8Mk = -1;
				while ((vmOKb8Mk = B2jxQTCq.read()) >= 0) {
					byte[] miX3romz = new byte[vhOJCctH.length + 1];
					System.arraycopy(vhOJCctH, 0, miX3romz, 0, vhOJCctH.length);
					miX3romz[vhOJCctH.length] = (byte) vmOKb8Mk;
					vhOJCctH = miX3romz;
				}
				B2jxQTCq.close();
				String nvKdXDhq = new String(vhOJCctH);
				javax.swing.JTextArea Bdfxoay6 = new javax.swing.JTextArea(nvKdXDhq);
				javax.swing.JScrollPane qz3mjwNn = new javax.swing.JScrollPane(Bdfxoay6);
				IihyzjdV = new javax.swing.JFrame();
				IihyzjdV.setTitle("Read from test.gif_out");
				IihyzjdV.getContentPane().add(qz3mjwNn);
				IihyzjdV.pack();
				IihyzjdV.show();
				FnzH0Qga = new java.io.FileOutputStream("test.gif.b64_out");
				FnzH0Qga.write(vhOJCctH);
				YChbzF3b = new java.io.FileInputStream("test.gif.b64_out");
				B2jxQTCq = new Base64.InputStream(YChbzF3b, DECODE);
				byte[] s3lgCj2u = new byte[0];
				vmOKb8Mk = -1;
				while ((vmOKb8Mk = B2jxQTCq.read()) >= 0) {
					byte[] CzTA3Gb4 = new byte[s3lgCj2u.length + 1];
					System.arraycopy(s3lgCj2u, 0, CzTA3Gb4, 0, s3lgCj2u.length);
					CzTA3Gb4[s3lgCj2u.length] = (byte) vmOKb8Mk;
					s3lgCj2u = CzTA3Gb4;
				}
				B2jxQTCq.close();
				Pml5XS05 = new javax.swing.ImageIcon(s3lgCj2u);
				bzqcRaKE = new javax.swing.JLabel("Read from test.gif.b64_out", Pml5XS05, 0);
				IihyzjdV = new javax.swing.JFrame();
				IihyzjdV.getContentPane().add(bzqcRaKE);
				IihyzjdV.pack();
				IihyzjdV.show();
			}
			{
				java.io.FileInputStream mvDObc2N = new java.io.FileInputStream("test.gif_out");
				byte[] NtGsvYIm = new byte[0];
				int zW1V0TjQ = -1;
				while ((zW1V0TjQ = mvDObc2N.read()) >= 0) {
					byte[] nu3my1FJ = new byte[NtGsvYIm.length + 1];
					System.arraycopy(NtGsvYIm, 0, nu3my1FJ, 0, NtGsvYIm.length);
					nu3my1FJ[NtGsvYIm.length] = (byte) zW1V0TjQ;
					NtGsvYIm = nu3my1FJ;
				}
				mvDObc2N.close();
				java.io.FileOutputStream wEHyKLCH = new java.io.FileOutputStream("test.gif.b64_out2");
				Base64.OutputStream iapu2uUW = new Base64.OutputStream(wEHyKLCH, ENCODE);
				iapu2uUW.write(NtGsvYIm);
				iapu2uUW.close();
				mvDObc2N = new java.io.FileInputStream("test.gif.b64_out2");
				byte[] dZIt7TBa = new byte[0];
				zW1V0TjQ = -1;
				while ((zW1V0TjQ = mvDObc2N.read()) >= 0) {
					byte[] K5UIpeAL = new byte[dZIt7TBa.length + 1];
					System.arraycopy(dZIt7TBa, 0, K5UIpeAL, 0, dZIt7TBa.length);
					K5UIpeAL[dZIt7TBa.length] = (byte) zW1V0TjQ;
					dZIt7TBa = K5UIpeAL;
				}
				mvDObc2N.close();
				String OGpBoKva = new String(dZIt7TBa);
				javax.swing.JTextArea XVwCWxM1 = new javax.swing.JTextArea(OGpBoKva);
				javax.swing.JScrollPane VqApj4Q6 = new javax.swing.JScrollPane(XVwCWxM1);
				javax.swing.JFrame Jy3zolFt = new javax.swing.JFrame();
				Jy3zolFt.setTitle("Read from test.gif.b64_out2");
				Jy3zolFt.getContentPane().add(VqApj4Q6);
				Jy3zolFt.pack();
				Jy3zolFt.show();
				wEHyKLCH = new java.io.FileOutputStream("test.gif_out2");
				iapu2uUW = new Base64.OutputStream(wEHyKLCH, DECODE);
				iapu2uUW.write(dZIt7TBa);
				iapu2uUW.close();
				javax.swing.ImageIcon cjIibcVv = new javax.swing.ImageIcon("test.gif_out2");
				javax.swing.JLabel Y6kfgggN = new javax.swing.JLabel("Read from test.gif_out2", cjIibcVv, 0);
				Jy3zolFt = new javax.swing.JFrame();
				Jy3zolFt.getContentPane().add(Y6kfgggN);
				Jy3zolFt.pack();
				Jy3zolFt.show();
			}
			{
				java.io.FileInputStream LIDNqDTd = new java.io.FileInputStream("D:\\temp\\testencoding.txt");
				Base64.InputStream QPkzqZkN = new Base64.InputStream(LIDNqDTd, DECODE);
				java.io.FileOutputStream ytHtsRKk = new java.io.FileOutputStream("D:\\temp\\file.zip");
				int RRr8oDnc;
				while ((RRr8oDnc = QPkzqZkN.read()) >= 0)
					ytHtsRKk.write(RRr8oDnc);
				ytHtsRKk.close();
				QPkzqZkN.close();
			}
		} catch (Exception FXthQJ2H) {
			FXthQJ2H.printStackTrace();
		}
	}

}