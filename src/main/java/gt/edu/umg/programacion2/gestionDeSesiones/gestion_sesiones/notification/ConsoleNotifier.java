/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.notification;

/**
 *
 * @author BICHO
 */
public class ConsoleNotifier implements NotificationListener {
    @Override
    public void onNotify(String topic, String message) {
        System.out.println("[NOTIF]["+ topic + "]" + message);
    }
}
