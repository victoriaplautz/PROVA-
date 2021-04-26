package PROVA;

import java.util.Scanner;
import java.time.LocalDateTime;

public class PROVA {

	public static void main(String[] args) {
		
	//Entradas
	
		//Entradas
		
		String nome, sobrenome, estado;
		String aniversario;
		int aposentado;
		int categoria;
		int continuar;
		int valor_beneficio, funcionarios, meses_desempregado;
        int anonasci, anoatual;
        String dia, mes;
        int beneficio;
        
      //Scanner teclado = new Scanner(System.in);
            
		do {

	    Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o Nome: ");
        nome = teclado.next();
        
        System.out.println("Informe o sobreome: ");
        sobrenome = teclado.next();
        
        System.out.println("Informe o Dia e o Mês do seu aniversario no seguinte formato: (DD/MM)");
        aniversario = teclado.next();
        
        System.out.println("Informe o ano de nascimento: ");
        anonasci = teclado.nextInt();
        
        System.out.println("Informe seu Estado (UF)");
        estado = teclado.next();
        
        // (Regra de Negocio A)
    	//Verifica se é maior de 18 anos

        LocalDateTime data1 = LocalDateTime.now();
        anoatual = data1.getYear();
        int idade = (anoatual - anonasci);
        
        if (idade > 18) {
            
        	System.out.println("Informe a categoria:\n1- Empregado\n2- Empregador\n3- Desempregado");
        	categoria = teclado.nextInt();
        	
        	//Switch Case para as exigências dos tres casos
        	switch(categoria)
        	
        	{
        	
        	case 1:
        		System.out.println("Você escolheu a categoria 1: Empregado");
        		System.out.println("O Empregado é Aposentado?\n1-Sim\n2-Não");
        		aposentado = teclado.nextInt();
        		System.out.println("Qual sera o valor do beneficio? Considerar entre R$1000 e R$1800 para Empregados!");
        		beneficio = teclado.nextInt();
        		
        		
        		break;
        		
        	case 2:
        		System.out.println("Você escolheu a categoria 2: Empregador");
        		System.out.println("Quantos Funcionarios Possui?");
        		funcionarios = teclado.nextInt();
        		int beneficio_fun = (funcionarios * 200);
        		System.out.println("O Valor do Beneficio sera de R$200 por funcionario totalizando: R$" + beneficio_fun);
        		if (funcionarios <= 50) {
        			int beneficio_funnovo = (beneficio_fun * 10 / 100); //Empregadores com até 50 Funcionarios Recebem um Acrescimo de 1% sobre o Valor total (Regra de Negocio C)
        			beneficio_funnovo = (beneficio_fun + beneficio_funnovo);
        			System.out.println("Empregadores com até 50 funcionarios recebem um acrescimo de 10% Passando de: R$" + beneficio_fun + " Para R$" + beneficio_funnovo );
        				if (funcionarios <= 10) { //Para Empregadores com até 10 funcionario o beneficio é de 10 Meses (Regra de Negocio R)
        					System.out.println("Para Empregadores com até 10 Funcionario o beneficio é de 10 Meses Totalizando R$:" + beneficio_funnovo * 10);
        				} else { // O Benefício será de 7 meses para empregadores (Regra de negocio O)
        					System.out.println("Para Empregadores com mais de 10 Funcionarios o beneficio é de 7 meses Totalizando R$:" + beneficio_funnovo * 7);
        				}
        				if (estado == "TO") { // Regra de Negocio V
        					int beneficio_to = (beneficio_funnovo * 9 / 100);
        					System.out.println(beneficio_to);
        				}
        		}
        		
        		break;
        		
        	case 3:
        		System.out.println("Você escolheu a categoria 3: Desempregado");
        		System.out.println("Esta a quantos meses desempregado?");
        		meses_desempregado = teclado.nextInt();
        		System.out.println("Qual sera o valor do beneficio? Considerar entre R$1500 e R$2300 para desempregados!");
        		beneficio = teclado.nextInt();
        		break;
        	
        	}
        
        }else {
        	System.out.println("A Pessoa Informada não tem direito ao beneficio pois não tem 18 anos!");
        }
        //Solicida Data de Nascimento
	
    // (Regra de Negocio V)
    int beneficio1 = (int) 0.09;
	if (estado == "TO"){beneficio1 += beneficio1 * 0.09;}
	
	// (Regra de Negocio C)
//	if (funcionarios <= 50) {
//		int beneficio_funnovo2 = (beneficio_fun * 10 / 100); //Empregadores com até 50 Funcionarios Recebem um Acrescimo de 10% sobre o Valor total
//		beneficio_funnovo = (beneficio_fun + beneficio_funnovo);
//		System.out.println("Empregadores com até 50 funcionarios recebem um acrescimo de 10% Passando de: R$" + beneficio_fun + " Para R$" + beneficio_funnovo );
	
	// (Regra de Negocio T)
	int beneficio3 = (int) 0.09;
	if (estado == "PA"){beneficio3 += beneficio3 * 0.09;}
	
//	// (Regra de Negocio O)
//	} else { // O Benefício será de 7 meses para empregadores
//		System.out.println("Para Empregadores com mais de 10 Funcionarios o beneficio é de 7 meses Totalizando R$:" + beneficio_funnovo * 7);
//	}
	
//	// (Regra de Negocio R)
//	if (funcionarios <= 10) { //Para Empregadores com até 10 funcionario o beneficio é de 10 Meses
//		System.out.println("Para Empregadores com até 10 Funcionario o beneficio é de 10 Meses Totalizando R$" + beneficio_funnovo * 10);
	
	//Nao conceder o Beneficio para menores de 18 Anos (Regra de Negocio A)
     	 
    //Saida
    System.out.println("=====================================");
    System.out.println("Nome: " + nome + " " + sobrenome);
    System.out.println("Idade: " + (anoatual - anonasci) + " Anos");
    System.out.println("Nascimento: " + aniversario + "/" + anonasci);
    
    
    //Perguntar se quer repetir o Loop
    	System.out.println("================================\nDeseja Informar um novo benefico?\n1-SIM\n2-NÃO");
    	continuar = teclado.nextInt();
    		} while (continuar == 1);
		
		System.out.println("Programa Finalizado!!!");
	}
}
    		       
//Regra de negocio X (Nao consegui emplementar ela no codigo)
//if (estado == RS ) {
//	int beneficio_rs = (beneficio * 10 / 100);
//	beneficio_rs = (beneficio + beneficio_rs);
//	System.out.println("Para que mora no RS o Benefico tera um acrescimo de 10% passando de:" + beneficio + "para" + beneficio_rs);
//}