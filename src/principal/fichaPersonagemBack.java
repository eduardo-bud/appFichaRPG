/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package principal;
import java.util.Random;
import java.io.*;

/**
 *
 * @author eduar
 */
public class fichaPersonagemBack {
    private String nome;
    private String idade;
    private String genero;
    private String aparencia;
    private String classe;
    private String percurso;
    private String aspecto1;
    private String aspecto2;
    private int pontos_acao;
    private int deslocamento;
    private int bloqueio;
    private int esquiva;
    private int vitalidade;
    private int ether;
    private int nivel_nucleo;
    private int mente;
    private int agilidade;
    private int fortitude;
    private int sentidos;
    private int poder;
    
    
    public fichaPersonagemBack(){
    }
    
    
    public int calcularVitalidadeINIT(int fortitude){
    Random random = new Random();
   for(int i=1; i <=fortitude; i++){ 
       vitalidade += random.nextInt(6)+1;
               }
   int d3 = random.nextInt(3)+1;
    for(int i=1; i <=d3; i++){ 
       vitalidade += random.nextInt(6)+1;
               }
    return vitalidade;
    }
    
    public int calcularEtherINIT(int poder){
    Random random = new Random();
   for(int i=1; i <=poder; i++){ 
       ether += random.nextInt(6)+1;
               }
   int d5 = random.nextInt(5)+1;
    for(int i=1; i <=d5; i++){ 
       ether += random.nextInt(6)+1;
               }
    return ether;
    }
    
    public void salvarEmArquivo(String caminho) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(caminho));
        writer.write(nome + "\n");
        writer.write(idade + "\n");
        writer.write(genero + "\n");
        writer.write(aparencia + "\n");
        writer.write(pontos_acao + "\n");
        writer.write(deslocamento + "\n");
        writer.write(bloqueio + "\n");
        writer.write(esquiva + "\n");
        writer.write(vitalidade + "\n");
        writer.write(ether + "\n");
        writer.write(nivel_nucleo + "\n");
        writer.write(mente + "\n");
        writer.write(agilidade + "\n");
        writer.write(fortitude + "\n");
        writer.write(sentidos + "\n");
        writer.write(poder + "\n");
        writer.write(classe + "\n");
        writer.write(percurso + "\n");
        writer.write(aspecto1 + "\n");
        writer.write(aspecto2 + "\n");

        
        writer.close();
    }
    public void carregarDeArquivo(String caminho) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(caminho));

        nome = reader.readLine();
        idade = reader.readLine();
        genero = reader.readLine();
        aparencia = reader.readLine();
        pontos_acao = Integer.parseInt(reader.readLine());
        deslocamento = Integer.parseInt(reader.readLine());
        bloqueio = Integer.parseInt(reader.readLine());
        esquiva = Integer.parseInt(reader.readLine());
        vitalidade = Integer.parseInt(reader.readLine());
        ether = Integer.parseInt(reader.readLine());
        nivel_nucleo = Integer.parseInt(reader.readLine());
        mente = Integer.parseInt(reader.readLine());
        agilidade = Integer.parseInt(reader.readLine());
        fortitude = Integer.parseInt(reader.readLine());
        sentidos = Integer.parseInt(reader.readLine());
        poder = Integer.parseInt(reader.readLine());
       classe = reader.readLine();
       percurso = reader.readLine();
       aspecto1 = reader.readLine();
       aspecto2 = reader.readLine();
        reader.close();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getIdade() { return idade; }
    public void setIdade(String idade) { this.idade = idade; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getAparencia() { return aparencia; }
    public void setAparencia(String aparencia) { this.aparencia = aparencia; }

    public int getPontos_acao() { return pontos_acao; }
    public void setPontos_acao(int pontos_acao) { this.pontos_acao = pontos_acao; }

    public int getDeslocamento() { return deslocamento; }
    public void setDeslocamento(int deslocamento) { this.deslocamento = deslocamento; }

    public int getBloqueio() { return bloqueio; }
    public void setBloqueio(int bloqueio) { this.bloqueio = bloqueio; }

    public int getEsquiva() { return esquiva; }
    public void setEsquiva(int esquiva) { this.esquiva = esquiva; }

    public int getVitalidade() { return vitalidade; }
    public void setVitalidade(int vitalidade) { this.vitalidade = vitalidade; }

    public int getEther() { return ether; }
    public void setEther(int ether) { this.ether = ether; }

    public int getNivel_nucleo() { return nivel_nucleo; }
    public void setNivel_nucleo(int nivel_nucleo) { this.nivel_nucleo = nivel_nucleo; }

    public int getMente() { return mente; }
    public void setMente(int mente) { this.mente = mente; }

    public int getAgilidade() { return agilidade; }
    public void setAgilidade(int agilidade) { this.agilidade = agilidade; }

    public int getFortitude() { return fortitude; }
    public void setFortitude(int fortitude) { this.fortitude = fortitude; }

    public int getSentidos() { return sentidos; }
    public void setSentidos(int sentidos) { this.sentidos = sentidos; }

    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }
    
    public String getClasse() {return classe;}
    public void setClasse(String classe) {this.classe = classe;}

    public String getPercurso() {return percurso;}
    public void setPercurso(String percurso) {this.percurso = percurso;}

    public String getAspecto1() {return aspecto1;}
    public void setAspecto1(String aspecto1) {this.aspecto1 = aspecto1;}

    public String getAspecto2() {return aspecto2;}
    public void setAspecto2(String aspecto2) {this.aspecto2 = aspecto2;}

}

    
    
    

