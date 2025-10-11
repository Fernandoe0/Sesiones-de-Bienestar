/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.notification;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author BICHO
 */
public class NotificationService {
    
    private static NotificationService instance;
    private final List<NotificationListener> listeners = new CopyOnWriteArrayList<>();
    
    private NotificationService(){}
    
    public static synchronized NotificationService getInstance() {
        if (instance == null) instance = new NotificationService();
        return instance;
    }
    
    public void register (NotificationListener a) { listeners.add(a);}
    public void unregister(NotificationListener a) { listeners.remove(a);}
    
    public void notify(String topic, String message) {
        for (var a : listeners) {
            try {a.onNotify(topic, message);} catch (Exception ignored) {}
        }
    }
}
