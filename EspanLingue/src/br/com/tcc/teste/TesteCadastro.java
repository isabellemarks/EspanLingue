package br.com.tcc.teste;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.tcc.dao.CadastroDePerguntasDao;
import br.com.tcc.modelo.Alternativas;
import br.com.tcc.modelo.Enunciado;
import br.com.tcc.modelo.Gabarito;
import br.com.tcc.modelo.Niveis;

public class TesteCadastro {

	public TesteCadastro(){

	}

	static Niveis niveis = new Niveis();
	static Enunciado enunciado = new Enunciado();
	static CadastroDePerguntasDao cadastroDePerguntasDao = new CadastroDePerguntasDao();
	private static Scanner s;

	public static void main(String[] args) throws SQLException {
		s = new Scanner(System.in);

		System.out.println("Digite o Enunciado");
		String enunciado = s.nextLine();
		System.out.println(enunciado);

		System.out.println("Digite o Nivel do Enunciado");
		String nivelEnunciado = s.nextLine(); 
		System.out.println(nivelEnunciado);

		System.out.println("Alternativas: ");
		System.out.println("Letra A: ");
		String alternativaA = s.nextLine(); 

		System.out.println("Alternativas: ");
		System.out.println("Letra B: ");
		String alternativaB = s.nextLine(); 

		System.out.println("Alternativas: ");
		System.out.println("Letra C: ");
		String alternativaC = s.nextLine(); 

		System.out.println("Alternativas: ");
		System.out.println("Letra D: ");
		String alternativaD = s.nextLine(); 

		System.out.println("Gabarito: ");
		System.out.println("Digite a letra correspondente a resposta certa: ");
		String gabarito = s.nextLine(); 

		Niveis meuNivel = new Niveis(nivelEnunciado);
		int idNivel = cadastroDePerguntasDao.cadastrarUmNivel(meuNivel);
		meuNivel.setId(idNivel);


		Enunciado meuEnunciado = new Enunciado(enunciado , meuNivel);
		int idEnunciado = cadastroDePerguntasDao.cadastrarPergunta(meuEnunciado);
		meuEnunciado.setId(idEnunciado);
		

		Gabarito meuGabarito = new Gabarito(gabarito);
		int idGabarito = cadastroDePerguntasDao.cadastrarGabarito(meuGabarito);
		meuGabarito.setId(idGabarito);

		Alternativas minhasAlternativas = new Alternativas(alternativaA, alternativaB, alternativaC, alternativaD, meuEnunciado, meuGabarito );
		
		int idAlternativas = cadastroDePerguntasDao.cadastrarAlternativas(minhasAlternativas);
		minhasAlternativas.setId(idAlternativas);
		
		System.out.println(minhasAlternativas);
		
		
		


		System.out.println("deu certo ");

	}

}