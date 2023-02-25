package controle;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Cupom;
import modelo.Loja;
import modelo.Produtos;
import visao.EntradaSaida;

public class Controladora {
	private Cupom cupom = null;
	private Loja loja = new Loja();
	private Produtos produto = null;
	String produtoDesejado = "";
	String data = "";
	String codCriado;
	int quantProd;
	int quantProdDesejado = 0;
	double valor = 0;
	Date date  ;
 
	public void exibeMenu() {

		int opcao = 0;
		String descri = "";
		String cod = "";
		boolean validador = false;
		do {
			if (validador!= true) {
				while (opcao != 0 ) { 
					JOptionPane.showMessageDialog(null, "Insira os produtos!");
					opcao = EntradaSaida.solicitaOpcao();
				}
			}
			opcao = EntradaSaida.solicitaOpcao();
			switch (opcao) {
			
			case 0:
				validador  = true;
				this.produto = new Produtos();
				descri = EntradaSaida.solicitaDescricao();
				valor = EntradaSaida.solicitaPreco();

				cod = EntradaSaida.solicitaCod();
				produto.setDescricao(descri);
				produto.setPreco(valor);
				produto.setCodigo(cod);
				loja.criarProd(produto);
				System.out.println(descri);
				break;

			case 1:

				String info = loja.gerarDadosProd();
				EntradaSaida.imprimeProdutos(info);
				break;

			case 2:

				codCriado = EntradaSaida.solicitaCod();
				boolean valid = loja.validaProd(codCriado, produtoDesejado);
				if (valid == true) {
					int quantProd = EntradaSaida.quantProd();

					while (quantProd < 0) {
						quantProd = Integer.parseInt(
								JOptionPane.showInputDialog("Quantidade Inválida, por favor digite novamente."));
					}
					loja.insereEstoque(codCriado, quantProd);

				} else {

					EntradaSaida.imprimeMsgErro();

				}

				break;
			case 3:
				String infoEstoque = loja.gerarInfoEstoque();
				if (infoEstoque == "") { 
					//se o usuario selecionar o estoque e não tiver nada, aparece essa mensagem. 
					//caso seja segunda vez em diante não aparece, apenas aparecera que não foi criado produtos. 
					JOptionPane.showMessageDialog(null, "Não há estoque!");
				}else { 
				EntradaSaida.imprimeEstoque(infoEstoque);
				}
				break;
			case 4:
			date = loja.geraData();
				produtoDesejado = EntradaSaida.solicitaProdutoDesejado();
				boolean val = loja.validaProd2(produtoDesejado, produtoDesejado);
				if (val == true) {
					quantProdDesejado = EntradaSaida.solicitaQuantVenda();
					boolean validaQuantEstoque = loja.validaQuantEstoque(quantProdDesejado, produtoDesejado);
					if (validaQuantEstoque) {
						JOptionPane.showMessageDialog(null, "Não há produtos desta categoria no estoque.");
					} else {

						loja.venderProd(quantProdDesejado, produtoDesejado);
						Cupom cupom = new Cupom();
						cupom.setData(date);
						cupom.setQuantVendido(quantProdDesejado);
						double valorFinal = loja.calculaValor(valor, quantProdDesejado,produtoDesejado);
						cupom.setValorFinal(valorFinal);
						loja.criarCupom(cupom);
						String ProdVendido = loja.produtosVendidos(quantProdDesejado, produtoDesejado, date,cupom);
						EntradaSaida.imprimeProdVendido(ProdVendido);
					}
					// }
				} else {
					EntradaSaida.imprimeMsgErro();

				}

				break;
			case 5:

				String ProdVendido = loja.vendeProd(quantProdDesejado, produtoDesejado);
				if (ProdVendido == "" ) {
					JOptionPane.showMessageDialog(null, "Não há vendas ainda");
				}else {
				EntradaSaida.imprimeProdVendido(ProdVendido);
			double total=	loja.calculaValorTotal();
			EntradaSaida.imprimeTot(total);
				}
				break;
			case 6:
				EntradaSaida.imprimeMsgEncerraPgm();
				System.exit(0);
			}
			

		} while (opcao != 6);
	 

	}
}
