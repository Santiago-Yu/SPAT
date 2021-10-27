package spat.rules;

import java.util.ArrayList;
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
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.InfixExpression;
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

public class SwitchEqualSides extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	List<InfixExpression> equivalences = new ArrayList<InfixExpression>();
	AST ast = null;
	ASTRewrite rewriter = null;
	
	public SwitchEqualSides(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		ast = cu.getAST();
		rewriter = ASTRewrite.create(ast);
	}
	
	public boolean visit(InfixExpression equ) {
		if(equ.getOperator().toString() == InfixExpression.Operator.EQUALS.toString()) {
			equivalences.add(equ);
			return false;
		}
		return true;
	}	
	
	

	public void endVisit(CompilationUnit node) {
		if (equivalences.size() == 0) {
			return;
		}
		for(InfixExpression equ : equivalences) {
			//Copy
			InfixExpression copyedOne = (InfixExpression) ASTNode.copySubtree(ast, equ);
			Expression le = (Expression) ASTNode.copySubtree(ast,equ.getLeftOperand());
			copyedOne.setRightOperand(le);
			Expression re = (Expression) ASTNode.copySubtree(ast,equ.getRightOperand());
			copyedOne.setLeftOperand(re);
			rewriter.replace(equ, copyedOne, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
		
	}
}