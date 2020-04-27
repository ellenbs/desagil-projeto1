/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

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
        this.map.put('A', noVazio1);
        this.map.put('l', nol);
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
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {

        Queue<Node> queue = new LinkedList<>();
        Node no_final = null;
        char letra = ' ';

        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < (code.length()); i++) {

                Node node = queue.element();
                System.out.println(node);

                Node left = node.getLeft();
                Node right = node.getRight();

                if (left != null && code.charAt(i) == '.') {
                    queue.add(left);
                } else if (right != null && code.charAt(i) == '-') {
                    queue.add(right);
                }

                no_final = queue.remove();
                letra = no_final.getValue();
            }
        }
        System.out.println(letra);
        return letra;
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        return " ";
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        return new LinkedList<>();
    }
}
