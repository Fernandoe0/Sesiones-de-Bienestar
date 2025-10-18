/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author BICHO
 */
public class IdGenerator {
  private AtomicInteger counter = new AtomicInteger(0);
  
  public int next() {
      return counter.incrementAndGet();
  }
}
