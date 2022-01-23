/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import entidad.*;
/**
 *
 * @author despa
 */
public class ListaBimestre {
    private ArrayList<Bimestre> L ;

    public ListaBimestre()
    {
        L = new ArrayList<>();
    }

    public void agregar(Bimestre e)
    {
        L.add(e);
    }

   // el indexOf busca usando el equals de las clases
    public int buscar(Bimestre x)
    {
        return L.indexOf(x);
    }

    public void eliminar(int i)
    {
        L.remove(i);
    }

    public Bimestre getElemento(int i)
    {
        return L.get(i);
    }

    public int getN()
    {
        return L.size();
    }

    public void inserta(int i, Bimestre e)
    {
        L.add(i,e);
    }

    public void reemplaza(int i, Bimestre e)
    {
        L.set(i,e);
    }
}
