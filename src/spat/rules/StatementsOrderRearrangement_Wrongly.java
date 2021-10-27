package spat.rules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class StatementsOrderRearrangement_Wrongly extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	Map<Statement, Statement > TheStatementscanSwitch = new HashMap<Statement, Statement >();
	Set<Statement> involvedStatements = new HashSet<Statement>();
	AST ast = null;
	ASTRewrite rewriter = null;
	
	public StatementsOrderRearrangement_Wrongly(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		ast = cu.getAST();
		rewriter = ASTRewrite.create(ast);
	}
	
	public boolean visit(Block blocker) {
		@SuppressWarnings("unchecked")
		List<Statement> stas = blocker.statements();
		int lener = stas.size();
		for(int i = 0; i < lener - 1; i++) {
			Statement presta = stas.get(i);
			Statement aftersta = stas.get(i+1);
			if(involvedStatements.contains(presta) || involvedStatements.contains(aftersta)) {
				continue;
			}
			
			if(canSwitch(presta, aftersta)) {
				TheStatementscanSwitch.put(presta,aftersta);
				involvedStatements.add(presta);
				involvedStatements.add(aftersta);
			}
		}
		return true;
	}


	
	private boolean canSwitch(Statement presta, Statement aftersta) {
		return true;
//		//Before anything, lets check the special statements
//		int ForbiddenStatements[] = {ASTNode.CONTINUE_STATEMENT, ASTNode.BREAK_STATEMENT, ASTNode.RETURN_STATEMENT};
//		Set<Integer> FSset = new HashSet<>();
//		for (int fs : ForbiddenStatements) {
//			FSset.add(fs);
//		}
//		if(FSset.contains(presta.getNodeType()) || FSset.contains(aftersta.getNodeType())) {
//			return false;
//		}
//		//First, gather all the required variables.
//		Set<IBinding> usedPre = Utils.resolveAlluseddVarNames(presta);
//		//Second, gather all the modified variables of the big brother.
//		Set<IBinding> usedafter = Utils.resolveAlluseddVarNames(aftersta);
//		//Third, check if there is no intersection
//		usedPre.retainAll(usedafter);
//		if(usedPre.size() > 0) {
//			return false;
//		}
//		else return true;
	}
	
	public void endVisit(CompilationUnit node) {
		if (TheStatementscanSwitch.size() == 0) {
			return;
		}
		Set<Statement> thePres = TheStatementscanSwitch.keySet();
		for(Statement thePre : thePres) {
			Statement theAfter = TheStatementscanSwitch.get(thePre);
//			System.out.println("Find One!");
//			System.out.println(thePre.toString());
//			System.out.println(theAfter.toString());
			Statement tmp = (Statement) ASTNode.copySubtree(ast, thePre);
			rewriter.replace(thePre, (Statement) ASTNode.copySubtree(ast, theAfter), null);
			rewriter.replace(theAfter, tmp, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
		
	}
	
}
