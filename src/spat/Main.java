package spat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;
public class Main {
	//use ASTParse to parse string
	public static void parse(String str, String dirPath,String outputdir,String[] arrString, String IdofRule) {
		Document document = new Document(str);
		ASTParser parser = ASTParser.newParser(AST.JLS13);
		parser.setResolveBindings(true);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
		parser.setBindingsRecovery(true);
 
		Map<String, String> options = JavaCore.getOptions();
		parser.setCompilerOptions(options);
 
		String unitName = "Apple.java";// Just some random name.
		parser.setUnitName(unitName);
 
		//String[] sources = Utils.SingleStr2priList(dirPath);//This make things complicated,we do not need to consider the relationship between files.
		String[] sources = {""};//Just the file itself.
		String[] classpath = arrString;
 
		parser.setEnvironment(classpath, sources, new String[] { "UTF-8"}, true);
		parser.setSource(str.toCharArray());
 
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);
//		
//		if (cu.getAST().hasBindingsRecovery()) {
//			System.out.println("Binding activated.");
//		}
//		else {
//			System.out.println("Binding is not activated.");
//		}
		
		cu.accept(RuleSelector.create(IdofRule, cu, document, outputdir));
			
 
	}
	 
	
 
	//loop directory to get file list
	public static void ParseFilesInDir(String dirPath,String outputdir,String[] arrString, String idOfRule) throws IOException{
//		SOURCES = new ArrayList<String>();
		File root = new File(dirPath);
		//System.out.println(rootDir.listFiles());
		File[] files = Utils.folderMethod(root.getAbsolutePath(), outputdir);

		
		
		
		
//		 for (File f : files ) {
//			 String filePath = f.getAbsolutePath();
//			 if(f.isFile()){
//				 System.out.println("Current File is: " + filePath);
//				 try {
//					 parse(Utils.readFileToString(filePath), dirPath, Utils.sublizeOutput(filePath, dirPath, outputdir), arrString, idOfRule);
//				 }
//				 catch(Exception e){
//					 System.out.println("trans failed:	" + filePath);
//					 System.out.println(e.toString());
//				 }
//			 }
//		 } //This is the old single thread.
		
		
		// If the Size if too big, we have to chop it into a small number.
		//Set<File> fileSet = Set.of(files);
		Set<File> fileSet = new HashSet<File>(Arrays.asList(files));
		
		ForkJoinPool myPool = new ForkJoinPool(32);
		try {
			myPool.submit(() ->
			fileSet.parallelStream().forEach(f -> {
				String filePath = f.getAbsolutePath();
				 if(f.isFile()){
					 //System.out.println("Current File is: " + filePath);
					 try {
						parse(Utils.readFileToString(filePath), dirPath,Utils.sublizeOutput(filePath, dirPath, outputdir), arrString, idOfRule);
					} catch (Exception e ) {
						// TODO Auto-generated catch block
						System.out.println("trans failed:	" + filePath);
					}catch (Error s) {
						// TODO Auto-generated catch block
						System.out.println("trans failed:	" + s.toString());
					}
				 }
			})).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
 
	public static void main(String[] args) throws IOException {
		int maxTrans = 10000;
//		if (args.length == 5) {
//			maxTrans = Integer.parseInt(args[4]);
//		}
		Utils.maxTrans = maxTrans;
		if(args.length != 4 ) {//&& args.length != 5
			System.out.println("SRAT needs four arguments to run properly: "
					+ "[theIdOfTheSelectedRule] [DirPathOftheSourcefiles] [OutputDir] [PathoftheJre(rt.jar)] & [PathofotherDependentJar] "
					+ "for example \"C:\\Program Files\\Java\\jre1.8.0_211\\lib\\rt.jar\"");
			System.exit(4);
		}
		String dirOfthefiles = args[1];
		String outputdir = args[2];
		ArrayList <String> jre_rtPath = new ArrayList<String>();
		for(int i = 3; i < args.length;i++) {
			jre_rtPath.add(args[i]);
		}
		
		ParseFilesInDir(dirOfthefiles, outputdir, Utils.ArryStr2priStrList(jre_rtPath), args[0]);
	}
}