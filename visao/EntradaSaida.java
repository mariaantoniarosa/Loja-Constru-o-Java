package visao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao() { 
		String [] op = { "Cadastrar Produtos", "Visualizar Produtos Cadastrados", "Inserir Estoque ", "Vizualizar Estoque", "Vender Produto", "Ver Cupons", "Sair" };
		JComboBox<String>menu = new JComboBox<String>(op);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção abaixo", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
				
	}
	public static String solicitaDescricao() { 
		String descricao = JOptionPane.showInputDialog(null, "Insira o nome do produto");
		return descricao;
	}
	public static double solicitaPreco() { 
	double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor do produto"));
	return valor;
	}
	public static String solicitaCod() { 
		String cod = JOptionPane.showInputDialog(null, "Insira o código do produto");
		return cod;
	}
	
	public static void imprimeProdutos(String info) { 
		JOptionPane.showMessageDialog(null, info);
		
	}
	
	public static String solicitaProdCod() { 
		String codig = JOptionPane.showInputDialog("Insira o código do produto");
		return codig;
	}
	
	public static int quantProd() { 
		int quant = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de produtos para colocar no estoque"));
		return quant;
	}
	
	public static void imprimeEstoque(String infoEstoque) {
		JOptionPane.showMessageDialog(null, infoEstoque);
	}
	public static String solicitaProdutoDesejado() { 
		String	info = JOptionPane.showInputDialog("Insira o código do produto que deseja comprar.");
		return info;	
		}
	public static int solicitaQuantVenda() { 
		int venda = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de produtos que deseja"));
		return venda ; 
	}
	public static void imprimeMsgEncerraPgm () { 
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}
	public static void imprimeMsgErro() { 
		JOptionPane.showMessageDialog(null, "Erro, código inválido!", "Erro",  (JOptionPane.INFORMATION_MESSAGE));
	}
	public static String solicitaData() {
		String data = JOptionPane.showInputDialog(null, "Insira a data de hoje");
		return data;
	}
	public static void imprimeProdVendido(String ProdVendido) {
		JOptionPane.showMessageDialog(null, ProdVendido);
		
	}
	public static void imprimeTot (double total) { 
		JOptionPane.showMessageDialog(null,"Total de vendas: R$ "+total);
	}
	
}
