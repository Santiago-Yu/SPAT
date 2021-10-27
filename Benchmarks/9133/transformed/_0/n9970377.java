class n9970377 {
	public void doWrite() {
		System.out.print("\nSerializing...");
		try {
			IFile Hvl8XwSw = null;
			File CCbdCITQ = null;
			if (null != method.getResource()) {
				Hvl8XwSw = method.getJavaProject().getResource().getProject().getFile(
						Statics.CFG_DIR + Statics.SEPARATOR + path.substring(path.lastIndexOf(Statics.SEPARATOR)));
			}
			CCbdCITQ = new File(path);
			if (CCbdCITQ.exists()) {
				boolean JBVuirXK = MessageDialog.openQuestion(wb.getSite().getShell(), "Flow Plug-in",
						"File already exists. Do you want to overwrite it?");
				if (JBVuirXK) {
					CCbdCITQ.delete();
				}
			}
			if (!CCbdCITQ.exists()) {
				FileOutputStream lIaq1YHB = new FileOutputStream(path);
				ObjectOutputStream R1SxtDH6 = new ObjectOutputStream(lIaq1YHB);
				BufferedOutputStream l8a5B6NU = new BufferedOutputStream(R1SxtDH6);
				R1SxtDH6.writeObject(anode);
				R1SxtDH6.flush();
				R1SxtDH6.close();
				InputStream ojse50fO = new FileInputStream(path);
				if (null != Hvl8XwSw) {
					if (Hvl8XwSw.exists())
						Hvl8XwSw.delete(true, null);
					Hvl8XwSw.create(ojse50fO, IResource.NONE, null);
				}
				Path tupC8HIq = new Path(path);
				IDE.openEditorOnFileStore(wb.getSite().getPage(), EFS.getLocalFileSystem().getStore(tupC8HIq));
				method.getResource().refreshLocal(10, null);
				System.out.println("Serializing ...Done!");
			}
		} catch (PartInitException SI0NQwTX) {
			SI0NQwTX.printStackTrace();
		} catch (IOException Of1yaSmz) {
			Of1yaSmz.printStackTrace();
		} catch (CoreException wGRZdeiJ) {
			wGRZdeiJ.printStackTrace();
		}
	}

}