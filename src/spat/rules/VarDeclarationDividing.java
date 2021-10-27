package spat.rules;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class VarDeclarationDividing extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	Set<VariableDeclarationStatement> involvedStatements = new HashSet<VariableDeclarationStatement>();
	AST ast = null;
	ASTRewrite rewriter = null;
	
	public VarDeclarationDividing(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		ast = cu.getAST();
		rewriter = ASTRewrite.create(ast);
	}
	
	public boolean visit(VariableDeclarationStatement vdstatment) {
		if (vdstatment.fragments().size() > 1 && vdstatment.getParent().getNodeType() == ASTNode.BLOCK) {
			involvedStatements.add(vdstatment);
		}
		return false;
	}	
	
	

	public void endVisit(CompilationUnit node) {
		if (involvedStatements.size() == 0) {
			return;
		}
		for(VariableDeclarationStatement composedVDstatement : involvedStatements) {


			//get the type, get the modifiers
			Type typer = composedVDstatement.getType();
			List<Modifier> modis = composedVDstatement.modifiers();
			//iterate its fragments, create new ones.
			List<VariableDeclarationFragment> fraglist = composedVDstatement.fragments();
			ListRewrite lrt = rewriter.getListRewrite(composedVDstatement.getParent(), Block.STATEMENTS_PROPERTY);
			for (VariableDeclarationFragment frag : fraglist) {
				VariableDeclarationFragment fragment = (VariableDeclarationFragment) ASTNode.copySubtree(ast, frag);
				VariableDeclarationStatement newVDStatement = ast.newVariableDeclarationStatement(fragment);
				List<Modifier> tmpModis = newVDStatement.modifiers();
				for (Modifier x : modis) {
					tmpModis.add((Modifier) ASTNode.copySubtree(ast, x));
				}
				newVDStatement.setType((Type) ASTNode.copySubtree(ast, typer));
				lrt.insertAfter(newVDStatement, composedVDstatement, null);
			}
			rewriter.remove(composedVDstatement, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
		
	}
}