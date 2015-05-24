package org.iis.prdoublylinkedlist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class DoublyLinkedListTest {
    
    @Test
    public <T> void testConstructor() {
        assertTrue((new DoublyLinkedList<T>()) instanceof DoublyLinkedList);
    }
    
    @Test
    public void testIsEmptyConListaVacia() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        assertTrue(lista.isEmpty());
    }
    
    @Test
    public void testIsEmptyConListaNoVacia() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        assertFalse(lista.isEmpty());
    }
    

    @Test
    public void testInsertEndUnElemento() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertEnd(1);
        int esperado = 1;
        int real = lista.size();
        assertEquals(esperado, real);
    }
    
    @Test
    public void testSiSeInsertaAlFinalEnUnaListaYaCreadaSeraElUltimo() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertEnd(1);
        lista.insertEnd(2);
        int esperado = 2;
        int real = lista.get(1);
        assertEquals(esperado, real);
    }
    
    @Test
    public void testInsertBeginning() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(2);
        int esperado = 1;
        int real = lista.size();
        assertEquals(esperado, real);
    }
    
    
    @Test
    public void testSiSeInsertaAlPrincipioEnUnaListaYaCreadaSeraElPrimero() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(2);
        lista.insertBeginning(1);
        int esperado = 1;
        int real = lista.get(0);
        assertEquals(esperado, real);   
    }
    
    @Test
    public void testInsertAfter() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(3);
        lista.insertAfter(2, 0);
        int esperado = 2;
        int real = lista.get(1);
        assertEquals(esperado, real);
    }
    
    @Test (expected = DoublyLinkedListException.class)
    public void testInsertAfterPosicionNula() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(2);
        lista.insertEnd(4);
        lista.insertAfter(null, 2);
    }
    
    @Test
    public void testInsertAfterUltimaPosicion() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(2);
        lista.insertAfter(3, 1);
        int esperado = 3; 
        int real = lista.get(2);
        assertEquals(esperado, real);
    }
    
    @Test
    public void testInsertBefore() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(3);
        lista.insertBefore(2, 1);
        int esperado = 2;
        int real = lista.get(1);
        assertEquals(esperado, real);
    }
    
    @Test
    public void testInsertBeforePrimeraPosicion() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(2);
        lista.insertEnd(3);
        lista.insertBefore(1, 0);
        int esperado = 1;
        int real = lista.get(0);
        assertEquals(esperado, real);
    }
    
    @Test
    public void testInsertBeforeUltimaPosicion() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(2);
        lista.insertBefore(3, 2);
        int esperado = 3;
        int real = lista.get(2);
        assertEquals(esperado, real);
    }
    
    @Test
    public void testContains() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(2);
        lista.insertEnd(3);
        assertTrue(lista.contains(2));
    }
    
    @Test
    public void testContainsFalse() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        assertFalse(lista.contains(2));
    }
    
    @Test
    public void testGet() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        for (int i = 0; i < 12; i++) {
            lista.insertEnd(i);
        }
        int esperado = 5;
        int real = lista.get(5);
        assertEquals(esperado, real);
    }
    
    @Test (expected = DoublyLinkedListException.class)
    public void testGetFueraDeRango() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.get(4);
    }
    
    @Test
    public void testRemove() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(0);
        lista.insertEnd(1);
        lista.remove(1);
        int tamanoEsperado = 1;
        int tamanoReal = lista.size();
        int elementoEsperado = 0;
        int elementoReal = lista.get(0);
        assertEquals(tamanoEsperado, tamanoReal);
        assertEquals(elementoEsperado, elementoReal);
    }
    
    @Test
    public void testRemovePrimerElemento() {
        DoublyLinkedList<Integer> lista2 = new DoublyLinkedList<Integer>();
        lista2.insertBeginning(2);
        lista2.insertEnd(3);
        lista2.remove(0);
        int tamanoEsperado = 1;
        int tamanoReal = lista2.size();
        int elementoEsperado = 3;
        int elementoReal = lista2.get(0);
        assertEquals(tamanoEsperado, tamanoReal);
        assertEquals(elementoEsperado, elementoReal);
    }
    
    @Test
    public void testRemoveElementoIntermedio() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(0);
        lista.insertEnd(1);
        lista.insertEnd(2);
        lista.remove(1);
        int tamanoEsperado = 2;
        int tamanoReal = 2;
        int elementoPrimeroEsperado = 0;
        int elementoPrimeroReal = lista.get(0);
        int elementoUltimoEsperado = 2;
        int elementoUltimoReal = lista.get(1);
        assertEquals(tamanoEsperado, tamanoReal);
        assertEquals(elementoPrimeroEsperado, elementoPrimeroReal);
        assertEquals(elementoUltimoEsperado, elementoUltimoReal);
    }
    
    @Test
    public void testToStringVacio() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        String esperado = "[]";
        String real = lista.toString();
        assertEquals(esperado, real);
    }
    
    @Test
    public void testToStringUnElemento() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        String esperado = "[1]";
        String real = lista.toString();
        assertEquals(esperado, real);
    }
    
    @Test
    public void testToStringVariosElementos() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(2);
        lista.insertEnd(3);
        String esperado = "[1, 2, 3]";
        String real = lista.toString();
        assertEquals(esperado, real);
    }
    
    @Test
    public void testEqualsListasVacias() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> lista2 = new DoublyLinkedList<Integer>();
        assertTrue(lista.equals(lista2));
    }
    
    @Test
    public void testEqualsUnElemento() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> lista2 = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista2.insertEnd(1);
        assertTrue(lista.equals(lista2));
    }
    
    @Test
    public void testEqualsVariosElementos() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> lista2 = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(2);
        lista.insertEnd(3);
        lista2.insertBeginning(1);
        lista2.insertEnd(2);
        lista2.insertEnd(3);
        assertTrue(lista.equals(lista2));
    }
    
    @Test
    public void testEqualsListasDistintas() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> lista2 = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        lista.insertEnd(2);
        lista.insertEnd(3);
        lista2.insertBeginning(1);
        lista2.insertEnd(2);
        lista2.insertEnd(4);
        assertFalse(lista.equals(lista2));
    }
    
    @Test
    public void testEqualsObjetoDistintoDeLista() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        int[] lista2 = new int[0];
        assertFalse(lista.equals(lista2));
    }
    
    @Test
    public void testEqualsDistintoTamano() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> lista2 = new DoublyLinkedList<Integer>();
        lista.insertBeginning(1);
        assertFalse(lista.equals(lista2));
    }
    
    @Test
    public void testConstructorListaIterable() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>(list);
        assertTrue(lista instanceof DoublyLinkedList);
    }
    
    @Test
    public void testIteratorBackwards() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>(list);
        Iterator<Integer> iter = lista.iteratorBackwards();
        while(iter.hasNext()) {
            iter.next();
        }
    }
    
    @Test
    public void testRemoveIterableBorrandoPrimerElemento() {
        List<Integer> arraylist = new ArrayList<Integer>();
        arraylist.add(2);
        arraylist.add(1);
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>(arraylist);
        Iterator<Integer> iter = lista.iteratorBackwards();
        iter.next();
        iter.remove();
        int esperado = 1;
        int real = lista.size();
        assertEquals(esperado, real);
    }
    
    @Test
    public void testRemoveIterableBorrandoSegundoElemento() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(1);
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>(list);
        Iterator<Integer> iter = lista.iteratorBackwards();
        iter.next();
        iter.next();
        iter.remove();
        int esperado = 2;
        int real = lista.size();
        assertEquals(esperado, real);
    }
    
    @Test
    public void testIterator() {
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(3);
        lista.add(2);
        DoublyLinkedList<Integer> listaDoble = new DoublyLinkedList<Integer>(lista);
        Iterator<Integer> iter = listaDoble.iterator();
        while(iter.hasNext()) {
            iter.next();
        }
    }
    
    @Test
    public void testRemoveIterableBorrandoUltimoElemento() {
        List<Integer> array = new ArrayList<Integer>();
        array.add(3);
        array.add(2);
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>(array);
        Iterator<Integer> iter = lista.iteratorBackwards();
        iter.next();
        iter.next();
        iter.remove();
        int esperado = 1;
        int real = lista.size();
        assertEquals(esperado, real);
    }
}
