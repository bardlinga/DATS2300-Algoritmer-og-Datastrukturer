package hjelpeklasser;

import java.util.ArrayList;
import java.util.List;

public class Binaertre {

    Node root;

    // legge til noder --------------------------------------------------------

    private Node addRekursiv(Node thisNode, int verdi, Node forelder){
        if (thisNode == null){
            return new Node(verdi, forelder);
        } else if (verdi < thisNode.verdi) {
            thisNode.vBarn = addRekursiv(thisNode.vBarn, verdi, thisNode);
        } else if (verdi > thisNode.verdi) {
            thisNode.hBarn = addRekursiv(thisNode.hBarn, verdi, thisNode);
        } else {
            return thisNode;
        }
        return thisNode;
    }

    public void add (int verdi){
        root = addRekursiv(root, verdi, null);
    }


    public void addFraTabell (int [] tabell){
        for (int verdi : tabell){
            add(verdi);
        }
    }

    // leite etter verdiar ----------------------------------------------------

    private boolean inneholderVerdiRekursiv(Node thisNode, int verdi){
        if (thisNode == null){
            return false;
        } else if (verdi < thisNode.verdi) {
            return inneholderVerdiRekursiv(thisNode.vBarn, verdi);
        } else if (verdi > thisNode.verdi) {
            return inneholderVerdiRekursiv(thisNode.hBarn, verdi);
        } else {
            return true;
        }
    }

    public boolean inneholderVerdi(int verdi){
        return inneholderVerdiRekursiv(root, verdi);
    }

    // traverseringsmetodar ---------------------------------------------------

    private void inOrdenRekursiv(Node node, List<Integer> tempTabell){
        if (node != null) {
            inOrdenRekursiv(node.vBarn, tempTabell);
            tempTabell.add(node.verdi);
            inOrdenRekursiv(node.hBarn, tempTabell);
        }
    }

    public int[] inOrdenTabell(){
        List<Integer> tempTabell = new ArrayList<>();

        inOrdenRekursiv(root, tempTabell);

        int [] tabell = new int [tempTabell.size()];
        for (int i = 0; i < tempTabell.size(); i++){
            tabell[i] = tempTabell.get(i);
        }
        return tabell;
    }

    // konstruktørar ----------------------------------------------------------

    public Binaertre(){}

    public Binaertre(int[] tabell){
        for (int verdi : tabell){
            add(verdi);
        }
    }
}

// nodeklassen ----------------------------------------------------------------

class Node {
    int verdi;
    Node vBarn;
    Node hBarn;
    Node forelder;

    public Node (int verdi, Node forelder) {
        this.verdi = verdi;
        this.forelder = forelder;
    }
}
