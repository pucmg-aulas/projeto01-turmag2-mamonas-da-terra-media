/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;



public class Mesa {
  
  private int numeroAssentos;
  private boolean estaDisponivel;

  public Mesa(int numeroAssentos, boolean estaDisponivel){
    this.numeroAssentos = numeroAssentos;
    this.estaDisponivel = estaDisponivel;
  }

  public int getNumeroAssentos(){
    return this.numeroAssentos;
  }
  public boolean getEstaDisponivel(){
    return this.estaDisponivel;
  }
  

  public void ocuparMesa() {
    if (this.estaDisponivel == false) {
      this.estaDisponivel = true;
    }
  }

  public void desocuparMesa() {
    if (this.estaDisponivel == true) {
      this.estaDisponivel = false;
    }
  }

}
