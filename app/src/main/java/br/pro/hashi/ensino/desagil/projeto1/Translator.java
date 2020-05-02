/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;

    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {

        map = new HashMap<>();
        root = new Node('S');
        Node noe = new Node('e');
        Node not = new Node('t');

        Node noi = new Node('i');
        Node noa = new Node('a');
        Node non = new Node('n');
        Node nom = new Node('m');

        Node nos = new Node('s');
        Node nou = new Node('u');
        Node nor = new Node('r');
        Node now = new Node('w');
        Node nod = new Node('d');
        Node nok = new Node('k');
        Node nog = new Node('g');
        Node noo = new Node('o');

        Node noh = new Node('h');
        Node nov = new Node('v');
        Node nof = new Node('f');
        Node nol = new Node('l');
        Node nop = new Node('p');
        Node noj = new Node('j');
        Node nob = new Node('b');
        Node nox = new Node('x');
        Node noc = new Node('c');
        Node noy = new Node('y');
        Node noz = new Node('z');
        Node noq = new Node('q');
        Node noVazio1 = new Node('A');
        Node noVazio2 = new Node('B');
        Node noVazio3 = new Node('C');

        Node no0 = new Node('0');
        Node no1 = new Node('1');
        Node no2 = new Node('2');
        Node no3 = new Node('3');
        Node no4 = new Node('4');
        Node no5 = new Node('5');
        Node no6 = new Node('6');
        Node no7 = new Node('7');
        Node no8 = new Node('8');
        Node no9 = new Node('9');

        root.setLeft(noe);
        root.setRight(not);

        noe.setLeft(noi);
        noe.setRight(noa);
        not.setLeft(non);
        not.setRight(nom);

        noi.setLeft(nos);
        noi.setRight(nou);
        noa.setLeft(nor);
        noa.setRight(now);
        non.setLeft(nod);
        non.setRight(nok);
        nom.setLeft(nog);
        nom.setRight(noo);

        nos.setLeft(noh);
        nos.setRight(nov);
        nou.setLeft(nof);
        nou.setRight(noVazio1);
        nor.setLeft(nol);
        now.setLeft(nop);
        now.setRight(noj);
        noj.setRight(no1);
        nod.setLeft(nob);
        nod.setRight(nox);
        nok.setLeft(noc);
        nok.setRight(noy);
        nog.setLeft(noz);
        nog.setRight(noq);
        noo.setLeft(noVazio2);
        noo.setRight(noVazio3);
        nob.setLeft(no6);
        noz.setLeft(no7);

        noh.setLeft(no5);
        noh.setRight(no4);
        nov.setRight(no3);
        noVazio1.setRight(no2);
        noVazio2.setLeft(no8);
        noVazio3.setLeft(no9);
        noVazio3.setRight(no0);

        noe.setParent(root);
        not.setParent(root);
        noa.setParent(noe);
        noi.setParent(noe);
        nom.setParent(not);
        non.setParent(not);
        nou.setParent(noi);
        nos.setParent(noi);
        nor.setParent(noa);
        now.setParent(noa);
        nod.setParent(non);
        nok.setParent(non);
        nog.setParent(nom);
        noo.setParent(nom);
        noh.setParent(nos);
        nov.setParent(nos);
        nof.setParent(nou);
        noVazio1.setParent(nou);
        nol.setParent(nor);
        nop.setParent(now);
        noj.setParent(now);
        nob.setParent(nod);
        nox.setParent(nod);
        noc.setParent(nok);
        noy.setParent(nok);
        noz.setParent(nog);
        noq.setParent(nog);
        noVazio2.setParent(noo);
        noVazio3.setParent(noo);
        no5.setParent(noh);
        no4.setParent(noh);
        no3.setParent(nov);
        no2.setParent(noVazio1);
        no1.setParent(noj);
        no6.setParent(nob);
        no7.setParent(noz);
        no8.setParent(noVazio2);
        no9.setParent(noVazio3);
        no0.setParent(noVazio3);

        this.map.put('S', root);
        this.map.put('e', noe);
        this.map.put('t', not);

        this.map.put('i', noi);
        this.map.put('a', noa);
        this.map.put('n', non);
        this.map.put('m', nom);

        this.map.put('s', nos);
        this.map.put('u', nou);
        this.map.put('r', nor);
        this.map.put('w', now);
        this.map.put('d', nod);
        this.map.put('k', nok);
        this.map.put('g', nog);
        this.map.put('o', noo);

        this.map.put('h', noh);
        this.map.put('v', nov);
        this.map.put('f', nof);
        this.map.put('l', nol);
        this.map.put('A', noVazio1);

        this.map.put('p', nop);
        this.map.put('j', noj);
        this.map.put('b', nob);
        this.map.put('x', nox);
        this.map.put('c', noc);
        this.map.put('y', noy);
        this.map.put('z', noz);
        this.map.put('q', noq);
        this.map.put('B', noVazio2);
        this.map.put('C', noVazio3);

        this.map.put('1', no1);
        this.map.put('2', no2);
        this.map.put('3', no3);
        this.map.put('4', no4);
        this.map.put('5', no5);
        this.map.put('6', no6);
        this.map.put('7', no7);
        this.map.put('8', no8);
        this.map.put('9', no9);
        this.map.put('0', no0);


    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        Node no_final = root;
        char letra = ' ';

        for (int i = 0; i < (code.length()); i++) {

            if (code.charAt(i) == '.') {
                no_final = no_final.getLeft();

            } else if (code.charAt(i) == '-') {
                no_final = no_final.getRight();
            }
            letra = no_final.getValue();
        }
        return letra;
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        String resposta = "";
        String invertida = "";

        while(node != root){
            Node noAtual = node;
            node = node.getParent();
            System.out.println(node);
            if (node.getLeft() == noAtual){
                resposta += ".";
            }else{resposta += "-";}
        }

        char[] try1 = resposta.toCharArray();
        for (int i = try1.length-1; i>=0; i--){
            invertida += try1[i];
        }

        return invertida;
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        Queue<Node> queue = new LinkedList<>();
        LinkedList<String>morses = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.element();

            if (node.getValue() != 'S' && node.getValue() != 'A' && node.getValue() != 'B' && node.getValue() != 'C'){
            morses.add(charToMorse(node));}

            Node left = node.getLeft();
            Node right = node.getRight();


            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            queue.remove();

        }
        return morses;
    }
}
