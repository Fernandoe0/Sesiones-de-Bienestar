/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.config;


import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.notification.ConsoleNotifier;
import gt.edu.umg.programacion2.gestionDeSesiones.gestion_sesiones.notification.NotificationService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 *
 * @author BICHO
 */
@Component
public class NotificationConfig {
    
    @PostConstruct
    public void init(){
        NotificationService.getInstance().register(new ConsoleNotifier());
    }
    
}
